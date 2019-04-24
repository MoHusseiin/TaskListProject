package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.*;
import edu.mum.cs.wap.services.ITaskService;
import edu.mum.cs.wap.services.ITeamService;
import edu.mum.cs.wap.services.IUserService;
import edu.mum.cs.wap.services.TaskService;
import edu.mum.cs.wap.services.TeamService;
import edu.mum.cs.wap.services.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
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
        ITaskService taskSrv = new TaskService();

        HttpSession session = request.getSession();

        String user = request.getParameter("user");
        String priority = request.getParameter("priority");
        String team = request.getParameter("team");

        String rdUsers = request.getParameter("rdUsers");
        String rdPriority = request.getParameter("rdPriority");
        String rdTeams = request.getParameter("rdTeams");

        List<Task> tasks = (session.getAttribute("allTasks") != null) ? (List<Task>) session.getAttribute("allTasks") : new ArrayList<>();
        if (user != null) {
            Integer userId = Integer.parseInt(user);
            tasks = tasks.stream()
                    .filter(x -> x.getUser().getUserID().equals(userId))
                    .collect(Collectors.toList());
            if (rdUsers == "asc")
                tasks.sort(Comparator.comparing(t -> t.getUser().getUserName()));
            else
                tasks.stream().sorted((x, y) -> y.getUser().getUserName().compareTo(x.getUser().getUserName()));

            session.setAttribute("allTasksRpt", tasks);
            request.getRequestDispatcher("/Report/TasksReport.jsp").forward(request, response);

        } else if (priority != null) {
            Integer priorityId = Integer.parseInt(priority);
            tasks = tasks.stream()
                    .filter(x -> x.getPriority().equals(Priority.getNameByCode(priorityId)))
                    .collect(Collectors.toList());
            if (rdPriority == "asc")
                tasks.sort(Comparator.comparingInt(t -> t.getPriority().getValueId()));
            else
                tasks.sort((t1, t2) -> t2.getPriority().getValueId() - t1.getPriority().getValueId());
            session.setAttribute("allTasksRpt", tasks);
            request.getRequestDispatcher("/Report/TasksReport.jsp").forward(request, response);

        } else if (team != null) {
            Integer teamId = Integer.parseInt(team);
            tasks = taskSrv.getTaskByTeamId(teamId);

            session.setAttribute("allTasksRpt", tasks);
            request.getRequestDispatcher("/Report/TasksReport.jsp").forward(request, response);

        } else {
            LoadAllTasks(session, request, response);

        }
    }

    private void LoadAllTasks(HttpSession session, HttpServletRequest request,
                              HttpServletResponse response) throws ServletException, IOException {
        ITaskService taskSrv = new TaskService();
        IUserService userSrv = new UserService();
        ITeamService teamSrv = new TeamService();

        User user = (User) session.getAttribute("currentUser");
        List<Task> tasks = taskSrv.GetAll();
        session.setAttribute("allTasksRpt", tasks);
        session.setAttribute("allTasks", tasks);

        List<User> users = userSrv.GetAll();
        users = users.stream()
                .filter(x -> x.getUserType().equals(UserType.Developer))
                .collect(Collectors.toList());
        session.setAttribute("allUserRpt", users);

        session.setAttribute("prioritiesRpt", Priority.values());

        List<Team> teams = teamSrv.GetAll();
        teams = teams.stream()
                .filter(x -> x.getTeamMangerId() == user.getUserID())
                .collect(Collectors.toList());
        session.setAttribute("allTeamsRpt", teams);

        request.getRequestDispatcher("/Report/TasksReport.jsp").forward(request, response);
    }
}