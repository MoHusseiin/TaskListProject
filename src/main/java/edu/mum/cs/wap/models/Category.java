package edu.mum.cs.wap.models;

public class Category {

  private Integer categoryId;
  private String categoryName;

  public Category()
  {

  }

  public Category(int categoryId,String categoryName)
  {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
