package edu.mum.cs.wap.services;

import edu.mum.cs.wap.models.Category;
import edu.mum.cs.wap.models.Priority;
import edu.mum.cs.wap.models.Task;
import edu.mum.cs.wap.repository.TaskRepo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskService implements ITaskService<Task> {

  @Override
  public boolean Create(Task model) {
    boolean result = false;
    try {
      result = TaskRepo.insertTask(model);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public boolean Update(Task model) {
    boolean result = false;
    try {
      result = TaskRepo.updateTask(model);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Task GetById(int taskId) {
    Task result=new Task();
    try {
      result = TaskRepo.getTaskById(taskId);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public List<Task> GetAll() {
    List<Task> result = new ArrayList<>();
    try {
      result = TaskRepo.getAllTasks();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public boolean Delete(int taskId) {
    boolean result=false;
    try {
      result = TaskRepo.deleteTask(taskId);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public List<Task> getTaskByUserId(Integer userId) {
    List<Task> result = new ArrayList<Task>();

    try {
      result = TaskRepo.getTaskByUserId(userId);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }

  public List<Task> getTaskByISCompleted(Boolean isCompleted, Integer userId)
  {
    List<Task> result = new ArrayList<Task>();

    try {
      result = TaskRepo.getTaskByISCompleted(isCompleted, userId);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public List<Task> getTaskByPriority(Priority priority) {
    List<Task> result = new ArrayList<Task>();

    try {
      result = TaskRepo.getTaskByPriority(priority);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public List<Category> getAllCategories() {
    List<Category> result = new ArrayList<>();
    try {
      result = TaskRepo.getAllCategories();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Category getCategoryById(Integer catId) {
    Category result = new Category();
    try {
      result = TaskRepo.getCategoryById(catId);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Integer numberOfCompletedTasks(Integer userId) {
    Integer result = null;
    try {
      result = TaskRepo.numberOfCompletedTasks(userId);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Integer numberOfNonCompletedTasks(Integer userId) {
    Integer result= null;
    try {
      result = TaskRepo.numberOfNonCompletedTasks(userId);
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return result;
  }
}
