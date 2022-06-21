package com.example.testing.security;

import com.example.testing.dto.response.UserResponse;
import com.example.testing.entity.User;
import com.example.testing.mapper.UserMapper;
import com.example.testing.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class CurrentUserDetailServiceImpl implements UserDetailsService {

  private final UserMapper userMapper;

  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserResponse byEmail = userService.findByEmail(email);
    User user = userMapper.toEntity(byEmail);
    if (user == null) {
      log.error(this.getClass().getName(), UsernameNotFoundException.class);
      throw new UsernameNotFoundException("Username not found");
    }
    return new CurrentUser(user);
  }
}
