package com.sjsu.assignment.card;

import com.sjsu.assignment.card.constants.CreditCardType;
import lombok.Getter;

public class MasterCC extends CreditCard{

    @Getter
    private final String cardType = CreditCardType.MASTER.getName();

    public MasterCC(String cardNumber, String expirationDate, String cardHolderName) {
        super(cardNumber, expirationDate, cardHolderName);
    }
}
