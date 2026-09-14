package com.portfolioproject.app;

import com.portfolioproject.model.Stock;
import com.portfolioproject.model.User;
import com.portfolioproject.service.PortfolioService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("   STOCK PORTFOLIO MANAGEMENT SYSTEM");
        System.out.println("=====================================");

        System.out.print("Enter User ID: ");
        String userid = sc.nextLine();

        System.out.print("Enter User Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        User user = new User(userid, name, email);

        PortfolioService service = new PortfolioService();

        service.displayUser(user);

        System.out.print("\nEnter Stock ID: ");
        String stockid = sc.nextLine();

        System.out.print("Enter Stock Name: ");
        String stockname = sc.nextLine();

        System.out.print("Enter Stock Price: ");
        double price = sc.nextDouble();

        Stock stock = new Stock(stockid, stockname, price);

        service.addStock(stock);

        service.displayStocks();

        System.out.println("\n=====================================");
        System.out.println("Portfolio created successfully!");
        System.out.println("=====================================");

        sc.close();
    }
}


