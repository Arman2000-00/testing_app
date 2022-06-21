package com.example.testing.mapper;

import com.example.testing.dto.request.AnswerRequest;
import com.example.testing.dto.response.AnswerResponse;
import com.example.testing.entity.Answer;
import com.example.testing.mapper.config.BaseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerMapper implements BaseMapper<Answer, AnswerRequest, AnswerResponse> {

  private final ModelMapper modelMapper;
  private final QuestionMapper questionMapper;

  @Override
  public Answer toEntity(AnswerRequest answerRequest) {
    return modelMapper.map(answerRequest, Answer.class);
  }

  @Override
  public AnswerResponse toResponse(Answer answer) {
    AnswerResponse answerResponse = modelMapper.map(answer, AnswerResponse.class);
    answerResponse.setQuestionResponse(questionMapper.toResponse(answer.getQuestion()));
    return answerResponse;
  }

}
