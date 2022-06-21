package com.example.testing.entity;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ElementCollection(fetch = FetchType.EAGER)
  @CollectionTable(name = "answers_list", joinColumns = @JoinColumn(name = "id"))
  private List<String> answers;
  private String correctAnswer;
  @OneToOne(fetch = FetchType.EAGER)
  private Question question;

  public Answer() {
  }

  public Answer(Long id, List<String> answers, String correctAnswer, Question question) {
    this.id = id;
    this.answers = answers;
    this.correctAnswer = correctAnswer;
    this.question = question;
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

  public String getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(String correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public Question getQuestion() {
    return question;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }

  @Override
  public String toString() {
    return "Answer{" +
        "id=" + id +
        ", answers=" + answers +
        ", correctAnswer='" + correctAnswer + '\'' +
        ", question=" + question +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Answer answer = (Answer) o;

    if (id != null ? !id.equals(answer.id) : answer.id != null) {
      return false;
    }
    if (answers != null ? !answers.equals(answer.answers) : answer.answers != null) {
      return false;
    }
    if (correctAnswer != null ? !correctAnswer.equals(answer.correctAnswer)
        : answer.correctAnswer != null) {
      return false;
    }
    return question != null ? question.equals(answer.question) : answer.question == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (answers != null ? answers.hashCode() : 0);
    result = 31 * result + (correctAnswer != null ? correctAnswer.hashCode() : 0);
    result = 31 * result + (question != null ? question.hashCode() : 0);
    return result;
  }
}
