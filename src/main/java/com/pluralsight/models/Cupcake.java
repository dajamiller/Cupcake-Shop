package com.pluralsight.models;

import com.pluralsight.util.PriceManager;

import java.util.List;

public class Cupcake implements MenuItem {

    //encapsulation

    //instance variables
    private String cake;
    private String size;
    private String frosting;
    private List<String> toppings;
    private SpecialOption decoration;// bonus
    private double basePrice;

    // constructor to initialize variables

    public Cupcake(String cake, String size, String frosting, List<String> toppings, SpecialOption decoration, double basePrice) {
        this.cake = cake;
        this.size = size;
        this.frosting = frosting;
        this.toppings = toppings;
        this.decoration = decoration;
        this.basePrice = basePrice;
    }

    // derived getters - combine multiple variables, creates new value that isnt stored as an instance variable
    // inherited from parent class
    @Override
    // should return "Mini Strawberry Cupcake"
    public String getName() {
        return size + " " + cake + " Cupcake";
    }

    @Override
    public double getPrice() {

        double totalCupcakePrice = PriceManager.getBasePrice(this.size);

        totalCupcakePrice += this.decoration.getPrice();

        for (String topping : this.toppings) {
            if (topping.toLowerCase().contains("premium")) {
                totalCupcakePrice += PriceManager.getPremiumToppingPrice(this.size);
            }
        }
        return totalCupcakePrice;
    }

    // should return...
    @Override
    public String getDetails() {

        String details = this.size + " " + this.cake + " Cupcake\n" + this.frosting + " Frosting\n";


        if (this.toppings.isEmpty()) {
            details += " with no toppings, ";
        } else {
            details += "(Toppings: ";
            for (int i = 0; i < toppings.size(); i++) {
                details += this.toppings.get(i);
                if (i < this.toppings.size() - 1) {
                    details += ", ";
                }
            }
            details += ")";

            if (!this.decoration.getName().equalsIgnoreCase("none")) {
                details += "\nWith a " + this.decoration.getName();
            }

        }
        return details;
    }
}
