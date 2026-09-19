package com.portfolioproject.app;

import java.util.Scanner;

import com.portfolioproject.model.Holding;
import com.portfolioproject.model.MutualFund;
import com.portfolioproject.model.Stock;
import com.portfolioproject.model.User;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User user = null;

        while (true) {

            System.out.println();
            System.out.println("===== PORTFOLIO MANAGEMENT SYSTEM =====");
            System.out.println("1. Create User");
            System.out.println("2. Add Stock");
            System.out.println("3. Add Mutual Fund");
            System.out.println("4. Display User");
            System.out.println("5. Display Holdings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    user = new User(userId, name, email);

                    System.out.println("User created successfully.");

                    break;

                case 2:

                    if (user == null) {
                        System.out.println("Please create a user first.");
                        break;
                    }

                    System.out.print("Enter Stock Name: ");
                    String stockName = scanner.nextLine();

                    double stockQuantity;
                    double purchasePrice;
                    double currentPrice;

                    try {

                        System.out.print("Enter Quantity: ");
                        stockQuantity = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter Purchase Price: ");
                        purchasePrice = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter Current Price: ");
                        currentPrice = Double.parseDouble(scanner.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid number entered.");
                        break;
                    }

                    Stock stock = new Stock(
                            stockName,
                            stockQuantity,
                            purchasePrice,
                            currentPrice
                    );

                    Holding stockHolding = new Holding(
                            stock,
                            stockQuantity
                    );

                    user.addHolding(stockHolding);

                    System.out.println("Stock added successfully.");

                    break;

                case 3:

                    if (user == null) {
                        System.out.println("Please create a user first.");
                        break;
                    }

                    System.out.print("Enter Mutual Fund Name: ");
                    String fundName = scanner.nextLine();

                    double units;
                    double nav;
                    double exitLoad;

                    try {

                        System.out.print("Enter Units: ");
                        units = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter NAV: ");
                        nav = Double.parseDouble(scanner.nextLine());

                        System.out.print("Enter Exit Load (%): ");
                        exitLoad = Double.parseDouble(scanner.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println("Invalid number entered.");
                        break;
                    }

                    MutualFund mutualFund = new MutualFund(
                            fundName,
                            units,
                            nav,
                            exitLoad
                    );

                    Holding mutualFundHolding = new Holding(
                            mutualFund,
                            units
                    );

                    user.addHolding(mutualFundHolding);

                    System.out.println("Mutual Fund added successfully.");

                    break;

                case 4:

                    if (user == null) {
                        System.out.println("No user has been created.");
                    } else {
                        System.out.println();
                        System.out.println("===== USER DETAILS =====");
                        System.out.println(user);
                    }

                    break;

                case 5:

                    if (user == null) {
                        System.out.println("Please create a user first.");
                    } else {
                        user.displayInvestments();
                    }

                    break;

                case 6:

                    System.out.println("Exiting Portfolio Management System.");

                    scanner.close();

                    return;

                default:

                    System.out.println("Invalid choice. Enter a number from 1 to 6.");
            }
        }
    }
}

