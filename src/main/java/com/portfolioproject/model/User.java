package com.portfolioproject.model;

public class User {

    private String userid;
    private String name;
    private String email;

    // Constructor
    public User(String userid, String name, String email) {
        this.userid = userid;
        this.name = name;
        this.email = email;
    }

    // Getter for user ID
    public String getUserid() {
        return userid;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for user ID
    public void setUserid(String userid) {
        this.userid = userid;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }
}