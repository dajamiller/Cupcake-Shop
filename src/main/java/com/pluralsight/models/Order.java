package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    // private variables
    private String customerName;
    private List<MenuItem> menuItems;

    //constructor
    public Order(String customerName) {
        this.customerName = customerName;
        menuItems = new ArrayList<>();
    }

    //getters/setters


    public void addItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.00;
        for (MenuItem menuItem : menuItems) {
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;// sum of all items
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

}
