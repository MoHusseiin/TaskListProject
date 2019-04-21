package edu.mum.cs.wap.models;

import java.time.LocalDate;

public class Task {

  private Integer taskId;
  private User user;
  private String taskDesc;
  private Category category;
  private LocalDate dueDate;
  private Periority periority;
  private Boolean isCompleted;

  public Task(Integer taskId, User user, String taskDesc, Category category, LocalDate dueDate,
      Periority periority, Boolean isCompleted) {
    this.taskId = taskId;
    this.user = user;
    this.taskDesc = taskDesc;
    this.category = category;
    this.dueDate = dueDate;
    this.periority = periority;
    this.isCompleted = isCompleted;
  }

  public Integer getTaskId() {
    return taskId;
  }

  public void setTaskId(Integer taskId) {
    this.taskId = taskId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getTaskDesc() {
    return taskDesc;
  }

  public void setTaskDesc(String taskDesc) {
    this.taskDesc = taskDesc;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
  }

  public Periority getPeriority() {
    return periority;
  }

  public void setPeriority(Periority periority) {
    this.periority = periority;
  }

  public Boolean getCompleted() {
    return isCompleted;
  }

  public void setCompleted(Boolean completed) {
    isCompleted = completed;
  }
}
