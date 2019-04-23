package edu.mum.cs.wap.controllers;

import edu.mum.cs.wap.models.User;

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
        Map<String, Map<String, Integer>> teams = new HashMap<>();
        Map<String, Integer> m = new HashMap<>();
        m.put("User1", 44);
        m.put("User2", 64);
        teams.put("team1", m);
        m = new HashMap<>();
        m.put("User1", 45);
        teams.put("team2", m);
        m = new HashMap<>();
        m.put("User1", 88);
        m.put("User2", 49);
        teams.put("team3", m);
        session.setAttribute("teams", teams);
        request.getRequestDispatcher("Users/PMDashboard.jsp").forward(request,response);
    }
}
