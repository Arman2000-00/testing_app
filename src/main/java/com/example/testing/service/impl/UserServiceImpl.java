package com.example.testing.service.impl;

import com.example.testing.dto.request.LoginRequest;
import com.example.testing.dto.request.UserRequest;
import com.example.testing.dto.response.UserAuthResponse;
import com.example.testing.dto.response.UserResponse;
import com.example.testing.entity.User;
import com.example.testing.exception.EmailRepeatingException;
import com.example.testing.exception.EntityNotFoundException;
import com.example.testing.exception.IncorrectEmailException;
import com.example.testing.exception.IncorrectPasswordException;
import com.example.testing.mapper.UserMapper;
import com.example.testing.repository.impl.UserRepositoryImpl;
import com.example.testing.security.JwtTokenUtil;
import com.example.testing.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserServiceImpl implements UserService {

  private static final String EMAIL_REGEX =
      "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
  private static final String PASSWORD_REGEX =
      "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>.%]).{8,18}$";

  private final PasswordEncoder passwordEncoder;
  private final UserMapper userMapper;
  private final JwtTokenUtil jwtTokenUtil;
  private final UserRepositoryImpl userRepository;

  /**
   * @param request
   * @throws IncorrectPasswordException this method accept userRequest object type and save in DB
   *                                    check email is Present or not in DB, after that save it
   *                                    check email and password via REGEX
   */
  @Override
  public void save(UserRequest request) throws IncorrectPasswordException, IncorrectEmailException {

    if (userRepository.findByEmail(request.getEmail()) != null) {
      throw new EmailRepeatingException();
    }
    if (!request.getPassword().matches(PASSWORD_REGEX)) {
      log.error(this.getClass().getName(), IncorrectPasswordException.class);
      throw new IncorrectPasswordException();
    }
    if (!request.getEmail().matches(EMAIL_REGEX)) {
      log.error(this.getClass().getName(), IncorrectEmailException.class);
      throw new IncorrectEmailException();
    }
    request.setPassword(passwordEncoder.encode(request.getPassword()));
    userRepository.save(userMapper.toEntity(request));
  }

  /**
   * This method find User from DB by email
   *
   * @param email
   * @return UserResponse
   */
  @Override
  public UserResponse findByEmail(String email) {
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new EntityNotFoundException();
    }
    return userMapper.toResponse(user);
  }

  /**
   * This method find User from DB by id
   *
   * @param id
   * @return UserResponse
   */
  @Override
  public UserResponse findById(long id) {
    return userMapper.toResponse(userRepository.findById(id));
  }

  /**
   * This method for sign-in
   *
   * @param loginRequest
   * @return UserAuthResponse
   * @throws EntityNotFoundException
   */
  @Override
  public UserAuthResponse auth(LoginRequest loginRequest) throws EntityNotFoundException {
    try {
      User user = userRepository.findByEmail(loginRequest.getEmail());
      if (user == null) {
        log.error(this.getClass().getName(), EntityNotFoundException.class);
        throw new EntityNotFoundException();
      }
      if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
        log.error(this.getClass().getName(), IncorrectPasswordException.class);
        throw new IncorrectPasswordException();
      }
      return new UserAuthResponse(
          jwtTokenUtil.generateToken(user.getEmail()),
          userMapper.toResponse(user));
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    } catch (IncorrectPasswordException e) {
      e.printStackTrace();
    }
    return null;
  }
}
