package com.example.testing.mapper;

import com.example.testing.dto.request.QuestionRequest;
import com.example.testing.dto.response.QuestionResponse;
import com.example.testing.entity.Question;
import com.example.testing.mapper.config.BaseMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionMapper implements BaseMapper<Question, QuestionRequest, QuestionResponse> {

  private final ModelMapper modelMapper;

  @Override
  public Question toEntity(QuestionRequest questionRequest) {
    return modelMapper.map(questionRequest, Question.class);
  }

  @Override
  public QuestionResponse toResponse(Question question) {
    return modelMapper.map(question, QuestionResponse.class);
  }
}
