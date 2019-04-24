package edu.mum.cs.wap.repository;

import edu.mum.cs.wap.models.User;
import edu.mum.cs.wap.models.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRep {
    public static boolean  addUser(User User) throws SQLException {
        String sql = "INSERT INTO [User] ([UserName] ,[Password],[UserTypeID],[Name],[Email],[Phone],[Address],[LngLat]) VALUES ('"+User.getUserName()+"','"+User.getPassword()+"',"+User.getUserType().ordinal()+",'"+User.getName()+"','"+User.getEmail()+"','"+User.getPhone()+"','"+User.getAddress()+"','"+User.getLngLat()+"')";
        return( DBConnection.executeNonQuery(sql));
    }

    public  static boolean updateUser(User User) throws SQLException {
        String sql = "UPDATE [User] SET  UserName = '"+User.getUserName()+"', Password = '"+User.getPassword()+"', UserTypeID = "+User.getUserType().ordinal()+", Name = '"+User.getName()+"' , Email = '"+User.getEmail()+"', Phone = '"+User.getPhone()+"', Address = '"+User.getAddress()+"', LngLat = '"+User.getLngLat()+"' Where UserID = "+User.getUserID();
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
            user = new User(rs.getInt("UserID"),rs.getString("UserName"),rs.getString("Password"),UserType.values()[ rs.getInt("UserTypeID")],rs.getString("Name"),rs.getString("Email"),rs.getString("Phone"),rs.getString("Address"),rs.getString("LngLat"));


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
            User.setName(rs.getString("Name"));
            User.setEmail(rs.getString("Email"));
            User.setPhone(rs.getString("Phone"));
            User.setAddress(rs.getString("Address"));
            User.setLngLat(rs.getString("LngLat"));

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
            user = new User(rs.getInt("UserID"),rs.getString("UserName"),rs.getString("Password"),UserType.values()[ rs.getInt("UserTypeID")],rs.getString("Name"),rs.getString("Email"),rs.getString("Phone"),rs.getString("Address"),rs.getString("LngLat"));
        }
        DBConnection.closeConnection();
        return user;
    }

    public static List<User> getUserByUserType(UserType userType) throws SQLException {
        String sql = "Select * From [User] Where UserTypeID = "+userType.ordinal();
        ResultSet rs = DBConnection.executeDBSet(sql);
        List<User> Users = new ArrayList<User>();
        User User = null;
        while (rs.next())
        {
            User = new User();

            User.setUserID(rs.getInt("UserID"));
            User.setUserName(rs.getString("UserName"));
            User.setUserType(UserType.values()[ rs.getInt("UserTypeID")]);
            User.setName(rs.getString("Name"));
            User.setEmail(rs.getString("Email"));
            User.setPhone(rs.getString("Phone"));
            User.setAddress(rs.getString("Address"));
            User.setLngLat(rs.getString("LngLat"));

            Users.add(User);
        }
        DBConnection.closeConnection();
        return Users;
    }
}
