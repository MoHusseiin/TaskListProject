package edu.mum.cs.wap.repository;

import edu.mum.cs.wap.models.Team;
import edu.mum.cs.wap.models.User;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TeamRep  {

    public static boolean  addTeam(Team team) throws SQLException {
        String sql = "INSERT INTO [Team] ([TeamName] ,[ProjectName],[TeamMangerID]) VALUES ('"+team.getTeamID()+"','"+team.getTeamName()+"','"+team.getProjectName()+"')";
        return( DBConnection.executeNonQuery(sql));
    }

    public  static boolean updateTeam(Team team) throws SQLException {
        String sql = "UPDATE    Team SET  TeamName = '"+team.getTeamID()+"', ProjectName = '"+team.getTeamName()+"', TeamMangerID = '"+team.getProjectName()+"' Where TeamID = '"+team.getTeamID()+"' ";
        return( DBConnection.executeNonQuery(sql));
    }

    public  static boolean RemoveTeam(Team team) throws SQLException {
        String sql = "Delete From [Team] Where TeamID ='"+team.getTeamID()+"'";
        return( DBConnection.executeNonQuery(sql));
    }

    public static List<Team> ReteriveTeams() throws SQLException {
        List<Team> Teams = new ArrayList<Team>();

        String sql= "Select * From Team";
        ResultSet rs = DBConnection.executeDBSet(sql);

        while (rs.next())
        {
          Team team = new Team();

          team.setTeamID(rs.getInt("TeamID"));
            team.setProjectName(rs.getString("ProjectName"));
            team.setTeamName(rs.getString("TeamName"));
            team.setTeamMangerID(rs.getInt("TeamMangerID"));
            Teams.add(team);
        }
        return Teams;
    }


    public  static boolean addTeamUser(Team team , User user) throws SQLException {
        String sql = " INSERT INTO  [TeamUser] ([TeamID],[UserID])    VALUES ( '"+team.getTeamID()+"','"+user.getUserID()+"')";
        return( DBConnection.executeNonQuery(sql));
    }








}
