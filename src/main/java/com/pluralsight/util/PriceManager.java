package com.pluralsight.util;

// utility class - should only have static members
public class PriceManager {
    private PriceManager() {
    }


    private static double[] BASE_PRICES = {
            2.00,
            3.50,
            5.00,
    };

    private static double[] PREMIUM_TOPPING_PRICES = {
            0.50,
            0.75,
            1.00,
    };

    private static double[] SPECIAL_PRICES = {
            1.00,
            1.50,
            2.00,
    };

    private static double[] DRINK_PRICES = {
            1.00,
            2.00,
            3.00,
    };
    private static final String[] DRINK_NAMES = {
            "Water",
            "Tea",
            "Milk"
    };


    // connects item base price to size name
    public static double getBasePrice(String size) {
        double[] basePrice = BASE_PRICES;

        //if-else for sizes
        if (size.equalsIgnoreCase("mini")) {
            return basePrice[0];
        } else if (size.equalsIgnoreCase("regular")) {
            return basePrice[1];
        } else if (size.equalsIgnoreCase("jumbo")) {
            return basePrice[2];
        } else {
            System.out.println("Invalid input, try again (line 30)");
            return 0.00;
        }
    }

    public static double getPremiumToppingPrice(String size) {
        double[] premiumPrice = PREMIUM_TOPPING_PRICES;

        if (size.equalsIgnoreCase("mini")) {
            return premiumPrice[0];
        } else if (size.equalsIgnoreCase("regular")) {
            return premiumPrice[1];
        } else if (size.equalsIgnoreCase("jumbo")) {
            return premiumPrice[2];
        } else {
            System.out.println("Invalid input, try again (line 61)");
            return 0.00;
        }

    }

    public static double getSpecialPrices(String size) {
        double[] specialPrice = SPECIAL_PRICES;

        if (size.equalsIgnoreCase("mini")) {
            return specialPrice[0];
        } else if (size.equalsIgnoreCase("regular")) {
            return specialPrice[1];
        } else if (size.equalsIgnoreCase("jumbo")) {
            return specialPrice[2];
        } else {
            System.out.println("Invalid input, try again (line 77)");
            return 0.00;
        }
    }

    public static double getDrinkPrice(String name) {

        for (int i = 0; i < DRINK_NAMES.length; i++) {

            if (name.equalsIgnoreCase(DRINK_NAMES[i])) {
                return DRINK_PRICES[i];
            }
        }
        System.out.println("Invalid input, try again (line 94) " + name);
        return 0.00;
    }


        //public Cupcake.getItemPrice() {}

}
