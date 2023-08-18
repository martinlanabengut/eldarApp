package com.demo.eldarApp;

import com.demo.eldarApp.service.RateCalculator;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RateCalculatorTest {

    @Test
    public void testVisaRateCalculation() {
        LocalDate currentDate = LocalDate.now();
        double expectedRate = (double) currentDate.getYear() / currentDate.getMonthValue() * 100.0;
        assertEquals(expectedRate, RateCalculator.getRate("VISA", 100.0));
    }

    @Test
    public void testNaraRateCalculation() {
        LocalDate currentDate = LocalDate.now();
        double expectedRate = currentDate.getDayOfMonth() * 0.5 * 100.0;
        assertEquals(expectedRate, RateCalculator.getRate("NARA", 100.0));
    }

    @Test
    public void testAmexRateCalculation() {
        LocalDate currentDate = LocalDate.now();
        double expectedRate = currentDate.getMonthValue() * 0.1 * 100.0;
        assertEquals(expectedRate, RateCalculator.getRate("AMEX", 100.0));
    }

    @Test
    public void testInvalidCardBrand() {
        assertThrows(IllegalArgumentException.class, () -> RateCalculator.getRate("INVALID", 100.0));
    }
}
