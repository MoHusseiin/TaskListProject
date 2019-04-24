package edu.mum.cs.wap.models;

public class User {
    private Integer UserID;
    private String UserName;
    private String Password;
    private UserType userType;
    private String Name;
    private String Email;
    private String Phone;
    private String Address;
    private String LngLat;

    public User() {

    }

    public User(Integer userID, String userName, String password, UserType userType, String name, String email, String phone, String address, String lngLat) {
        UserID = userID;
        UserName = userName;
        Password = password;
        this.userType = userType;
        Name = name;
        Email = email;
        Phone = phone;
        Address = address;
        LngLat = lngLat;
    }

    public User(String userName, String password, UserType userType, String name, String email, String phone, String address, String lngLat) {
        UserName = userName;
        Password = password;
        this.userType = userType;
        Name = name;
        Email = email;
        Phone = phone;
        Address = address;
        LngLat = lngLat;
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

    public Integer getUserTypeId() {
        return (userType==null)?-1:userType.ordinal();
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getLngLat() {
        return LngLat;
    }

    public void setLngLat(String lngLat) {
        LngLat = lngLat;
    }
}

 