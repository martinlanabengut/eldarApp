package com.demo.eldarApp.service;


import java.time.LocalDate;

public class RateCalculator {

    public static double getRate(String brand, double amount) {
        double rate = 0.0;
        LocalDate currentDate = LocalDate.now();

        switch (brand.toUpperCase()) {
            case "VISA":
                rate = (double) currentDate.getYear() / currentDate.getMonthValue();
                break;
            case "NARA":
                rate = currentDate.getDayOfMonth() * 0.5;
                break;
            case "AMEX":
                rate = currentDate.getMonthValue() * 0.1;
                break;
            default:
                throw new IllegalArgumentException("Invalid card brand: " + brand);
        }

        return rate * amount;
    }
}
