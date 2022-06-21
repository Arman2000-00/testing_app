package com.example.testing.dto.request;

import com.example.testing.entity.UserRole;
import java.util.Objects;


public class UserRequest {

  private String name;

  private String surname;

  private String email;

  private String password;

  private UserRole role;

  public UserRequest() {
  }

  public UserRequest(String name, String surname, String email, String password,
      UserRole role) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRequest that = (UserRequest) o;
    return Objects.equals(name, that.name) && Objects
        .equals(surname, that.surname) && Objects.equals(email, that.email)
        && Objects.equals(password, that.password) && role == that.role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, email, password, role);
  }

  @Override
  public String toString() {
    return "UserRequest{" +
        "name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        ", role=" + role +
        '}';
  }
}
