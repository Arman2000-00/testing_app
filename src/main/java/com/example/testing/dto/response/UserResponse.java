package com.example.testing.dto.response;

import com.example.testing.entity.UserRole;
import java.util.Objects;


public class UserResponse {

  private Long id;
  private String name;
  private String surname;
  private String email;
  private UserRole role;

  public UserResponse(Long id, String name, String surname, String email,
      UserRole role) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.role = role;
  }

  public UserResponse() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
    UserResponse that = (UserResponse) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name)
        && Objects.equals(surname, that.surname) && Objects
        .equals(email, that.email) && role == that.role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, email, role);
  }

  @Override
  public String toString() {
    return "UserResponse{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", surname='" + surname + '\'' +
        ", email='" + email + '\'' +
        ", role=" + role +
        '}';
  }
}
