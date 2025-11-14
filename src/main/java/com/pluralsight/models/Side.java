package com.pluralsight.models;

public class Side implements MenuItem {

    private String name;
    private double price;

    public Side(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getDetails() {
        return this.name + " $" + this.price;
    }

}
