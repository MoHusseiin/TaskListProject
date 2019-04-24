package edu.mum.cs.wap.services;

import edu.mum.cs.wap.models.Category;
import edu.mum.cs.wap.models.Priority;
import java.util.List;

public interface ITaskService<Task> extends IService<Task> {

  public List<Task> getTaskByUserId(Integer userId);

  public List<Task> getTaskByISCompleted(Boolean isCompleted, Integer userId);

  public List<Task> getTaskByPriority(Priority priority);

  public List<Category> getAllCategories();

  public Category getCategoryById(Integer catId);

  public boolean updateCompleted(int taskId);

}
