package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// util class should be all static!!
public class ReceiptWriter {

    //private constructor

    public static String getReceiptFile() {
        LocalDateTime rightNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileNameDate = rightNow.format(formatter);
        return fileNameDate + ".txt";

        //
    }

    public static void writeReceipt(Order order) throws java.io.IOException {
        // will code logic + filename later
    }

}
