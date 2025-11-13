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

//    public Cupcake() {
//        this.cake = cake;
//        this.size = size;
//        this.frosting = frosting;
//        this.toppings = toppings;
//        this.decoration = decoration;
//        this.basePrice = basePrice;
//    }

    public Cupcake(String cake, String size, String frosting, List<String> toppings, SpecialOption decoration, double basePrice) {
        this.cake = cake;
        this.size = size;
        this.frosting = frosting;
        this.toppings = toppings;
        this.decoration = decoration;
        this.basePrice = basePrice;
        //super();
    }

    // derived getters - combine multiple variables, creates new value that isnt stored as an instance variable
    // inherited from parent class (MenuItem)
    @Override
    // should return "Mini Strawberry Cupcake"
    public String getName() {
        return size + " " + cake + " Cupcake";
    }
    //should return "$2.00"
    @Override
    public double getPrice() {

        double totalCupcakePrice = PriceManager.getBasePrice(this.size);

        totalCupcakePrice += this.decoration.getPrice();

        double toppingCost = 0.00;
        for (String topping : toppings) {
            toppingCost += PriceManager.getPremiumToppingPrice(this.size);
        }
        totalCupcakePrice += toppingCost;

        return totalCupcakePrice;
    }
    // should return...
    @Override
    public String getDetails() {

        String details = this.size + " " + this.cake + " Cupcake with " + this.frosting + " Frosting";

//        details += "with " + this.toppings + " on top!";

        if (this.toppings.isEmpty()) {
            details += " nothing on top.";
        } else {
            for (int i = 0; i < toppings.size(); i++) {
                details += this.toppings.get(i);
                if (i < this.toppings.size() - 1) {
                    details += ", ";
                }
            }
        }
        details += " With a " + this.decoration.getName();
        return details;
    }

}
