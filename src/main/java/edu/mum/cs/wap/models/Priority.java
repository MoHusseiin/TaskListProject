package edu.mum.cs.wap.models;

public enum Priority {
  Urgent(4),
  High(3),
  Medium(2),
  Low(1);

  // declaring private variable for getting values
  private Integer periorityId;

  Priority(Integer periorityId) {
    this.periorityId = periorityId;
  }

  // getter method
  public Integer getValueId() {
    return this.periorityId;
  }

  public String getName() {
    return this.name();
  }
}
