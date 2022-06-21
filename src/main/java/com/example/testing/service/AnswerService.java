package com.example.testing.service;

import com.example.testing.dto.request.AnswerRequest;
import com.example.testing.dto.response.AnswerResponse;
import java.util.List;

public interface AnswerService {

  List<AnswerResponse> findAll();

  AnswerResponse findByQuestionId(Long userId);

  void save(AnswerRequest answerRequest);
}
