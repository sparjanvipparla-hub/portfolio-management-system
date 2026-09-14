package com.portfolioproject.model;

public class User {
    // 1. Fields
    private String userid;
    private String name;
    private String email;

    // 2. Default Constructor
    public User() {
    }

    // 3. Parameterized Constructor
    public User(String userid, String name, String email) {
        this.userid = userid;
        this.name = name;
        this.email = email;
    }

    // 4. Getter and Setter Methods
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
