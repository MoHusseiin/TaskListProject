package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.Task;
import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserDashboardServlet" , urlPatterns = {"/UserDashboard"})
public class UserDashboardServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");
        List<Task> tasks = new TaskService().getTaskByUserId(user.getUserID());
        if (tasks.size() > 0){
            tasks.sort((Task task1, Task task2) -> task2.getPriority().getValueId()-task1.getPriority().getValueId());
            request.setAttribute("leftTasks", tasks.subList(0, (tasks.size() / 2)));
            request.setAttribute("rightTasks", tasks.subList((tasks.size() / 2), tasks.size()));
        }
        List<Task> tasksNotCompleted = new TaskService().getTaskByISCompleted(false,user.getUserID());
        int notCompletedTasks = (tasksNotCompleted.size() > 0) ? tasksNotCompleted.size() : 0;
        int completedTasks = (tasks.size() > 0) ? (tasks.size() - tasksNotCompleted.size()) : 0;
        request.setAttribute("tasksNotCompleted", tasksNotCompleted);
        request.setAttribute("notCompletedTasks", notCompletedTasks);
        request.setAttribute("completedTasks", completedTasks);
        int presentage = (int) (((float)completedTasks/tasks.size()) * 100);
        request.setAttribute("completedPresentage", presentage);
        presentage = (int) (((float)notCompletedTasks/tasks.size()) * 100);
        request.setAttribute("nonCompletedPresentage", presentage);
        request.getRequestDispatcher("Users/UserDashboard.jsp").forward(request,response);
    }
}
