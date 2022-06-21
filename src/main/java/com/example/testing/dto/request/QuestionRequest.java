package com.example.testing.dto.request;

import com.example.testing.entity.QuestionType;
import java.util.Objects;


public class QuestionRequest {

  private Long CurrentUserId;

  private String question;

  private QuestionType type;

  public QuestionRequest() {
  }

  public QuestionRequest(Long currentUserId, String question,
      QuestionType type) {
    CurrentUserId = currentUserId;
    this.question = question;
    this.type = type;
  }

  public Long getCurrentUserId() {
    return CurrentUserId;
  }

  public void setCurrentUserId(Long currentUserId) {
    CurrentUserId = currentUserId;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public QuestionType getType() {
    return type;
  }

  public void setType(QuestionType type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuestionRequest that = (QuestionRequest) o;
    return Objects.equals(CurrentUserId, that.CurrentUserId) && Objects
        .equals(question, that.question) && type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(CurrentUserId, question, type);
  }

  @Override
  public String toString() {
    return "QuestionRequest{" +
        "CurrentUserId=" + CurrentUserId +
        ", question='" + question + '\'' +
        ", type=" + type +
        '}';
  }
}
