package com.sjsu.assignment.card.utils;

import com.sjsu.assignment.card.constants.CreditCardType;
import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import com.sjsu.assignment.card.models.CreditCardDetailsOutput;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardUtilsTest {

    @Test
    public void testComputeCreditCardDetailsAmex() {

        String creditCardNumber = "347856341908126";

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(creditCardNumber)
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputExpected = CreditCardDetailsOutput
            .builder()
            .cardNumber(creditCardNumber)
            .cardType(CreditCardType.AMEX.getName())
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputActual = CreditCardUtils.computeCreditCardDetails(creditCardDetailsInput);

       Assert.assertEquals(creditCardDetailsOutputExpected, creditCardDetailsOutputActual);

    }

    @Test
    public void testComputeCreditCardDetailsMasterCard() {

        String creditCardNumber = "5567894523129089";

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(creditCardNumber)
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputExpected = CreditCardDetailsOutput
            .builder()
            .cardNumber(creditCardNumber)
            .cardType(CreditCardType.MASTER.getName())
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputActual = CreditCardUtils.computeCreditCardDetails(creditCardDetailsInput);

        Assert.assertEquals(creditCardDetailsOutputExpected, creditCardDetailsOutputActual);

    }

    @Test
    public void testComputeCreditCardDetailsVisaCard() {

        String creditCardNumber = "4123456789123999";

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(creditCardNumber)
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputExpected = CreditCardDetailsOutput
            .builder()
            .cardNumber(creditCardNumber)
            .cardType(CreditCardType.VISA.getName())
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputActual = CreditCardUtils.computeCreditCardDetails(creditCardDetailsInput);

        Assert.assertEquals(creditCardDetailsOutputExpected, creditCardDetailsOutputActual);

    }

    @Test
    public void testComputeCreditCardDetailsDiscoverCard() {

        String creditCardNumber = "6011111100007756";

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(creditCardNumber)
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputExpected = CreditCardDetailsOutput
            .builder()
            .cardNumber(creditCardNumber)
            .cardType(CreditCardType.DISCOVER.getName())
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputActual = CreditCardUtils.computeCreditCardDetails(creditCardDetailsInput);

        Assert.assertEquals(creditCardDetailsOutputExpected, creditCardDetailsOutputActual);

    }

    @Test
    public void testComputeCreditCardDetailsEmptyCardNumber() {

        String creditCardNumber = "";

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(creditCardNumber)
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputExpected = CreditCardDetailsOutput
            .builder()
            .cardNumber(creditCardNumber)
            .cardType("Invalid: empty/null card number")
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputActual = CreditCardUtils.computeCreditCardDetails(creditCardDetailsInput);

        Assert.assertEquals(creditCardDetailsOutputExpected, creditCardDetailsOutputActual);

    }

    @Test
    public void testComputeCreditCardDetailsNullCreditCardNumber() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(null)
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputExpected = CreditCardDetailsOutput
            .builder()
            .cardNumber(null)
            .cardType("Invalid: empty/null card number")
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputActual = CreditCardUtils.computeCreditCardDetails(creditCardDetailsInput);

        Assert.assertEquals(creditCardDetailsOutputExpected, creditCardDetailsOutputActual);

    }

    @Test
    public void testComputeCreditCardDetailsLongNumber() {

        String creditCardNumber = "59012345678901234567890";

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(creditCardNumber)
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputExpected = CreditCardDetailsOutput
            .builder()
            .cardNumber(creditCardNumber)
            .cardType("Invalid: More than 19 digits")
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputActual = CreditCardUtils.computeCreditCardDetails(creditCardDetailsInput);

        Assert.assertEquals(creditCardDetailsOutputExpected, creditCardDetailsOutputActual);

    }

    @Test
    public void testComputeCreditCardDetailsNotPossibleCardNumber() {

        String creditCardNumber = "3601112345678789";

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(creditCardNumber)
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputExpected = CreditCardDetailsOutput
            .builder()
            .cardNumber(creditCardNumber)
            .cardType("Invalid: Not a possible card number")
            .build();

        CreditCardDetailsOutput creditCardDetailsOutputActual = CreditCardUtils.computeCreditCardDetails(creditCardDetailsInput);

        Assert.assertEquals(creditCardDetailsOutputExpected, creditCardDetailsOutputActual);

    }

}