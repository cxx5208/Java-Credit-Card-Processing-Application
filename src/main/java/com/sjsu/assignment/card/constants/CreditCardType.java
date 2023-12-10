package com.sjsu.assignment.card.constants;

public enum CreditCardType {
    AMEX("AmericanExpress"),
    VISA("Visa"),
    DISCOVER("Discover"),
    MASTER("MasterCard");

    private final String name;

    CreditCardType(String s)
    {
        name = s;
    }

    public String getName()
    {
        return name;
    }
}
