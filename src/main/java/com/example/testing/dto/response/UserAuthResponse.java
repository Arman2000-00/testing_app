package com.example.testing.dto.response;

import java.util.Objects;

public class UserAuthResponse {

  private String token;

  private UserResponse userResponse;

  public UserAuthResponse() {
  }

  public UserAuthResponse(String token, UserResponse userResponse) {
    this.token = token;
    this.userResponse = userResponse;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAuthResponse that = (UserAuthResponse) o;
    return Objects.equals(token, that.token) && Objects
        .equals(userResponse, that.userResponse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, userResponse);
  }

  public UserResponse getUserResponse() {
    return userResponse;
  }

  public void setUserResponse(UserResponse userResponse) {
    this.userResponse = userResponse;
  }

  @Override
  public String toString() {
    return "UserAuthResponse{" +
        "token='" + token + '\'' +
        ", userResponse=" + userResponse +
        '}';
  }
}
