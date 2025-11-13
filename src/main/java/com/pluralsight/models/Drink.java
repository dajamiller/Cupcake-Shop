package com.pluralsight.models;

public class Drink implements MenuItem {

    private String name;
    private String size;
    private double price;

    public Drink(String name, double price) {
        this.name = name;
        //this.size = size;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }
    public double getPrice() {
        return 0;
    }
    public String getDetails() {
        return name + " $" + price;
    }

    // should this be 3 separate classes?
}
