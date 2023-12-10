package com.sjsu.assignment.card;

import com.sjsu.assignment.card.constants.CreditCardType;
import lombok.Getter;

public class AmExCC extends CreditCard {

    @Getter
    private final String cardType = CreditCardType.AMEX.getName();

    public AmExCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
}
