package com.sjsu.assignment.card.utils;

import com.sjsu.assignment.card.CreditCard;
import com.sjsu.assignment.card.exception.InvalidCardNumberException;
import com.sjsu.assignment.card.factory.CreditCardFactory;
import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import com.sjsu.assignment.card.models.CreditCardDetailsOutput;
import java.util.Optional;

public class CreditCardUtils {

    private CreditCardUtils() {
        //This class is not expected to be instantiated
    }

    public static CreditCardDetailsOutput computeCreditCardDetails(CreditCardDetailsInput creditCardDetailsInput) {

        String cardType = "";
        Optional<CreditCard> creditCardOptional = Optional.empty();

        try {
            creditCardOptional = CreditCardFactory.createCreditCard(creditCardDetailsInput);
        } catch (InvalidCardNumberException ex) {
            cardType = ex.getMessage();
        }

        if(creditCardOptional.isPresent()) {
            cardType = creditCardOptional.get().getCardType();
        }

        return CreditCardDetailsOutput.builder()
            .cardNumber(creditCardDetailsInput.getCardNumber())
            .cardType(cardType)
            .build();
    }

}
