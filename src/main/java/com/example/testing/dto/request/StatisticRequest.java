package com.example.testing.dto.request;

import java.util.Objects;


public class StatisticRequest {

  private Long questionId;
  private Long CurrentUserId;
  private String answer;

  public StatisticRequest() {
  }

  public StatisticRequest(Long questionId, Long currentUserId, String answer) {
    this.questionId = questionId;
    CurrentUserId = currentUserId;
    this.answer = answer;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public Long getCurrentUserId() {
    return CurrentUserId;
  }

  public void setCurrentUserId(Long currentUserId) {
    CurrentUserId = currentUserId;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatisticRequest that = (StatisticRequest) o;
    return Objects.equals(questionId, that.questionId) && Objects
        .equals(CurrentUserId, that.CurrentUserId) && Objects.equals(answer, that.answer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(questionId, CurrentUserId, answer);
  }

  @Override
  public String toString() {
    return "StatisticRequest{" +
        "questionId=" + questionId +
        ", CurrentUserId=" + CurrentUserId +
        ", answer='" + answer + '\'' +
        '}';
  }
}