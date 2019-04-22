package edu.mum.cs.wap.repository;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.models.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRep {
    public static boolean  addUser(User User) throws SQLException {
        String sql = "INSERT INTO [User] ([UserName] ,[Password],[UserTypeID]) VALUES ('"+User.getUserName()+"','"+User.getPassword()+"',"+User.getUserType().ordinal()+")";
        return( DBConnection.executeNonQuery(sql));
    }

    public  static boolean updateUser(User User) throws SQLException {
        String sql = "UPDATE [User] SET  UserName = '"+User.getUserName()+"', Password = '"+User.getUserName()+"', UserTypeID = "+User.getUserType().ordinal()+" Where UserID = "+User.getUserID();
        return( DBConnection.executeNonQuery(sql));
    }

    public  static boolean RemoveUser(int id) throws SQLException {
        String sql = "Delete From [User] Where UserID ="+id;
        return( DBConnection.executeNonQuery(sql));
    }

    public static User GetUserById(int id) throws SQLException {

        String sql= "Select * From [User] where UserID="+id;
        ResultSet rs = DBConnection.executeDBSet(sql);
        User user=new User();
        while (rs.next())
        {
            user = new User(rs.getInt("UserID"),rs.getString("UserName"),rs.getString("Password"),UserType.values()[ rs.getInt("UserTypeID")]);


        }
        DBConnection.closeConnection();
        return user;
    }

    public static List<User> ReteriveUsers() throws SQLException {
        List<User> Users = new ArrayList<User>();

        String sql= "Select * From [User]";
        ResultSet rs = DBConnection.executeDBSet(sql);

        while (rs.next())
        {
            User User = new User();

            User.setUserID(rs.getInt("UserID"));
            User.setUserName(rs.getString("UserName"));
            User.setUserType(UserType.values()[ rs.getInt("UserTypeID")]);
            Users.add(User);
        }
        DBConnection.closeConnection();
        return Users;
    }

    public static User getUser(String userName, String password) throws SQLException {
        String sql = "Select * From [User] Where Username ='"+userName+"' AND Password = "+password;
        ResultSet rs = DBConnection.executeDBSet(sql);
        User user = null;
        while (rs.next()) {
            user = new User();
            user.setUserID(rs.getInt("UserID"));
            user.setPassword(rs.getString("Password"));
            user.setUserName(rs.getString("Username"));
            user.setUserType(UserType.values()[rs.getInt("UserTypeID")]);
        }
        DBConnection.closeConnection();
        return user;
    }
}
