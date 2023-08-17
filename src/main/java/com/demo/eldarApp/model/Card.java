package com.demo.eldarApp.model;



import lombok.Data;
import java.time.LocalDate;

@Data
public class Card {
    private String brand;
    private String cardNumber;
    private String cardHolderName;
    private String cardHolderSurname;
    private LocalDate expirationDate;

    public Card(String brand, String cardNumber, String cardHolderName, String cardHolderSurname, LocalDate expirationDate) {
        this.brand = brand;
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardHolderSurname = cardHolderSurname;
        this.expirationDate = expirationDate;
    }

    public boolean isValid() {
        return LocalDate.now().isBefore(expirationDate);
    }

    @Override
    public String toString() {
        return "Card{" +
                "brand='" + brand + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardHolderSurname='" + cardHolderSurname + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
