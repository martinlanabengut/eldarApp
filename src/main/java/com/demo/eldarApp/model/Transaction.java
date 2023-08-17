package com.demo.eldarApp.model;


import com.demo.eldarApp.service.RateCalculator;

public class Transaction {
    private final Card card;
    private final double amount;

    public Transaction(Card card, double amount) {
        this.card = card;
        this.amount = amount;
    }

    public boolean isValidTransaction() {
        return amount < 1000; // A transaction is valid if the amount is less than 1000 pesos.
    }

    public boolean isCardValidForTransaction() {
        return card.isValid(); // A card is valid to operate if its expiration date is greater than the present day.
    }

    public double getTransactionRate() {
        if (!isCardValidForTransaction()) {
            throw new IllegalArgumentException("Card is not valid for the transaction.");
        }

        if (!isValidTransaction()) {
            throw new IllegalArgumentException("Transaction amount exceeds the limit.");
        }

        return RateCalculator.getRate(card.getBrand(), amount);
    }
}

