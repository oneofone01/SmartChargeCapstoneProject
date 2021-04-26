package com.example.smartchargecapstoneproject;

public class UsersData{
    //public String userId;
    public String fullName;
    public String email;
    //private String imageURL;
    public String passwordRegister1;

    public UsersData(String userId, String fullName, String email, String imageURL, String passwordRegister1) {
        //this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        //this.imageURL = imageURL;
        this.passwordRegister1 = passwordRegister1;
    }

    public UsersData() {
    }

    /*public String getUserId() {
        return userId;
    }*/

    /*public void setUserId(String userId) {
        this.userId = userId;
    }*/

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public String getImageURL() {
        return imageURL;
    }*/

    /*public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }*/

    public String getPasswordRegister1() {
        return passwordRegister1;
    }

    public void setPasswordRegister1(String passwordRegister1) {
        this.passwordRegister1 = passwordRegister1;
    }
}
