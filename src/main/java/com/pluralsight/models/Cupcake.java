package com.pluralsight.models;

import java.util.List;

public class Cupcake extends MenuItem {

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
    public double getPrice() {
        //double price = this.basePrice;
        return basePrice; // (must also add cost of premium toppings, special option, etc.., needs to connect to menu?
    }
    // should return...
    public String getDetails() {
        String details = size + " " +  cake + " Cupcake with " + frosting + " Frosting and " + toppings + " on top" ;
        if (this.toppings.isEmpty()) {
            details += "No toppings";
        } else {
            for (int i = 0; i < toppings.size(); i++) {
                String currentTopping = toppings.get(i);
                details += currentTopping;
            }
        }
        for (String topping : toppings) {

        }
        return size + " " +  cake + " Cupcake with " + frosting + " Frosting and " +toppings + " on top" ;
    }

}
