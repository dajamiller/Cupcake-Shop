package com.pluralsight.models;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Cupcake class, ensuring core responsibilities
 * like naming and detail formatting are correct.
 */
class CupcakeTest {
    //arrange
    private Cupcake setupCommonCupcake() {
        String cake = "Strawberry";
        String size = "Mini";
        String frosting = "Vanilla Buttercream";
        List<String> toppings = Arrays.asList("Sprinkles", "Cherry");
        SpecialOption decoration = new SpecialOption("Happy Birthday Topper", 1.50);
        double basePrice = 2.00;

        // instantiate the cupcake,
        return new Cupcake(cake, size, frosting, toppings, decoration, basePrice);
    }

    // test 1 - derived getter - getName()

    @Test
    void getName_Should_ReturnCakeSizeAndFlavor() {
        // arrange
        Cupcake cupcake = setupCommonCupcake();

        // should match get.name code
        String expectedName = "Mini Strawberry Cupcake";

        // act
        // Call the method on the object instance (NOT the class name)
        String actualName = cupcake.getName();

        // assert
        assertEquals(expectedName, actualName);
    }

    @Test
    void getSize_Should_ReturnCupcakeSize() {}

    @Test
    void getDetails_Should_ReturnCupcakeSizeCakeFrostingToppingsDecorationAndBasePrice() {
        //arrange
        Cupcake cupcake = setupCommonCupcake();
        //act
        String expectedDetails = "Mini Strawberry Cupcake with Vanilla Buttercream Frosting and [Sprinkles, Cherry] on top";
        //assert
        String actualDetails = cupcake.getDetails();
        assertEquals(expectedDetails, actualDetails);
    }
    //  test 2- format

//    @Test
//    void getDetails_Should_ReturnFormattedMultiLineString() {
//        // ARRANGE
//        Cupcake cupcake = setupCommonCupcake();
//
//        // ACT
//        String actualDetails = cupcake.getDetails();
//
//        // ASSERT:
//        // We use assertTrue to check that the resulting string contains all the key components.
//        // This ensures the formatting logic is working.
//
//        assertTrue(actualDetails.contains("Mini"));
//        assertTrue(actualDetails.contains("Strawberry"));
//        assertTrue(actualDetails.contains("Vanilla Buttercreme"));
//        assertTrue(actualDetails.contains("Sprinkles, Cherry"));
//        assertTrue(actualDetails.contains("Happy Birthday Topper"));
//    }
}