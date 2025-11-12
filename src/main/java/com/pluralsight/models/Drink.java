package com.pluralsight.models;

public class Drink extends MenuItem {

    private String name;
    private String size;
    private double price;

    public Drink(String name, String size, double price) {
        this.type = name;
        this.size = size;
        this.price = price;
    }

    @Override
    public String getName() {
        return super.getName();
    }
    public double getPrice() {
        return 0;
    }
    public String getDetails() {
        return super.getDetails();
    }

    // should this be 3 separate classes?
}
