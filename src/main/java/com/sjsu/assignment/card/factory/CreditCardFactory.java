package com.sjsu.assignment.card.factory;

import com.sjsu.assignment.card.AmExCC;
import com.sjsu.assignment.card.CreditCard;
import com.sjsu.assignment.card.DiscoverCC;
import com.sjsu.assignment.card.MasterCC;
import com.sjsu.assignment.card.VisaCC;
import com.sjsu.assignment.card.constants.CreditCardConstants;
import com.sjsu.assignment.card.exception.InvalidCardNumberException;
import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public class CreditCardFactory {

    public static Optional<CreditCard> createCreditCard(CreditCardDetailsInput creditCardDetailsInput) {

        String cardNumber = creditCardDetailsInput.getCardNumber();

        if (!StringUtils.isNotEmpty(cardNumber)) {
            throw new InvalidCardNumberException("Invalid: empty/null card number");
        }

        if(cardNumber.length() > CreditCardConstants.CREDIT_CARD_NUMBER_MAX_LENGTH) {
            throw new InvalidCardNumberException("Invalid: More than 19 digits");
        }

        try {
            Long.parseLong(cardNumber);
        } catch (NumberFormatException e) {
            throw new InvalidCardNumberException("Invalid: non numeric characters");
        }


        if (isMasterCard(cardNumber)) {
            return Optional.of(new MasterCC(creditCardDetailsInput.getCardNumber(), creditCardDetailsInput.getExpirationDate(), creditCardDetailsInput.getCardHolderName()));
        } else if (isVisaCard(cardNumber)) {
            return Optional.of(new VisaCC(creditCardDetailsInput.getCardNumber(), creditCardDetailsInput.getExpirationDate(), creditCardDetailsInput.getCardHolderName()));
        } else if (isAmexCard(cardNumber)) {
            return Optional.of(new AmExCC(creditCardDetailsInput.getCardNumber(), creditCardDetailsInput.getExpirationDate(), creditCardDetailsInput.getCardHolderName()));
        } else if (isDiscoverCard(cardNumber)) {
            return Optional.of(new DiscoverCC(creditCardDetailsInput.getCardNumber(), creditCardDetailsInput.getExpirationDate(), creditCardDetailsInput.getCardHolderName()));
        } else {
            throw new InvalidCardNumberException("Invalid: Not a possible card number");
        }

    }

    private static boolean isMasterCard(String cardNumber) {
        return cardNumber.length() == CreditCardConstants.MASTER_CARD_NUMBER_VALID_LENGTH
            && cardNumber.charAt(0) == CreditCardConstants.MASTER_CARD_FIRST_DIGIT
            && cardNumber.charAt(1) >= CreditCardConstants.MASTER_CARD_SECOND_DIGIT_LOWER_LIMIT
            && cardNumber.charAt(1) <= CreditCardConstants.MASTER_CARD_SECOND_DIGIT_UPPER_LIMIT;
    }

    private static boolean isVisaCard(String cardNumber) {
        return CreditCardConstants.visaCardNumberValidLengths.contains(cardNumber.length())
            && cardNumber.charAt(0) == CreditCardConstants.VISA_CARD_FIRST_DIGIT;
    }

    private static boolean isAmexCard(String cardNumber) {
        return cardNumber.length() == CreditCardConstants.AMEX_CARD_NUMBER_VALID_LENGTH
            && cardNumber.charAt(0) == CreditCardConstants.AMEX_CARD_FIRST_DIGIT
            && CreditCardConstants.amexCardSecondDigitValidNumbers.contains(cardNumber.charAt(1));
    }

    private static boolean isDiscoverCard(String cardNumber) {
        return cardNumber.length() == CreditCardConstants.DISCOVER_CARD_NUMBER_VALID_LENGTH
            && cardNumber.startsWith(CreditCardConstants.DISCOVER_CARD_FIRST_DIGITS);
    }

}
