package com.portfolioproject.app;

import java.util.ArrayList;
import java.util.List;
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

        List<User> users = new ArrayList<>();

        System.out.println();
        System.out.println("========== ENTER USERS DATA ==========");

        System.out.print("Enter number of users: ");

        int numberOfUsers = readPositiveInt(scanner);

        for (int i = 1; i <= numberOfUsers; i++) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("           USER " + i);
            System.out.println("======================================");

            System.out.println();
            System.out.println("========== CREATE USER ==========");

            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            /*
             * Check whether the same User ID and Name
             * already exist in the ArrayList.
             */
            if (userExists(users, userId, name)) {

                System.out.println();
                System.out.println("User already exists!");
                System.out.println("User ID : " + userId);
                System.out.println("Name    : " + name);

                System.out.println();
                System.out.println("Please enter a different user.");

                i--;

                continue;
            }

            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            User user = new User(
                    userId,
                    name,
                    email
            );

            System.out.println();
            System.out.println("User created successfully.");

            // ================= ADD STOCK =================

            System.out.println();
            System.out.println("========== ADD STOCK ==========");

            System.out.print("Enter Holding ID: ");
            String stockHoldingId = scanner.nextLine();

            System.out.print("Enter Stock ID: ");
            String stockId = scanner.nextLine();

            System.out.print("Enter Stock Name: ");
            String stockName = scanner.nextLine();

            System.out.print("Enter Purchase Price: ");
            double stockPurchasePrice =
                    readPositiveDouble(scanner);

            System.out.print("Enter Current Price: ");
            double stockCurrentPrice =
                    readPositiveDouble(scanner);

            System.out.print("Enter Quantity: ");
            double stockQuantity =
                    readPositiveDouble(scanner);

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

            System.out.println();
            System.out.println("Stock holding added successfully.");

            // ================= ADD MUTUAL FUND =================

            System.out.println();
            System.out.println("======= ADD MUTUAL FUND =======");

            System.out.print("Enter Holding ID: ");
            String mutualHoldingId = scanner.nextLine();

            System.out.print("Enter Mutual Fund ID: ");
            String mutualFundId = scanner.nextLine();

            System.out.print("Enter Mutual Fund Name: ");
            String mutualFundName = scanner.nextLine();

            System.out.print("Enter Purchase Price: ");
            double mutualPurchasePrice =
                    readPositiveDouble(scanner);

            System.out.print("Enter NAV: ");
            double nav =
                    readPositiveDouble(scanner);

            System.out.print("Enter Exit Load (%): ");
            double exitLoad =
                    readPercentage(scanner);

            System.out.print("Enter Units: ");
            double units =
                    readPositiveDouble(scanner);

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

            System.out.println();
            System.out.println(
                    "Mutual fund holding added successfully."
            );

            // Add user to ArrayList

            users.add(user);

            System.out.println();
            System.out.println(
                    "User " + i +
                    " added to the user list successfully."
            );
        }

        // ================= DISPLAY ALL USERS =================

        System.out.println();
        System.out.println("======================================");
        System.out.println("        ALL USERS IN PORTFOLIO");
        System.out.println("======================================");

        if (users.isEmpty()) {

            System.out.println("No users available.");

        } else {

            for (int i = 0; i < users.size(); i++) {

                System.out.println();
                System.out.println(
                        "************ USER " +
                        (i + 1) +
                        " ************"
                );

                User user = users.get(i);

                user.display();

                System.out.println();
                System.out.println(
                        "========== PORTFOLIO HOLDINGS =========="
                );

                user.displayHoldings();
            }
        }

        System.out.println();
        System.out.println("======================================");
        System.out.println("   PORTFOLIO PROCESS COMPLETED");
        System.out.println("======================================");

        scanner.close();
    }

    /*
     * Checks whether a user with the same
     * User ID AND Name already exists.
     */
    private static boolean userExists(
            List<User> users,
            String userId,
            String name) {

        for (User user : users) {

            if (user.getUserid().equalsIgnoreCase(userId)
                    && user.getName().equalsIgnoreCase(name)) {

                return true;
            }
        }

        return false;
    }

    private static int readPositiveInt(
            Scanner scanner) {

        while (true) {

            try {

                int value =
                        Integer.parseInt(scanner.nextLine());

                if (value > 0) {

                    return value;
                }

                System.out.print(
                        "Enter a number greater than 0: "
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Enter a valid whole number: "
                );
            }
        }
    }

    private static double readPositiveDouble(
            Scanner scanner) {

        while (true) {

            try {

                double value =
                        Double.parseDouble(scanner.nextLine());

                if (value >= 0) {

                    return value;
                }

                System.out.print(
                        "Enter a positive number: "
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Enter a valid number: "
                );
            }
        }
    }

    private static double readPercentage(
            Scanner scanner) {

        while (true) {

            try {

                double value =
                        Double.parseDouble(scanner.nextLine());

                if (value >= 0 && value <= 100) {

                    return value;
                }

                System.out.print(
                        "Enter a percentage between 0 and 100: "
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Enter a valid number: "
                );
            }
        }
    }
}