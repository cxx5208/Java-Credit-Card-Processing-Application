package com.sjsu.assignment.card;

import com.sjsu.assignment.card.constants.CreditCardType;
import lombok.Getter;

public class VisaCC extends CreditCard {

    @Getter
    private final String cardType = CreditCardType.VISA.getName();

    public VisaCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
}
