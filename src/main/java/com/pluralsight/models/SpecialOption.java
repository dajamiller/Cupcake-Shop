package com.pluralsight.models;

public class SpecialOption {

    private String name;

    private double price;


    public SpecialOption(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
