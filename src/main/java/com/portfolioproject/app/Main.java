package com.portfolioproject.app;

import java.util.Scanner;

import com.portfolioproject.model.Holding;
import com.portfolioproject.model.MutualFund;
import com.portfolioproject.model.Stock;
import com.portfolioproject.model.User;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("   STOCK PORTFOLIO MANAGEMENT SYSTEM");
        System.out.println("======================================");

        // Create User
        System.out.println();
        System.out.println("========== CREATE USER ==========");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        User user = new User(userId, name, email);

        System.out.println("User created successfully.");

        // Add Stock
        System.out.println();
        System.out.println("========== ADD STOCK ==========");

        System.out.print("Enter Holding ID: ");
        String stockHoldingId = scanner.nextLine();

        System.out.print("Enter Stock ID: ");
        String stockId = scanner.nextLine();

        System.out.print("Enter Stock Name: ");
        String stockName = scanner.nextLine();

        System.out.print("Enter Purchase Price: ");
        double stockPurchasePrice = readPositiveDouble(scanner);

        System.out.print("Enter Current Price: ");
        double stockCurrentPrice = readPositiveDouble(scanner);

        System.out.print("Enter Quantity: ");
        double stockQuantity = readPositiveDouble(scanner);

        Stock stock = new Stock(
                stockId,
                stockName,
                stockPurchasePrice,
                stockCurrentPrice
        );

        Holding stockHolding = new Holding(
                stockHoldingId,
                stock,
                stockQuantity
        );

        user.addHolding(stockHolding);

        System.out.println("Stock holding added successfully.");

        // Add Mutual Fund
        System.out.println();
        System.out.println("======= ADD MUTUAL FUND =======");

        System.out.print("Enter Holding ID: ");
        String mutualHoldingId = scanner.nextLine();

        System.out.print("Enter Mutual Fund ID: ");
        String mutualFundId = scanner.nextLine();

        System.out.print("Enter Mutual Fund Name: ");
        String mutualFundName = scanner.nextLine();

        System.out.print("Enter Purchase Price: ");
        double mutualPurchasePrice = readPositiveDouble(scanner);

        System.out.print("Enter NAV: ");
        double nav = readPositiveDouble(scanner);

        System.out.print("Enter Exit Load (%): ");
        double exitLoad = readPositiveDouble(scanner);

        System.out.print("Enter Units: ");
        double units = readPositiveDouble(scanner);

        MutualFund mutualFund = new MutualFund(
                mutualFundId,
                mutualFundName,
                mutualPurchasePrice,
                nav,
                exitLoad
        );

        Holding mutualFundHolding = new Holding(
                mutualHoldingId,
                mutualFund,
                units
        );

        user.addHolding(mutualFundHolding);

        System.out.println("Mutual fund holding added successfully.");

        // Display User
        user.display();

        // Display Holdings
        System.out.println();
        System.out.println("========== PORTFOLIO HOLDINGS ==========");

        if (user.getHoldings().isEmpty()) {

            System.out.println("No holdings available.");

        } else {

            for (Holding holding : user.getHoldings()) {
                holding.display();
            }
        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("   PORTFOLIO PROCESS COMPLETED");
        System.out.println("======================================");

        scanner.close();
    }

    private static double readPositiveDouble(Scanner scanner) {

        while (true) {

            try {

                double value = Double.parseDouble(scanner.nextLine());

                if (value >= 0) {
                    return value;
                }

                System.out.print("Enter a positive number: ");

            } catch (NumberFormatException e) {

                System.out.print("Enter a valid number: ");
            }
        }
    }
}