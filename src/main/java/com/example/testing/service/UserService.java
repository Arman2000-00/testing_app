package com.example.testing.service;

import com.example.testing.dto.request.LoginRequest;
import com.example.testing.dto.request.UserRequest;
import com.example.testing.dto.response.UserAuthResponse;
import com.example.testing.dto.response.UserResponse;
import com.example.testing.exception.EntityNotFoundException;

public interface UserService {

  void save(UserRequest userRequest);

  UserResponse findByEmail(String email);

  UserResponse findById(long id);

  UserAuthResponse auth(LoginRequest loginRequest) throws EntityNotFoundException;
}
