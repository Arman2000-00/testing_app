package com.example.testing.service.impl;

import com.example.testing.dto.request.QuestionRequest;
import com.example.testing.dto.response.QuestionResponse;
import com.example.testing.dto.response.UserResponse;
import com.example.testing.entity.Question;
import com.example.testing.mapper.QuestionMapper;
import com.example.testing.mapper.UserMapper;
import com.example.testing.repository.QuestionRepository;
import com.example.testing.service.QuestionService;
import com.example.testing.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

  private final UserService userService;
  private final UserMapper userMapper;
  private final QuestionMapper questionMapper;

  private final QuestionRepository questionRepository;

  /**
   * This method find all Question from DB
   *
   * @return List<QuestionResponse>
   */
  @Override
  public List<QuestionResponse> findAll() {
    return questionRepository.findAll()
        .stream()
        .map(questionMapper::toResponse)
        .collect(Collectors.toList());
  }

  /**
   * This method find all question By userId
   *
   * @param userId
   * @return List<QuestionResponse>
   */
  @Override
  public List<QuestionResponse> findByUserId(Long userId) {
    return questionRepository.findByUserId(userId)
        .stream()

        .map(questionMapper::toResponse)
        .collect(Collectors.toList());
  }

  /**
   * This method save question
   *
   * @param questionRequest
   */
  @Override
  public void save(QuestionRequest questionRequest) {
    if (questionRepository.countByUserId(questionRequest.getCurrentUserId()) <= 5) {
      UserResponse user = userService.findById(questionRequest.getCurrentUserId());
      Question question = questionMapper.toEntity(questionRequest);
      question.setUser(userMapper.toEntity(user));
      questionRepository.save(question);
    }
  }

  /**
   * This method find question By id
   *
   * @param id
   * @return Question
   */
  @Override
  public Question findById(Long id) {
    return questionRepository.findById(id);
  }
}
