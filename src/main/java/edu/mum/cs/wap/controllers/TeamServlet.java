package edu.mum.cs.wap.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import edu.mum.cs.wap.models.Team;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.models.UserType;
import edu.mum.cs.wap.repository.TeamRep;
import edu.mum.cs.wap.services.ITeamService;
import edu.mum.cs.wap.services.IUserService;
import edu.mum.cs.wap.services.TeamService;
import edu.mum.cs.wap.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Teams")

public class TeamServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ITeamService teamService=new TeamService();
        HttpSession  session=request.getSession();

        String teamId= request.getParameter("teamId");
        String teamName=request.getParameter("teamName");
        String projectName=request.getParameter("projectName");
        User user = (User)session.getAttribute("currentUser");

        Integer projectMangerId= user.getUserID();  //request.getParameter("projectMangerId");
        Team team;
        String [] teamUserIds =  request.getParameterValues("teamUserIds");

        if(teamId.isEmpty()){

            team=new Team(projectName,teamName,projectMangerId , teamUserIds);
            teamService.Create(team );
            response.sendRedirect("Teams");
        }

        else {
             team=new Team(Integer.parseInt(teamId),projectName,teamName, projectMangerId , teamUserIds);
            teamService.Update(team);
            response.sendRedirect("Teams");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession  session = request.getSession();
        String addNewTeam =request.getParameter("addNewTeam");
        String updateTeam=request.getParameter("updateTeam");
        String teamMapId= request.getParameter("teamMapId");


        IUserService userService =new UserService();
        List<User> users =userService.GetAll();
        session.setAttribute("users",users);


        if(addNewTeam != null)
        {

            session.setAttribute("team",new Team());
            request.getRequestDispatcher("Teams/AddTeam.jsp").forward(request,response);

        }
        else  if(updateTeam != null)
        {
            int id=Integer.parseInt(updateTeam);
            ITeamService teamService = new TeamService();
            Team team=((TeamService) teamService).GetById(id);
            session.setAttribute("team",team);
            request.getRequestDispatcher("Teams/AddTeam.jsp").forward(request,response);
        }
        else if(teamMapId !=null)
        {

            Integer teamId = 29;
            ITeamService teamService = new TeamService();
            List<User> teamUsers = ((TeamService) teamService).GetTeamUsers(teamId);
            response.setContentType("application/json");
            response.getWriter().print(teamUsers);

//            String [] arr = new String[3];
//            arr[0] ="Karim Bayoumi";
//            arr[1] ="65.197436";
//            arr[2] ="20.801563";

        }
        else
        {
            LoadTeams(session,request,response);
        }
    }

    private void LoadTeams(HttpSession session , HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        User user = (User)session.getAttribute("currentUser");
        int projectMangerId1= user.getUserID();

        ITeamService teamService =new TeamService();
        List<Team> teams=((TeamService) teamService).GetAll(projectMangerId1);

        session.setAttribute("teams",teams);
        request.getRequestDispatcher("Teams/Team.jsp").forward(request,response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ITeamService teamService =new TeamService();
        HttpSession  session=request.getSession();

        String teamId=request.getParameter("teamId");
        if(!teamId.isEmpty()){
            Integer id=Integer.parseInt(teamId);
            boolean result= teamService.Delete(id);
            response.setContentType("application/json");
            PrintWriter out=response.getWriter();
            out.print(result);
        }
    }
}
