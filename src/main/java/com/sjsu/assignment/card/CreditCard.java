package com.sjsu.assignment.card;

public abstract class CreditCard {

    private final String cardNumber;
    protected  String expirationDate;
    protected  String cardHolderName;

    public CreditCard(String cardNumber, String expirationDate, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public abstract String getCardType();

}
