package com.example.bikensave;

public class UserHelperClass {
    //Adding Variables which will store user Data.

    String fullName, userName, userEmail, userPassword, userBike;
    //Empty Constructor for Firebase


    public UserHelperClass() {
    }

    //Constructors for setting User Details.
    public UserHelperClass(String fullName, String userName, String userEmail, String userPassword, String userBike) {
        this.fullName = fullName;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userBike = userBike;
    }
    //Getters and Setters for the database

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;

    }

    public String getUserBike() {
        return userBike;
    }

    public void setUserBike(String userBike) {
        this.userBike = userBike;
    }
}
