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
        String sql = "UPDATE    User SET  UserName = '"+User.getUserName()+"', Password = '"+User.getUserName()+"', UserTypeID = "+User.getUserType().ordinal()+" Where UserID = '"+User.getUserID()+"' ";
        return( DBConnection.executeNonQuery(sql));
    }

    public  static boolean RemoveUser(User User) throws SQLException {
        String sql = "Delete From [User] Where UserID ='"+User.getUserID()+"'";
        return( DBConnection.executeNonQuery(sql));
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
}
