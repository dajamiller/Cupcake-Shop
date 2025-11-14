package com.pluralsight.ui;

import com.pluralsight.models.*;
        import com.pluralsight.util.PriceManager;
import com.pluralsight.util.ReceiptWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public void showHomeScreen()  {
        boolean isActive = true;
        while (isActive) {
            System.out.println("\n\uD83E\uDDC1 Welcome to Daisy's Cupcakery \uD83E\uDDC1 \n");
            System.out.println("What would you like to do?");
            System.out.println("1) Place a new order");
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
        System.out.println("\nGreat idea, please enter your name: ");
        String customerName = scanner.nextLine().trim();

        this.activeOrder = new Order(customerName);
        System.out.println("\nThanks, " + customerName + ", let's get started!");

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
            System.out.println("0) Cancel Order\n");
            System.out.print("Enter your choice: ");

            String choice2 = scanner.nextLine().trim();
            switch (choice2) {
                case "1" -> addCupcake();

                case "2" -> addDrink();
                case "3" -> addSide();
                case "4" -> {
                    System.out.println("Ready to checkout? Let's go!\n");
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

    private void addCupcake() {
        String chosenSize = null;
        String chosenCake = null;
        String chosenFrosting= null;
        List<String> chosenToppings = new ArrayList<>();
        boolean choosingToppings =  true;
        // String chosenPremium = null;// will have premium  detected to add price
        String chosenDecor = null;


        //boolean isSizing = true;
        while (chosenSize == null) {
            System.out.println("What size? ");
            System.out.println("1) Mini ($2)");
            System.out.println("2) Regular ($3.50)");
            System.out.println("3) Jumbo ($5)");
            System.out.println("0) Exit\n");
            System.out.print("Enter your choice: ");

            String sizeChoice = scanner.nextLine().trim();

            switch (sizeChoice) {
                case "1" -> {
                    System.out.println("Mini ~ The perfect bite!");
                    chosenSize = "Mini";
                }
                case "2" -> {
                    System.out.println("Regular ~ Just enough!");
                    chosenSize = "Regular";
                }
                case "3" -> {
                    System.out.println("Jumbo ~ Enough to share.. or not");
                    chosenSize = "Jumbo";
                }
                case "0" -> {
                    System.out.println("Canceled. Maybe next time...\nThank you for coming to Daisy's Cupcakery!\n");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice, try again (line 100)\n");
                }
            }
        }

        while (chosenCake == null) {

            System.out.println("\nPick a cake flavor: ");
            System.out.println("1) Double Chocolate");
            System.out.println("2) Very Vanilla");
            System.out.println("3) Fresh Strawberry");
            System.out.println("0) Exit\n");

            System.out.print("Enter your choice: ");


            String cakeFlavor = scanner.nextLine().trim();

            switch (cakeFlavor) {
                case "1" -> {
                    System.out.println("Double Chocolate ~ Great choice!");
                    chosenCake = "Double Chocolate";
                }
                case "2" -> {
                    System.out.println("Very Vanilla ~ Yum!");
                    chosenCake = "Very Vanilla";
                }
                case "3" -> {
                    System.out.println("Fresh Strawberry ~ So delicious!");
                    chosenCake = "Fresh Strawberry";
                }
                case "0" -> {
                    System.out.println("Maybe next time...\nThank you for using Daisy's Cupcakery!\n");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice, try again (line 157)\n");
                }
            }
        }

        while (chosenFrosting == null) {
            System.out.println("\nPick a frosting flavor: ");
            System.out.println("1) Chocolate Buttercream");
            System.out.println("2) Vanilla Buttercream");
            System.out.println("3) Strawberry Buttercream");
            System.out.println("0) Exit\n");

            System.out.print("Enter your choice: ");

            String frostingFlavor = scanner.nextLine().trim();

            switch (frostingFlavor) {
                case "1" -> {
                    System.out.println("Chocolate Buttercream ~ Sounds good!");
                    chosenFrosting = "Chocolate Buttercream";
                }
                case "2" -> {
                    System.out.println("Vanilla Buttercream ~ Simply delicious!");
                    chosenFrosting = "Vanilla Buttercream";
                }
                case "3" -> {
                    System.out.println("Strawberry Buttercream ~ Great taste!");
                    chosenFrosting = "Strawberry Buttercream";
                }
                case "0" -> {
                    System.out.println("Maybe next time...\nThank you for using Daisy's Cupcakery!\n");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice, try again (line 157)\n");
                }
            }
        }

        while (choosingToppings) {

            System.out.println("\nChoose your toppings: Premium is extra (mini- $0.50, reg- $0.75, jumbo- $1.00)");
            System.out.println("1) Strawberry");
            System.out.println("2) Cherry");
            System.out.println("3) Rainbow Sprinkles");
            System.out.println("4) Chocolate Sprinkles");
            System.out.println("5) Premium: Dubai Chocolate (+$)");
            System.out.println("6) Premium: Candy Bar (+$)");
            System.out.println("7) Premium: Silver Sprinkles (+$)");
            System.out.println("8) Done");

            System.out.println("0) Exit\n");

            System.out.print("Enter your choice: ");

            String toppingChoice = scanner.nextLine().trim();
            String toppingName = null;

            switch (toppingChoice) {
                case "1" -> {
                    //System.out.println("Strawberry added");
                    toppingName = "Strawberry";
                }
                case "2" -> {
                    //System.out.println("Cherry added");
                    toppingName = "Cherry";
                }
                case "3" -> {
                    //System.out.println("Rainbow Sprinkles added");
                    toppingName = "Rainbow Sprinkles";
                }
                case "4" -> {
                    //System.out.println("Chocolate Sprinkles added");
                    toppingName = "Chocolate Sprinkles";
                }
                case "5" -> {
                    //System.out.println("Dubai Chocolate added");
                    toppingName = "Premium Dubai Chocolate";
                }
                case "6" -> {
                    //System.out.println("Candy Bar added");
                    toppingName = "Premium Candy Bar";
                }
                case "7" -> {
                    //System.out.println("Silver Sprinkles added");
                    toppingName = "Premium Silver Sprinkles";
                }
                case "8" -> {
                    choosingToppings = false;
                }
                case "0" -> {
                    System.out.println("Maybe next time...\nThank you for using Daisy's Cupcakery!\n");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice, try again (line 259)\n");
                }
            }
            if (toppingName != null) {
                chosenToppings.add(toppingName);
                System.out.println(toppingName + " added! Choose another or enter 8 if you're done");
            }
        }

        //while (chosenPremium == null) {}

        while (chosenDecor == null) {
            System.out.println("\nWould you like a to add a special topper for +$1 more");
            System.out.println("1) No, thanks");
            System.out.println("2) Add Birthday Topper");
            System.out.println("3) Add Graduation Topper");
            System.out.println("4) Add Congrats Topper");
            System.out.println("5) Add Seasonal Holiday Topper");
            System.out.println("0) Cancel Cupcake\n");

            String decorChoice = scanner.nextLine().trim();
            switch (decorChoice) {
                case "1" -> {
                    System.out.println("No topper added.");
                    chosenDecor = "none";
                }
                case "2" -> {
                    System.out.println("Birthday Topper added!");
                    chosenDecor = "Birthday Topper";
                }
                case "3" -> {
                    System.out.println("Graduation Topper added!");
                    chosenDecor = "Graduation Topper";
                }
                case "4" -> {
                    System.out.println("Congrats Topper added!");
                    chosenDecor = "Congrats Topper";
                }
                case "5" -> {
                    System.out.println("Seasonal Holiday Topper added!");
                    chosenDecor = "Seasonal Holiday Topper";
                }
                case "0" -> {
                    System.out.println("Cupcake cancelled.");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice, try again (line 307)\n");
                }
            }
        }
        double decorPrice = chosenDecor.equalsIgnoreCase("none") ? 0.0 :
                PriceManager.getDecorationPrice();

        SpecialOption decoration = new SpecialOption(chosenDecor, decorPrice);

        Cupcake newCupcake = new Cupcake(chosenCake, chosenSize, chosenFrosting, chosenToppings, decoration, 0.0);

        activeOrder.addItem(newCupcake);

        System.out.println(newCupcake.getName() + " added to your order!");
    }

    private void addDrink() {
        String drinkName = null;

        while (drinkName == null) {

            System.out.println("\nWhat would you like to drink?");
            System.out.println("1) Water (+$1)");
            System.out.println("2) Tea (+$2)");
            System.out.println("3) Milk (+$3)");
            System.out.println("0)Cancel Drink\n");

            String drinkChoice = scanner.nextLine().trim();

            switch (drinkChoice) {
                case "1" -> {
                    drinkName = "Water";
                }
                case "2" -> {
                    drinkName = "Tea";
                }
                case "3" -> {
                    drinkName = "Milk";
                }
                case "0" -> {
                    System.out.println("Drink cancelled.");
                    return;
                }
                default -> {
                    System.out.println("Invalid choice, try again (line 340)\n");
                }
            }
        }
        double price = PriceManager.getDrinkPrice(drinkName);

        Drink newDrink = new Drink(drinkName, price);

        activeOrder.addItem(newDrink);

        System.out.println(newDrink.getName() + " added to your order!");

    }

    private void addSide() {
        System.out.println("\n--- Add Side Item ---");
        System.out.println("1) Cookie");
        System.out.println("2) Candy");
        System.out.println("0) Cancel Side");
        System.out.print("Enter choice: ");

        String sideChoice = scanner.nextLine().trim();
        String sideName = null;

        if (sideChoice.equals("1")) {
            sideName = "Cookie";
        } else if (sideChoice.equals("2")) {
            sideName = "Candy";
        } else if (sideChoice.equals("0")) {
            System.out.println("Side Cancelled.");
            return;
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        double sidePrice = PriceManager.getSidePrice(sideName);

        Side newSide = new Side(sideName, sidePrice);

        activeOrder.addItem(newSide);

        System.out.println(sideName + " added to order!");
    }

    private void checkout()  {

        if (activeOrder.getMenuItems().isEmpty()) {
            System.out.println("~~~Order Empty!~~~\n");
            System.out.println("You must add an item to checkout.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("        CONFIRM ORDER - " + activeOrder.getCustomerName());
        System.out.println("========================================");


        for (MenuItem item : activeOrder.getMenuItems()) {
            System.out.println("Item: " + item.getName());
            System.out.println(item.getDetails());
            System.out.printf("Price: $%.2f\n", item.getPrice());
            System.out.println("------------------------------------");
        }

        double subtotal = activeOrder.calculateTotalPrice();
        double taxRate = 0.05;
        double taxAmount = subtotal * taxRate;
        double finalTotal = subtotal + taxAmount;

        System.out.printf("\nsubtotal: $%.2f\n", subtotal);
        System.out.printf("tax (%.0f%%):    $%.2f\n", taxRate * 100, taxAmount);
        System.out.println("========================================");
        System.out.printf("total:  $%.2f\n", finalTotal);
        System.out.println("========================================");


        System.out.print("Confirm order? (Y/N): ");
        String confirmation = scanner.nextLine().trim();

        if (confirmation.equalsIgnoreCase("Y")) {
            ReceiptWriter.writeReceipt(activeOrder);
            System.out.println("Order confirmed!");
        } else {
            System.out.println("Order not confirmed, try again");
        }
    }

}
