package com.portfolioproject.app;

import com.portfolioproject.model.User;
import com.portfolioproject.model.Stock;
import com.portfolioproject.model.MutualFund;
import com.portfolioproject.model.Holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    // HashMap stores users using User ID as the key
    static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        System.out.println("=====================================");
        System.out.println("   STOCK PORTFOLIO MANAGEMENT SYSTEM");
        System.out.println("=====================================");

        do {

            System.out.println();
            System.out.println("----------- MENU -----------");
            System.out.println("1. Create User");
            System.out.println("2. Add Stock Holding");
            System.out.println("3. Add Mutual Fund Holding");
            System.out.println("4. Display Users");
            System.out.println("5. Display Holdings");
            System.out.println("6. Exit");
            System.out.println("----------------------------");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {

                // =========================================
                // CASE 1: CREATE USER
                // =========================================
                case 1:

                    System.out.println();
                    System.out.println("--- Create User ---");

                    System.out.print("Enter User ID: ");
                    String userid = sc.nextLine().trim();

                    if (userid.isEmpty()) {
                        System.out.println("User ID cannot be empty.");
                        break;
                    }

                    // HashMap duplicate check
                    if (users.containsKey(userid)) {

                        System.out.println();
                        System.out.println(
                                "User ID already exists!"
                        );

                        System.out.println(
                                "Please enter a different User ID."
                        );

                        break;
                    }

                    System.out.print("Enter User Name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("User name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Email: ");
                    String email = sc.nextLine().trim();

                    if (email.isEmpty()) {
                        System.out.println("Email cannot be empty.");
                        break;
                    }

                    User newUser = new User(
                            userid,
                            name,
                            email
                    );

                    // Add user to HashMap
                    users.put(userid, newUser);

                    System.out.println();
                    System.out.println(
                            "User created successfully!"
                    );

                    break;


                // =========================================
                // CASE 2: ADD STOCK HOLDING
                // =========================================
                case 2:

                    if (users.isEmpty()) {

                        System.out.println();
                        System.out.println(
                                "Please create a user first."
                        );

                        break;
                    }

                    System.out.println();
                    System.out.println("--- Add Stock Holding ---");

                    System.out.print("Enter User ID: ");
                    String stockUserId = sc.nextLine().trim();

                    // Find user using HashMap
                    User stockUser = findUser(stockUserId);

                    if (stockUser == null) {

                        System.out.println(
                                "User not found."
                        );

                        break;
                    }

                    System.out.print("Enter Holding ID: ");
                    String stockHoldingId = sc.nextLine().trim();

                    System.out.print("Enter Stock ID: ");
                    String stockId = sc.nextLine().trim();

                    System.out.print("Enter Stock Name: ");
                    String stockName = sc.nextLine().trim();

                    double purchasePrice = readPositiveDouble(
                            sc,
                            "Enter Purchase Price: "
                    );

                    double currentPrice = readPositiveDouble(
                            sc,
                            "Enter Current Price: "
                    );

                    int quantity = readPositiveInt(
                            sc,
                            "Enter Quantity: "
                    );

                    Stock stock = new Stock(
                            stockId,
                            stockName,
                            purchasePrice,
                            currentPrice
                    );

                    Holding stockHolding = new Holding(
                            stockHoldingId,
                            stock,
                            quantity
                    );

                    // User's ArrayList receives the holding
                    stockUser.addHolding(stockHolding);

                    System.out.println();
                    System.out.println(
                            "Stock holding added successfully!"
                    );

                    break;


                // =========================================
                // CASE 3: ADD MUTUAL FUND HOLDING
                // =========================================
                case 3:

                    if (users.isEmpty()) {

                        System.out.println();
                        System.out.println(
                                "Please create a user first."
                        );

                        break;
                    }

                    System.out.println();
                    System.out.println(
                            "--- Add Mutual Fund Holding ---"
                    );

                    System.out.print("Enter User ID: ");
                    String mfUserId = sc.nextLine().trim();

                    // Find user using HashMap
                    User mfUser = findUser(mfUserId);

                    if (mfUser == null) {

                        System.out.println(
                                "User not found."
                        );

                        break;
                    }

                    System.out.print("Enter Holding ID: ");
                    String mfHoldingId = sc.nextLine().trim();

                    System.out.print("Enter Mutual Fund ID: ");
                    String mfId = sc.nextLine().trim();

                    System.out.print("Enter Mutual Fund Name: ");
                    String mfName = sc.nextLine().trim();

                    double mfPurchasePrice = readPositiveDouble(
                            sc,
                            "Enter Purchase Price: "
                    );

                    double nav = readPositiveDouble(
                            sc,
                            "Enter NAV: "
                    );

                    double exitLoad = readPercentage(
                            sc,
                            "Enter Exit Load (%): "
                    );

                    int mfQuantity = readPositiveInt(
                            sc,
                            "Enter Units: "
                    );

                    MutualFund mutualFund = new MutualFund(
                            mfId,
                            mfName,
                            mfPurchasePrice,
                            nav,
                            exitLoad
                    );

                    Holding mfHolding = new Holding(
                            mfHoldingId,
                            mutualFund,
                            mfQuantity
                    );

                    // User's ArrayList receives the holding
                    mfUser.addHolding(mfHolding);

                    System.out.println();
                    System.out.println(
                            "Mutual fund holding added successfully!"
                    );

                    break;


                // =========================================
                // CASE 4: DISPLAY ALL USERS
                // =========================================
                case 4:

                    if (users.isEmpty()) {

                        System.out.println();
                        System.out.println(
                                "No users created."
                        );

                    } else {

                        System.out.println();
                        System.out.println(
                                "--- User Details ---"
                        );

                        // HashMap values() gives all User objects
                        for (User user : users.values()) {

                            user.display();

                            System.out.println(
                                    "----------------------------"
                            );
                        }
                    }

                    break;


                // =========================================
                // CASE 5: DISPLAY ALL HOLDINGS
                // =========================================
                case 5:

                    if (users.isEmpty()) {

                        System.out.println();
                        System.out.println(
                                "No users created."
                        );

                        break;
                    }

                    System.out.println();
                    System.out.println("--- Holdings ---");

                    // Loop through all users in HashMap
                    for (User user : users.values()) {

                        System.out.println();
                        System.out.println(
                                "User ID   : " + user.getUserid()
                        );

                        System.out.println(
                                "User Name : " + user.getName()
                        );

                        // ArrayList of holdings
                        if (user.getHoldings().isEmpty()) {

                            System.out.println(
                                    "No holdings available."
                            );

                        } else {

                            // Loop through ArrayList
                            for (Holding holding :
                                    user.getHoldings()) {

                                holding.display();
                            }
                        }

                        System.out.println(
                                "----------------------------"
                        );
                    }

                    break;


                // =========================================
                // CASE 6: EXIT
                // =========================================
                case 6:

                    System.out.println();
                    System.out.println(
                            "Thank you for using "
                            + "Stock Portfolio Management System."
                    );

                    break;


                // =========================================
                // INVALID CHOICE
                // =========================================
                default:

                    System.out.println();
                    System.out.println(
                            "Invalid choice. "
                            + "Please enter 1 to 6."
                    );
            }

        } while (choice != 6);

        sc.close();
    }


    // =========================================
    // FIND USER BY USER ID
    // =========================================
    public static User findUser(String userid) 
    {
    	return users.get(userid);
    }
       


    // =========================================
    // READ INTEGER
    // =========================================
    public static int readInt(
            Scanner sc,
            String message) {

        while (true) {

            System.out.print(message);

            try {

                return Integer.parseInt(
                        sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. "
                        + "Please enter a whole number."
                );
            }
        }
    }


    // =========================================
    // READ POSITIVE INTEGER
    // =========================================
    public static int readPositiveInt(
            Scanner sc,
            String message) {

        while (true) {

            int value = readInt(sc, message);

            if (value > 0) {

                return value;
            }

            System.out.println(
                    "Please enter a number greater than 0."
            );
        }
    }


    // =========================================
    // READ POSITIVE DOUBLE
    // =========================================
    public static double readPositiveDouble(
            Scanner sc,
            String message) {

        while (true) {

            System.out.print(message);

            try {

                double value = Double.parseDouble(
                        sc.nextLine().trim()
                );

                if (value >= 0) {

                    return value;
                }

                System.out.println(
                        "Please enter a positive number."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. "
                        + "Please enter a valid number."
                );
            }
        }
    }


    // =========================================
    // READ PERCENTAGE
    // =========================================
    public static double readPercentage(
            Scanner sc,
            String message) {

        while (true) {

            double value = readPositiveDouble(
                    sc,
                    message
            );

            if (value >= 0 && value <= 100) {

                return value;
            }

            System.out.println(
                    "Percentage must be between 0 and 100."
            );
        }
    }
}