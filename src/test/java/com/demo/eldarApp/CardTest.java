package com.demo.eldarApp;

import com.demo.eldarApp.model.Card;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CardTest {

    @Test
    public void testValidCard() {
        Card card = new Card("VISA", "1234567890123456", "John", "Doe", LocalDate.now().plusYears(1));
        assertTrue(card.isValid());
    }

    @Test
    public void testExpiredCard() {
        Card card = new Card("VISA", "1234567890123456", "John", "Doe", LocalDate.now().minusYears(1));
        assertFalse(card.isValid());
    }
}
