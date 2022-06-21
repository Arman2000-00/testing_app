package com.example.testing.repository.impl;

import com.example.testing.entity.Question;
import com.example.testing.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Question> findAll() {
    String sql = "select * from question";
    try {
      return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Question.class));
    } catch (DataAccessException e) {
      return new ArrayList<>();
    }
  }

  @Override
  public List<Question> findByUserId(Long userId) {
    String sql = String.format("select * from question where user_id = %s", userId);
    try {
      return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Question.class));
    } catch (DataAccessException e) {
      return new ArrayList<>();
    }
  }

  @Override
  public Question findById(Long id) {
    String sql = String.format("select * from question where id = %s", id);
    try {
      return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Question.class));
    } catch (DataAccessException e) {
      return null;
    }
  }

  @Override
  public Integer countByUserId(Long userId) {
    String sql = String.format("select count(*) from question where user_id = %s", userId);
    try {
      return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (Integer.class));
    } catch (DataAccessException e) {
      return 0;
    }
  }

  @Override
  public void save(Question question) {
    int result = jdbcTemplate.update(
        "insert into question (question,type,user_id) values (?,?,?)"
        , question.getQuestion(), question.getType().name(), question.getUser().getId());
    if (result != 1) {
      throw new RuntimeException("Question not created");
    }
  }

}
