package edu.mum.cs.wap.models;

public class User
{
    private Integer UserID;
    private  String UserName;
    private String Password;
    private  UserType userType;

    public User(){

    }
    public User(Integer userID, String userName, String password, UserType userType) {
        UserID = userID;
        UserName = userName;
        Password = password;
        this.userType = userType;
    }

    public User(String userName, String password, UserType userType) {
        UserName = userName;
        Password = password;
        this.userType = userType;
    }

    public Integer getUserID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
