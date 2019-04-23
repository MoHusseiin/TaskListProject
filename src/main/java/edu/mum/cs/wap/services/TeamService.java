package edu.mum.cs.wap.services;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.repository.TeamRep;
import edu.mum.cs.wap.models.Team;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeamService implements ITeamService<Team>  {

    public boolean Create(Team model) {
        boolean result= false;
        try
        {

            result= TeamRep.addTeam(model);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    public boolean Update(Team model) {
        boolean result= false;
        try
        {
            result= TeamRep.updateTeam(model);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

   // @Override
    public Team GetById(int id) {
        Team team = new Team();
        try
        {
            team= TeamRep.GetTeamByID(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return team;
    }

    public List<Team> GetAll(int id) {
        List<Team> Teams = new ArrayList<Team>();
        try {
            Teams = TeamRep.getAllTeams(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Teams;
    }
    // @Override
    public List<Team> GetAll() {
        List<Team> Teams = new ArrayList<Team>();
        try {
            Teams = TeamRep.getAllTeams();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Teams;
    }


    public List<User> GetTeamUsers(int id) {
        List<User> users = new ArrayList<User>();
        try {
            users = TeamRep.getTeamUsers(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public  HashMap<String , HashMap<String , Integer>> getTeamTasks(Integer teamManagerID) {
        HashMap<String, HashMap<String, Integer>> teamMap = new HashMap<>();
        try {
            teamMap = TeamRep.getTeamTasks(teamManagerID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamMap;
    }





   // @Override
    public boolean Delete(int id) {
        boolean result = false;

        try
        {
            result=  TeamRep.removeTeam(id);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}
