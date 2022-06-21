package com.example.testing.dto.response;

import java.util.List;
import java.util.Objects;


public class AnswerResponse {

  private Long id;

  private List<String> answers;

  private QuestionResponse questionResponse;

  private String correctAnswer;

  public AnswerResponse() {
  }

  public AnswerResponse(Long id, List<String> answers,
      QuestionResponse questionResponse, String correctAnswer) {
    this.id = id;
    this.answers = answers;
    this.questionResponse = questionResponse;
    this.correctAnswer = correctAnswer;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<String> getAnswers() {
    return answers;
  }

  public void setAnswers(List<String> answers) {
    this.answers = answers;
  }

  public QuestionResponse getQuestionResponse() {
    return questionResponse;
  }

  public void setQuestionResponse(QuestionResponse questionResponse) {
    this.questionResponse = questionResponse;
  }

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnswerResponse that = (AnswerResponse) o;
    return Objects.equals(id, that.id) && Objects.equals(answers, that.answers)
        && Objects.equals(questionResponse, that.questionResponse) && Objects
        .equals(correctAnswer, that.correctAnswer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, answers, questionResponse, correctAnswer);
  }

  @Override
  public String toString() {
    return "AnswerResponse{" +
        "id=" + id +
        ", answers=" + answers +
        ", questionResponse=" + questionResponse +
        ", correctAnswer='" + correctAnswer + '\'' +
        '}';
  }
}
