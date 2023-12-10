package com.sjsu.assignment.card;

import com.sjsu.assignment.card.constants.CreditCardType;
import lombok.Getter;

public class DiscoverCC extends CreditCard {

    @Getter
    private final String cardType = CreditCardType.DISCOVER.getName();

    public DiscoverCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
}
