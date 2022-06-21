package com.example.testing.repository;

import com.example.testing.entity.Question;
import java.util.List;

public interface QuestionRepository {

  List<Question> findAll();

  List<Question> findByUserId(Long userId);

  Question findById(Long id);

  void save(Question question);

  Integer countByUserId(Long userId);
}
