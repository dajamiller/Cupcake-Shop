package com.pluralsight.models;

import java.util.List;

public class Cupcake extends MenuItem {

    //encapsulation

    //instance variables
    private String cakeFlavor;
    private String size;
    private String frostingFlavor;
    private List<String> toppings;
    private SpecialOption decoration;// bonus
    private double basePrice;

    // constructor to initialize variables

    public Cupcake(String cakeFlavor, String size, String frostingFlavor, List<String> toppings, SpecialOption decoration, double basePrice) {
        this.cakeFlavor = cakeFlavor;
        this.size = size;
        this.frostingFlavor = frostingFlavor;
        this.toppings = toppings;
        this.decoration = decoration;
        this.basePrice = basePrice;
    }

    @Override
    // should return "Mini Strawberry Cupcake"
    public void getName() {}
    //should return "$2.00"
    public void getPrice() {}
    // should return...
    public void getDetails() {}

}
