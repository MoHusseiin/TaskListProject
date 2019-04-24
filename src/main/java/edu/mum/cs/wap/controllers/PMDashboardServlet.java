package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.services.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PMDashboardServlet", urlPatterns = {"/PMDashboard"})
public class PMDashboardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("currentUser");
        TeamService service = new TeamService();
        Map<String, HashMap<String, Integer>> teams = service.getTeamTasks(user.getUserID());
        session.setAttribute("teams", teams);
        Integer[] arr = service.getCompletedAndNonCompletedTasks(user.getUserID());
        if(arr != null){
            request.setAttribute("notCompletedTasks", arr[0]);
            request.setAttribute("completedTasks", arr[1]);
            int presentage = (int) (((float) arr[1]/(arr[0]+arr[1])) * 100);
            request.setAttribute("completedPresentage", presentage);
            presentage = (int) (((float) arr[0]/(arr[0]+arr[1])) * 100);
            request.setAttribute("nonCompletedPresentage", presentage);
        }
        request.getRequestDispatcher("Users/PMDashboard.jsp").forward(request,response);
    }
}
