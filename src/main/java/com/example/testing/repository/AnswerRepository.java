package com.example.testing.repository;

import com.example.testing.entity.Answer;
import java.util.List;

public interface AnswerRepository {

  List<Answer> findAll();

  Answer findByQuestionId(Long questionId);

  void save(Answer answer);
}
