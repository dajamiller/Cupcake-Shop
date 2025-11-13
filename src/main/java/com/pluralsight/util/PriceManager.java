package com.pluralsight.util;

// utility class - should only have static members
public class PriceManager {

    private static double[] BASE_PRICES = {
        2.00,
        3.50,
        5.00,
    };

    private PriceManager() {
    }

    public static double[] getBasePrices() {
        return BASE_PRICES;
    }
    // connects item base price to size name
    public static double getItemPrice(String size) {
        double[] prices = BASE_PRICES;

        //if-else for sizes
        if (size.equalsIgnoreCase("mini")) {
          return prices[0];
        } else if (size.equalsIgnoreCase("regular")) {
            return prices[1];
        } else if (size.equalsIgnoreCase("jumbo")) {
            return prices[2];
        } else  {
            System.out.println("Invalid input, try again (line 30)");
            return 0.00;
        }
    }

    public Cupcake.getItemPrice() {}
}
