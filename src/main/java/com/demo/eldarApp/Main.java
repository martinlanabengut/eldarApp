package com.demo.eldarApp;

import com.demo.eldarApp.model.Card;
import com.demo.eldarApp.model.Transaction;
import com.demo.eldarApp.service.RateCalculator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create three card objects
        Card card1 = new Card("VISA", "1234567890123456", "Martin", "Lana", LocalDate.of(2025, 12, 31));
        Card card2 = new Card("AMEX", "9876543210123456", "Pedro", "Del Toro", LocalDate.of(2023, 5, 15));
        Card card3 = new Card("NARA", "4567890123456789", "Guillermo", "Brown", LocalDate.of(2022, 8, 20));

        // Display card information
        System.out.println(card1);
        System.out.println(card2);
        System.out.println(card3);

        // Check if an operation is valid
        Transaction transaction1 = new Transaction(card1, 500);
        System.out.println("Transaction 1 valid? " + transaction1.isValidTransaction());

        Transaction transaction2 = new Transaction(card2, 1500);
        System.out.println("Transaction 2 valid? " + transaction2.isValidTransaction());

        // Check if a card is valid to operate
        System.out.println("Card 1 valid to operate? " + card1.isValid());
        System.out.println("Card 3 valid to operate? " + card3.isValid());

        // Identify if a card is different from another one
        System.out.println("Card 1 equals Card 2? " + card1.equals(card2));

        // Obtain the rate of an operation
        try {
            System.out.println("Rate for Transaction 1: " + RateCalculator.getRate(card1.getBrand(), 500));
            System.out.println("Rate for Transaction 2: " + RateCalculator.getRate(card2.getBrand(), 1500));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
