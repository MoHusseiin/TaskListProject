package edu.mum.cs.wap.repository;

import edu.mum.cs.wap.models.Category;
import edu.mum.cs.wap.models.Priority;
import edu.mum.cs.wap.models.Task;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskRepo {

  private static String cmd = "";

  public static Boolean insertTask(Task task) throws SQLException {
    cmd = "INSERT INTO [dbo].[Task] "
        + "           ([Description] "
        + "           ,[AssignedTo_UserID] "
        + "           ,[CategoryID] "
        + "           ,[dueDate] "
        + "           ,[priorityID] "
        + "           ,[isCompleted] "
        + "           ,[remarks]"
        + "           ,[completedDate])"
        + "     VALUES ("
        + "'" + task.getTaskDesc() + "',"
        + "'" + task.getUser().getUserID() + "',"
        + "'" + task.getCategory().getCategoryId() + "',"
        + "'" + task.getDueDate().toString() + "',"
        + "'" + task.getPriority().getValueId() + "',"
        + "'" + task.getCompleted() + "',"
        + "'" + task.getRemarks() + "',"
        + "'" + task.getCompletedDate().toString() + "'"
        + ")";
    return DBConnection.executeNonQuery(cmd);
  }

  public static Boolean updateTask(Task task) throws SQLException {
    cmd = "UPDATE [dbo].[Task] "
        + "   SET [Description] = '" + task.getTaskDesc() + "' "
        + "      ,[AssignedTo_UserID] = '" + task.getUser().getUserID() + "' "
        + "      ,[CategoryID] = '" + task.getCategory().getCategoryId() + "' "
        + "      ,[dueDate] = '" + task.getDueDate().toString() + "' "
        + "      ,[priorityID] = '" + task.getPriority().getValueId() + "' "
        + "      ,[isCompleted] = '" + task.getCompleted() + "' "
        + "      ,[remarks] = '" + task.getRemarks() + "' "
        + "      ,[completedDate] = '" + task.getCompletedDate().toString() + "' "
        + " WHERE [TaskID] = '" + task.getTaskId() + "'";
    return DBConnection.executeNonQuery(cmd);
  }

  public static Boolean deleteTask(int taskId) throws SQLException {
    cmd = "DELETE FROM [dbo].[Task] "
        + " WHERE [TaskID] = '" + taskId + "'";
    return DBConnection.executeNonQuery(cmd);
  }

  public static List<Task> getAllTasks() throws SQLException {
    cmd = "SELECT * FROM [dbo].[Task]";
    List<Task> tasks = getListOfTasks(cmd);
    return tasks;
  }

  public static Task getTaskById(Integer taskId) throws SQLException {
    cmd = "SELECT * FROM [dbo].[Task]"
        + " WHERE [TaskID] = '" + taskId + "'";
    List<Task> tasks = getListOfTasks(cmd);

    if (tasks.size() <= 0) {
      return null;
    }
    return tasks.get(0);
  }

  public static List<Task> getTaskByUserId(Integer userId) throws SQLException{
    cmd = "SELECT * FROM [dbo].[Task]"
        + " WHERE [AssignedTo_UserID] = '" + userId + "'";
    List<Task> tasks = getListOfTasks(cmd);
    return tasks;
  }

  public static List<Task> getTaskByISCompleted(Boolean isCompleted, Integer userId) throws SQLException{
    cmd = "SELECT * FROM [dbo].[Task] WHERE [isCompleted] = '" + isCompleted + "' AND [AssignedTo_UserID] = '" + userId + "'";
    List<Task> tasks = getListOfTasks(cmd);
    return tasks;
  }

  public static List<Task> getTaskByPriority(Priority priority) throws SQLException{
    cmd = "SELECT * FROM [dbo].[Task]"
        + " WHERE [priorityID] = '" + priority.getValueId() + "'";
    List<Task> tasks = getListOfTasks(cmd);
    return tasks;
  }

  public static List<Category> getAllCategories() throws SQLException {
    cmd = "SELECT * FROM [dbo].[Category]";

    List<Category> categories = getListOfCategory(cmd);
    return categories;
  }

  public static Category getCategoryById(Integer catId) throws SQLException{
    cmd = "SELECT * FROM [dbo].[Category]"
        + " WHERE [CategoryID] = '" + catId + "'";

    List<Category> categories = getListOfCategory(cmd);
    if (categories.size() <= 0) {
      return null;
    }
    return categories.get(0);
  }

  private static List<Task> getListOfTasks(String command) throws SQLException {
    List<Task> tasks = new ArrayList<Task>();

    ResultSet rs = DBConnection.executeDBSet(cmd);

    Task task;
    while (rs.next()) {
      task = new Task(
          rs.getInt("TaskID"),
          rs.getString("Description"),
          UserRep.GetUserById(rs.getInt("AssignedTo_UserID")),
          getCategoryById(rs.getInt("CategoryID")),
          rs.getDate("dueDate").toLocalDate(),
          //Priority.values()[rs.getInt("priorityID")-1],
          Priority.getNameByCode(rs.getInt("priorityID")),
          rs.getBoolean("isCompleted"),
          rs.getString("remarks"),
          (rs.getDate("completedDate") == null)? LocalDate.of(1999,1,1) : rs.getDate("completedDate").toLocalDate()
      );
      tasks.add(task);
    }

    DBConnection.closeConnection();
    return tasks;
  }

  private static List<Category> getListOfCategory(String command) throws SQLException {
    List<Category> categories = new ArrayList<Category>();

    ResultSet rs = DBConnection.executeDBSet(command);

    Category category;
    while (rs.next()) {
      category = new Category(
          rs.getInt("CategoryID"),
          rs.getString("CategoryName")
      );
      categories.add(category);
    }

    DBConnection.closeConnection();
    return categories;
  }

  public static Boolean updateTaskCompleted(int taskId) throws SQLException {
    cmd = "UPDATE [dbo].[Task] "
        + "   SET [isCompleted] = 'true' "
        + "      ,[completedDate] = '" + LocalDate.now() + "' "
        + " WHERE [TaskID] = '" + taskId + "'";
    return DBConnection.executeNonQuery(cmd);
  }

}
