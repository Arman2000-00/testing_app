package com.example.testing.dto.response;

import java.util.Objects;

public class QuestionResponse {

  private Long id;
  private String question;

  public QuestionResponse() {
  }

  public QuestionResponse(Long id, String question) {
    this.id = id;
    this.question = question;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QuestionResponse that = (QuestionResponse) o;
    return Objects.equals(id, that.id) && Objects.equals(question, that.question);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, question);
  }

  @Override
  public String toString() {
    return "QuestionResponse{" +
        "id=" + id +
        ", question='" + question + '\'' +
        '}';
  }
}
