package com.example.testing.repository.impl;

import com.example.testing.entity.Answer;
import com.example.testing.entity.Question;
import com.example.testing.repository.AnswerRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnswerRepositoryImpl implements AnswerRepository {

  private final JdbcTemplate jdbcTemplate;

  @Override
  public List<Answer> findAll() {
    String sql = "select * from answer";
    try {
      List<Answer> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Answer.class));
      for (Answer answer : query) {
        answer.setQuestion(returnQuestionByAnswerId(answer.getId()));
        answer.setAnswers(findAnswersByAnswerId(answer.getId()));
      }
      return query;
    } catch (DataAccessException e) {
      return new ArrayList<>();
    }
  }

  @Override
  public Answer findByQuestionId(Long questionId) {
    String sql = String.format("select * from answer where question_id = %s", questionId);
    try {
      Answer answer = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Answer.class));
      if (answer != null) {
        answer.setQuestion(returnQuestionByAnswerId(answer.getId()));
        answer.setAnswers(findAnswersByAnswerId(answer.getId()));
      }
      return answer;
    } catch (DataAccessException e) {
      return null;
    }
  }

  @Override
  public void save(Answer answer) {
    String sql = "insert into answer (correct_answer,question_id) values (?,?)";
    KeyHolder key = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {

      @Override
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        final PreparedStatement ps = connection.prepareStatement(sql,
            Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, answer.getCorrectAnswer());
        ps.setLong(2, answer.getQuestion().getId());
        return ps;
      }
    }, key);
    Long id = (Long) key.getKeys().get("id");
    if (id != 0) {
      String correctAnswer = answer.getCorrectAnswer();
      List<String> answers = answer.getAnswers();
      if (!answers.contains(correctAnswer.toLowerCase(Locale.ROOT))) {
        answer.getAnswers().add(answer.getCorrectAnswer());
      }
      answer.getAnswers().forEach(obj -> {
        jdbcTemplate
            .update("INSERT INTO answers_list(id,answers) values (?,?)", id,
                obj);
      });
    } else {
      throw new RuntimeException("Answer is not created");
    }

  }

  private Question returnAnswersQuestion(Long questionId) {
    return jdbcTemplate
        .queryForObject("select from question where id = " + questionId,
            new BeanPropertyRowMapper<>(
                Question.class));
  }

  private Question returnQuestionByAnswerId(Long answerId) {
    String format = String.format(
        "select * from question where id=(select answer.question_id from answer where id = %s)",
        answerId);
    return jdbcTemplate
        .queryForObject(format, new BeanPropertyRowMapper<>(Question.class));
  }

  private List<String> findAnswersByAnswerId(Long answerId) {
    String answersQuery = String
        .format("select answers from answers_list where answers_list.id = %s", answerId);
    return jdbcTemplate
        .queryForList(answersQuery, String.class);
  }

}
