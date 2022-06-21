package com.example.testing.service.impl;

import com.example.testing.dto.request.AnswerRequest;
import com.example.testing.dto.response.AnswerResponse;
import com.example.testing.dto.response.UserResponse;
import com.example.testing.entity.Answer;
import com.example.testing.entity.Question;
import com.example.testing.entity.UserRole;
import com.example.testing.mapper.AnswerMapper;
import com.example.testing.repository.AnswerRepository;
import com.example.testing.service.AnswerService;
import com.example.testing.service.QuestionService;
import com.example.testing.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

  private final AnswerRepository answerRepository;
  private final AnswerMapper answerMapper;
  private final QuestionService questionService;
  private final UserService userService;

  /**
   * This method get all answers from DB
   *
   * @return List<Answer>
   */
  @Override
  public List<AnswerResponse> findAll() {
    return answerRepository.findAll()
        .stream()
        .map(answerMapper::toResponse)
        .collect(Collectors.toList());
  }

  /**
   * This method find answerByQuestionId
   *
   * @param questionId
   * @return Answer
   */
  @Override
  public AnswerResponse findByQuestionId(Long questionId) {
    return answerMapper.toResponse(answerRepository.findByQuestionId(questionId));
  }

  /**
   * This method accept answerRequest map it to answer and save DB
   *
   * @param answerRequest
   */
  @Override
  public void save(AnswerRequest answerRequest) {
    UserResponse user = userService.findById(answerRequest.getCurrentUserId());
    if (user.getRole() == UserRole.ADMIN) {
      answerRequest.setCorrectAnswer(answerRequest.getCorrectAnswer());
    }
    if (user.getRole() == UserRole.USER || user.getRole() == UserRole.STUDENT) {
      answerRequest.setCorrectAnswer(null);
    }
    Question question = questionService.findById(answerRequest.getQuestionId());
    Answer answer = answerMapper.toEntity(answerRequest);
    answer.setQuestion(question);
    answerRepository.save(answer);
  }
}
