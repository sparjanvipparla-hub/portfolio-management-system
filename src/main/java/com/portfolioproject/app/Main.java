package com.portfolioproject.app;

import com.portfolioproject.model.User;

public class Main {

    public static void main(String[] args) {
        System.out.println("===============================");
        System.out.println("Portfolio Management Project");
        System.out.println("===============================");
        
        // Demo user values with rishi
        User user = new User("user-1234", "rishi", "rishi@gmail.com");
                                                                                                                                                                                                                                                    
        System.out.println("User ID: " + user.getUserid());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
    }

}