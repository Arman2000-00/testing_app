package com.example.testing.repository.impl;

import com.example.testing.entity.User;
import com.example.testing.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public User findByEmail(String email) {
    String sql = String.format("select * from system_user where email = '%s'", email);
    try {
      return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
    } catch (DataAccessException e) {
      return null;
    }
  }

  @Override
  public User findById(Long id) {
    String sql = String.format("select * from system_user where id = %s", id);
    try {
      return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
    } catch (DataAccessException e) {
      return null;
    }
  }

  @Override
  public void save(User user) {
    int result = jdbcTemplate.update(
        "insert into system_user (name,surname,email,password,role) values (?,?,?,?,?)"
        , user.getName(), user.getSurname(), user.getEmail(), user.getPassword(),
        user.getRole().name());
    if (result == 1) {

    }
  }

}
