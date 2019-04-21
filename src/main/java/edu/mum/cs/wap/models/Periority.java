package edu.mum.cs.wap.models;

public enum Periority {
  Urgent(4),
  High(3),
  Medium(2),
  Low(1);

  // declaring private variable for getting values
  private Integer periorityId;

  Periority(Integer periorityId) {
    this.periorityId = periorityId;
  }

  // getter method
  public Integer getAction() {
    return this.periorityId;
  }

}
