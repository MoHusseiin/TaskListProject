package edu.mum.cs.wap.repository;

import java.sql.*;

public class DBConnection {

    private static Connection connection;
    private static Statement statement;

    private static void dbConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection("jdbc:sqlserver://197.44.4.216:1433;DatabaseName=Tasks","oryx", "oryx");
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
        closeConnection();
        return rs;
    }

    private static void closeConnection() {
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
