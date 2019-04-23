package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.Category;
import edu.mum.cs.wap.models.Priority;
import edu.mum.cs.wap.models.Task;
import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.services.ITaskService;
import edu.mum.cs.wap.services.TaskService;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

@WebServlet(name = "TasksServlet", urlPatterns = {"/Tasks"})
public class TasksServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    ITaskService taskService = new TaskService();
    HttpSession  session = request.getSession();

    String taskID = request.getParameter("taskId");
    User user = (User) session.getAttribute("currentUser");
    Category cat = taskService.getCategoryById(Integer.parseInt(request.getParameter("taskCategory")));
    String priID = request.getParameter("taskPriority");
    Priority pri = Priority.getNameByCode(Integer.parseInt(priID));

    Task task = new Task(
        (taskID.isEmpty())? 0 : Integer.parseInt(request.getParameter("taskId")),
        request.getParameter("TaskName"),
        user,
        cat,
        LocalDate.parse(request.getParameter("dueDate")),
        pri,
        Boolean.parseBoolean(request.getParameter("IsCompleted")),
        request.getParameter("comments"),
        LocalDate.parse(request.getParameter("completedDate"))
    );

    if(taskID.isEmpty() || taskID.equals("0")){
      taskService.Create(task);
    }
    else {
      taskService.Update(task);
    }
    response.sendRedirect("Tasks");
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();

    String addNewTask = request.getParameter("addNewTask");
    String updateTask = request.getParameter("updateTask");

    if(addNewTask != null || updateTask != null) {
      ITaskService userService = new TaskService();
      List<Category> categories = userService.getAllCategories();
      session.setAttribute("categories", categories);
      session.setAttribute("priorities", Priority.values());

      if (addNewTask != null) {
        session.setAttribute("task", new Task());
        request.getRequestDispatcher("Task/AddEditTask.jsp").forward(request, response);
      } else if (updateTask != null) {
        int taskId = Integer.parseInt(updateTask);

        Task task = (Task) userService.GetById(taskId);
        session.setAttribute("task", task);
        request.getRequestDispatcher("Task/AddEditTask.jsp").forward(request, response);
      }
    }else {
      LoadAllTaskByUser(session, request, response);
    }
  }

  private void LoadAllTaskByUser(HttpSession session, HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
    ITaskService taskService = new TaskService();
    User user = (User) session.getAttribute("currentUser");
    List<Task> tasks = taskService.getTaskByUserId(user.getUserID());
    session.setAttribute("userTasks", tasks);
    request.getRequestDispatcher("/Task/Tasks.jsp").forward(request, response);
  }
}
