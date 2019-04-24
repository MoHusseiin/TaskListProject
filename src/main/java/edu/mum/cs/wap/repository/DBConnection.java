package edu.mum.cs.wap.repository;

import java.sql.*;

public class DBConnection {

    private static Connection connection;
    private static Statement statement;

    private static void dbConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://SQL5013.site4now.net:1433;DatabaseName=DB_A27259_Tasks","DB_A27259_Tasks_admin", "Admin@wap123");
            statement = connection.createStatement();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Boolean executeNonQuery(String query) throws SQLException{
        dbConnection();
        int rows = statement.executeUpdate(query);
        closeConnection();
        if (rows > 0)
            return true;
        else
            return false;
    }

    public static ResultSet executeDBSet(String query) throws SQLException{
        dbConnection();
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }

    public static void closeConnection() {
        try{
            if(statement != null)
                connection.close();
            if(connection != null)
                connection.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }
}
