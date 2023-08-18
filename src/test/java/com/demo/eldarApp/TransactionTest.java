package com.demo.eldarApp;

import com.demo.eldarApp.model.Card;
import com.demo.eldarApp.model.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    private Card validCard;
    private Card expiredCard;

    @BeforeEach
    public void setUp() {
        validCard = new Card("VISA", "1234567890123456", "John Doe", "Doe",
                LocalDate.now().plusYears(1));
        expiredCard = new Card("VISA", "1234567890123456", "John Doe", "Doe",
                LocalDate.now().minusYears(1));
    }

    @Test
    public void testValidTransaction() {
        Transaction transaction = new Transaction(validCard, 500);
        assertTrue(transaction.isValidTransaction());
    }

    @Test
    public void testInvalidTransaction() {
        Transaction transaction = new Transaction(validCard, 1500);
        assertFalse(transaction.isValidTransaction());
    }

    @Test
    public void testCardValidForTransaction() {
        Transaction transaction = new Transaction(validCard, 500);
        assertTrue(transaction.isCardValidForTransaction());
    }

    @Test
    public void testCardInvalidForTransaction() {
        Transaction transaction = new Transaction(expiredCard, 500);
        assertFalse(transaction.isCardValidForTransaction());
    }

    @Test
    public void testGetTransactionRateWithInvalidCard() {
        Transaction transaction = new Transaction(expiredCard, 500);
        assertThrows(IllegalArgumentException.class, transaction::getTransactionRate,
                "Card is not valid for the transaction.");
    }

    @Test
    public void testGetTransactionRateWithInvalidAmount() {
        Transaction transaction = new Transaction(validCard, 1500);
        assertThrows(IllegalArgumentException.class, transaction::getTransactionRate,
                "Transaction amount exceeds the limit.");
    }

}
