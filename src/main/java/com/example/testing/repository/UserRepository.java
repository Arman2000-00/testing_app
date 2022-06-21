package com.example.testing.repository;

import com.example.testing.entity.User;

public interface UserRepository {

  User findByEmail(String email);

  User findById(Long id);

  void save(User user);
}
