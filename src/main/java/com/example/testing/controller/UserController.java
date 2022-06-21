package com.example.testing.controller;

import com.example.testing.dto.request.LoginRequest;
import com.example.testing.dto.request.UserRequest;
import com.example.testing.dto.response.UserAuthResponse;
import com.example.testing.dto.response.UserResponse;
import com.example.testing.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService userService;

  @ApiOperation(value = "save user")
  @PostMapping
  public ResponseEntity<HttpStatus> save(@RequestBody UserRequest userRequest) {
    userService.save(userRequest);
    return ResponseEntity.ok(HttpStatus.OK);
  }

  @ApiOperation(value = "find User by email")
  @GetMapping("/email")
  public ResponseEntity<UserResponse> findByEmail(@RequestParam("email") String email) {
    return ResponseEntity.ok(userService.findByEmail(email));
  }

  @ApiOperation(value = "sign-in user")
  @PostMapping("/login")
  public ResponseEntity<UserAuthResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(userService.auth(request));
  }


}
