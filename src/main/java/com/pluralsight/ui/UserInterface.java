package com.pluralsight.ui;

import com.pluralsight.models.Order;

import java.util.Scanner;

public class UserInterface {

    //declare scanner
    private Scanner scanner;
    private Order activeOrder;

    //constructor
    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.activeOrder = null;
    }

    public void showHomeScreen() {
        boolean isActive = true;
        while (isActive) {
            System.out.println("Welcome to Daisy's Cupcakery!\n");
            System.out.println("What would you like to do?");
            System.out.println("1) Place new order");
            System.out.println("0) Exit\n");
            System.out.print("Enter your choice: ");



            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> createOrder();
                case "0" -> {
                    System.out.println("Thank you for coming to Daisy's Cupcakery!\n");
                    isActive = false;
                }
                default -> System.out.println("Invalid choice, try again (line 36)\n");

            }
        }
        this.scanner.close();
    }
    private void createOrder () {
        System.out.println("Please enter your name: ");
        String customerName = scanner.nextLine().trim();

        this.activeOrder = new Order(customerName);
        System.out.println("Thanks, " + customerName + ", let's get started!");

        showOrderMenu();
    }

    public void showOrderMenu () {
        boolean isOrdering = true;
        while (isOrdering) {
            System.out.println("What would you like to do?");
            System.out.println("1) Order a Cupcake");
            System.out.println("2) Order a Drink");
            System.out.println("3) Order a Side");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            String choice2 = scanner.nextLine().trim();
            switch (choice2) {
                case "1" -> addCupcake();

                case "2" -> addDrink();
                case "3" -> addSide();
                case "4" -> {
                    System.out.println("Ready to checkout? Let's go!");
                    checkout();
                    isOrdering = false;
                }
                case "0" -> {
                    System.out.println("Order Canceled\nThank you for coming to Daisy's Cupcakery!\n");
                    isOrdering = false;
                }
                default -> System.out.println("Invalid choice, try again (line 66)\n");

            }
        }
    }
    private void addCupcake() {}
    private void addDrink() {}
    private void addSide() {}
    private void checkout() {}

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.showHomeScreen();
    }


}
