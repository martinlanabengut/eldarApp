package com.demo.eldarApp.controller;

import com.demo.eldarApp.model.Card;
import com.demo.eldarApp.model.Transaction;
import com.demo.eldarApp.service.RateCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @GetMapping("/transaction/rate")
    public ResponseEntity<Double> getTransactionRate(
            @RequestParam String brand,
            @RequestParam double amount) {
        try {
            double rate = RateCalculator.getRate(brand, amount);
            return ResponseEntity.ok(rate);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
