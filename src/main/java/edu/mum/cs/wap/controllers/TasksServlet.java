package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.Task;
import edu.mum.cs.wap.services.ITaskService;
import edu.mum.cs.wap.services.TaskService;
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
    //doGet(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();

    LoadAllUsers(session,request,response);
  }

  private void LoadAllUsers (HttpSession session, HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    ITaskService taskService=new TaskService();
    List<Task> tasks=taskService.GetAll();
    session.setAttribute("userTasks",tasks);
    request.getRequestDispatcher("/Task/Tasks.jsp").forward(request,response);
  }
}
