package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.Priority;
import edu.mum.cs.wap.models.Task;
import edu.mum.cs.wap.models.Team;
import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.services.ITaskService;
import edu.mum.cs.wap.services.ITeamService;
import edu.mum.cs.wap.services.IUserService;
import edu.mum.cs.wap.services.TaskService;
import edu.mum.cs.wap.services.TeamService;
import edu.mum.cs.wap.services.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TasksReport")
public class TaskRptServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    HttpSession session = request.getSession();
    LoadAllTasks(session, request, response);
  }

  private void LoadAllTasks(HttpSession session, HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {
//    ITaskService taskSrv = new TaskService();
    IUserService userSrv = new UserService();
    ITeamService teamSrv = new TeamService();

    //User user = (User) session.getAttribute("currentUser");

    List<User> users = userSrv.GetAll();
    session.setAttribute("allUserRpt", users);

    session.setAttribute("prioritiesRpt", Priority.values());

    List<Team> teams = teamSrv.GetAll();
    session.setAttribute("allTeamsRpt", teams);

    request.getRequestDispatcher("/Report/TasksReport.jsp").forward(request, response);
  }
}
