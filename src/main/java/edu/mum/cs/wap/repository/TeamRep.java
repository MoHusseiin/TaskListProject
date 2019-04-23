package edu.mum.cs.wap.repository;

import edu.mum.cs.wap.models.Team;
import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.models.UserType;

import javax.jws.soap.SOAPBinding;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class TeamRep  {

    public static boolean  addTeam(Team team ) throws SQLException {
        boolean result = false;

        String sql = "INSERT INTO [Team] ([TeamName] ,[ProjectName],[TeamMangerID]) VALUES ('" + team.getTeamName() + "','" + team.getProjectName() + "' , '" + team.getTeamMangerId() + "')";
        if (DBConnection.executeNonQuery(sql)) {
            int teamId =-1;

            sql = "SELECT MAX(TeamID) as TeamID From Team";
            ResultSet rs = DBConnection.executeDBSet(sql);
            while (rs.next()) {
               teamId = rs.getInt("TeamID");
            }
            DBConnection.closeConnection();

            for (int i = 0; i < team.getTeamUserIds().length; i++)
            {
                int userId = Integer.parseInt(team.getTeamUserIds()[i]);
                sql = "INSERT INTO [TeamUser] ([TeamID] ,[UserID]) VALUES ('" + teamId + "','" + userId + "' )";
                DBConnection.executeNonQuery(sql);
            }
            result = true;
        }
        return  result;
    }

    public  static boolean updateTeam(Team team ) throws SQLException {
        boolean result = false;
        String sql = "UPDATE    Team SET  TeamName = '"+team.getTeamName() +"', ProjectName = '"+team.getProjectName()+"'  Where TeamID = '"+team.getTeamId()+"' ";
        if( DBConnection.executeNonQuery(sql))
        {
            sql = "DELETE FROM [TeamUser] Where TeamID = '"+team.getTeamId()+"'";
            DBConnection.executeNonQuery(sql);

            int teamId = team.getTeamId();
            for (int i = 0; i < team.getTeamUserIds().length; i++)
            {
                int userId = Integer.parseInt(team.getTeamUserIds()[i]);
                sql = "INSERT INTO [TeamUser] ([TeamID] ,[UserID]) VALUES ('" + teamId + "','" + userId + "' )";
                DBConnection.executeNonQuery(sql);
            }
            result = true;
        }
        return  result;
    }

    public  static boolean removeTeam(Integer TeamID) throws SQLException {
        String sql = "Delete From [Team] Where TeamID ='"+TeamID+"'";
        return( DBConnection.executeNonQuery(sql));
    }

    public static List<Team> getAllTeams(Integer teamMangerId) throws SQLException {
        List<Team> Teams = new ArrayList<Team>();

        String sql= "  Select * , (Select COUNT(*) From TeamUser Where TeamUser.TeamID = Team.TeamID ) AS DeveloperNums From Team Where TeamMangerID = '"+teamMangerId+"'";
        ResultSet rs = DBConnection.executeDBSet(sql);

        while (rs.next())
        {
          Team team = new Team();

           int x=  rs.getInt("TeamID");
            team.setTeamId(rs.getInt("TeamID"));
            team.setProjectName(rs.getString("ProjectName"));
            team.setTeamName(rs.getString("TeamName"));
            team.setTeamMangerId(rs.getInt("TeamMangerID"));
            team.setDeveloperNums(rs.getInt("DeveloperNums"));
            Teams.add(team);
        }
        DBConnection.closeConnection();
        return Teams;
    }


        public static List<Team> getAllTeams() throws SQLException {
            List<Team> Teams = new ArrayList<Team>();

            String sql= "  Select * , (Select COUNT(*) From TeamUser Where TeamUser.TeamID = Team.TeamID ) AS DeveloperNums From Team";
            ResultSet rs = DBConnection.executeDBSet(sql);

            while (rs.next())
            {
                Team team = new Team();

                int x=  rs.getInt("TeamID");
                team.setTeamId(rs.getInt("TeamID"));
                team.setProjectName(rs.getString("ProjectName"));
                team.setTeamName(rs.getString("TeamName"));
                team.setTeamMangerId(rs.getInt("TeamMangerID"));
                team.setDeveloperNums(rs.getInt("DeveloperNums"));
                Teams.add(team);
            }
            DBConnection.closeConnection();
            return Teams;
        }

        public static List<User> getTeamUsers(Integer teamId) throws SQLException {
            List<User> users = new ArrayList<User>();

            String sql= "  SELECT        dbo.[User].UserID, dbo.[User].Username, dbo.[User].Password, dbo.[User].UserTypeID, dbo.[User].Name, dbo.[User].Email, dbo.[User].Phone, dbo.[User].Address, dbo.[User].LngLat, dbo.TeamUser.TeamID FROM            dbo.[User] INNER JOIN dbo.TeamUser ON dbo.[User].UserID = dbo.TeamUser.UserID WHERE        (dbo.TeamUser.TeamID = "+teamId+") ";
            ResultSet rs = DBConnection.executeDBSet(sql);

            while (rs.next())
            {
                User user = new User();
                user.setUserID(rs.getInt("UserID"));
                user.setUserName(rs.getString("UserName"));
                user.setPassword(rs.getString("Password"));
                user.setUserType(UserType.Developer);
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setPhone(rs.getString("Phone"));
                user.setAddress(rs.getString("Address"));
                user.setLngLat(rs.getString("LngLat"));
                users.add(user);
            }
            DBConnection.closeConnection();
            return users;
        }


    public static Team GetTeamByID(Integer TeamID) throws SQLException {

        String sql = "Select * From Team Where TeamID = '" + TeamID + "'";
        ResultSet rs = DBConnection.executeDBSet(sql);
        Team team = new Team();
        while (rs.next()) {
            team.setTeamId(rs.getInt("TeamID"));
            team.setProjectName(rs.getString("ProjectName"));
            team.setTeamName(rs.getString("TeamName"));
            team.setTeamMangerId(rs.getInt("TeamMangerID"));
        }
        return team;
    }


    public  static boolean addTeamUser(Team team , User user) throws SQLException {
        String sql = " INSERT INTO  [TeamUser] ([TeamID],[UserID]) VALUES ( '"+team.getTeamId()+"','"+user.getUserID()+"')";
        return( DBConnection.executeNonQuery(sql));
    }



}
