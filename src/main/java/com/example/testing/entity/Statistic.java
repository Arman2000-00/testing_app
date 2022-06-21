package com.example.testing.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistic")
public class Statistic {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long userId;
  private Long questionId;
  private boolean isAnswered;

  public Statistic() {
  }

  public Statistic(Long id, Long userId, Long questionId, boolean isAnswered) {
    this.id = id;
    this.userId = userId;
    this.questionId = questionId;
    this.isAnswered = isAnswered;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getQuestionId() {
    return questionId;
  }

  public void setQuestionId(Long questionId) {
    this.questionId = questionId;
  }

  public boolean isAnswered() {
    return isAnswered;
  }

  public void setAnswered(boolean answered) {
    isAnswered = answered;
  }

  @Override
  public String toString() {
    return "Statistic{" +
        "id=" + id +
        ", userId=" + userId +
        ", questionId=" + questionId +
        ", isAnswered=" + isAnswered +
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

    Statistic statistic = (Statistic) o;

    if (isAnswered != statistic.isAnswered) {
      return false;
    }
    if (id != null ? !id.equals(statistic.id) : statistic.id != null) {
      return false;
    }
    if (userId != null ? !userId.equals(statistic.userId) : statistic.userId != null) {
      return false;
    }
    return questionId != null ? questionId.equals(statistic.questionId)
        : statistic.questionId == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (userId != null ? userId.hashCode() : 0);
    result = 31 * result + (questionId != null ? questionId.hashCode() : 0);
    result = 31 * result + (isAnswered ? 1 : 0);
    return result;
  }
}
