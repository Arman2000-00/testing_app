package com.example.testing.dto.request;

import java.util.List;
import java.util.Objects;

public class AnswerRequest {

  private Long currentUserId;
  private List<String> answers;
  private String correctAnswer;
  private Long questionId;

  public AnswerRequest(Long currentUserId, List<String> answers, String correctAnswer,
      Long questionId) {
    this.currentUserId = currentUserId;
    this.answers = answers;
    this.correctAnswer = correctAnswer;
    this.questionId = questionId;
  }

  public AnswerRequest() {
  }

  public Long getCurrentUserId() {
    return currentUserId;
  }

  public void setCurrentUserId(Long currentUserId) {
    this.currentUserId = currentUserId;
  }

  public List<String> getAnswers() {
    return answers;
  }

  public void setAnswers(List<String> answers) {
    this.answers = answers;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnswerRequest that = (AnswerRequest) o;
    return Objects.equals(currentUserId, that.currentUserId) && Objects
        .equals(answers, that.answers) && Objects.equals(correctAnswer, that.correctAnswer)
        && Objects.equals(questionId, that.questionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currentUserId, answers, correctAnswer, questionId);
  }

  @Override
  public String toString() {
    return "AnswerRequest{" +
        "currentUserId=" + currentUserId +
        ", answers=" + answers +
        ", correctAnswer='" + correctAnswer + '\'' +
        ", questionId=" + questionId +
        '}';
  }
}
