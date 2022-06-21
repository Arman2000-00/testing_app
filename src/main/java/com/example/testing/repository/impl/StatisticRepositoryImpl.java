package com.example.testing.repository.impl;

import com.example.testing.entity.Statistic;
import com.example.testing.repository.StatisticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StatisticRepositoryImpl implements StatisticRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public void save(Statistic statistic) {
    int result = jdbcTemplate.update(
        "insert into statistic (question_id,user_id, is_answered) values (?,?,?)"
        , statistic.getQuestionId(), statistic.getUserId(), statistic.isAnswered());
    if (result != 1) {
      throw new RuntimeException("Question not created");
    }
  }
}
