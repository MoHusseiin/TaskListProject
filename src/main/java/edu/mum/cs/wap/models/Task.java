package edu.mum.cs.wap.models;

import java.time.LocalDate;
import java.time.Period;

public class Task {

  private Integer taskId;
  private String taskDesc;
  private User user;
  private Category category;
  private LocalDate dueDate;
  private Priority priority;
  private Boolean isCompleted;
  private String remarks;
  private LocalDate completedDate;

  private String isChecked;

  public Task()
  {

  }

  public Task(Integer taskId, String taskDesc, User user, Category category, LocalDate dueDate,
      Priority priority, Boolean isCompleted, String remarks,LocalDate completedDate) {
    this.taskId = taskId;
    this.taskDesc = taskDesc;
    this.user = user;
    this.category = category;
    this.dueDate = dueDate;
    this.priority = priority;
    this.isCompleted = isCompleted;
    this.remarks = remarks;
    this.completedDate = completedDate;

    if(isCompleted)
      this.isChecked = "checked";
    else
      this.isChecked = "";
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

  public Priority getPriority() {
    return priority;
  }

  public void setPriority(Priority priority) {
    this.priority = priority;
  }

  public Boolean getCompleted() {
    return isCompleted;
  }

  public void setCompleted(Boolean completed) {
    isCompleted = completed;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public LocalDate getCompletedDate() {
    return completedDate;
  }

  public void setCompletedDate(LocalDate completedDate) {
    this.completedDate = completedDate;
  }

  public String getIsChecked() {
    return isChecked;
  }

  public void setIsChecked(String isChecked) {
    this.isChecked = isChecked;
  }

  public int calculatedDaysNum() {
    return Period.between(LocalDate.now(), this.dueDate).getDays();
  }
}
