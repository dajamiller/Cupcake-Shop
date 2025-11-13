package com.pluralsight.models;

public class Drink implements MenuItem {

    private String name;
    private String size;
    private double price;

    public Drink(String name, String size, double price) {
        this.name = name;
        this.size = size;
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
        return "Regular" + name + " $" + price;
    }

    // should this be 3 separate classes?
}
