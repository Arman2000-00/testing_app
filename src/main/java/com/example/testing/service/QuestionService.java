package com.example.testing.service;

import com.example.testing.dto.request.QuestionRequest;
import com.example.testing.dto.response.QuestionResponse;
import com.example.testing.entity.Question;
import java.util.List;

public interface QuestionService {

  List<QuestionResponse> findAll();

  List<QuestionResponse> findByUserId(Long userId);

  void save(QuestionRequest questionRequest);

  Question findById(Long id);
}
