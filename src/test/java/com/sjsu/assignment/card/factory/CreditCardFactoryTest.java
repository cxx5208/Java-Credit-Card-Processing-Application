package com.sjsu.assignment.card.factory;

import com.sjsu.assignment.card.AmExCC;
import com.sjsu.assignment.card.CreditCard;
import com.sjsu.assignment.card.DiscoverCC;
import com.sjsu.assignment.card.MasterCC;
import com.sjsu.assignment.card.VisaCC;
import com.sjsu.assignment.card.exception.InvalidCardNumberException;
import com.sjsu.assignment.card.models.CreditCardDetailsInput;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

public class CreditCardFactoryTest {

    @Test
    public void testCreateCreditCardEmptyCardNumber() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber("")
            .build();

        try {
            CreditCardFactory.createCreditCard(creditCardDetailsInput);
        } catch (InvalidCardNumberException ex) {
            Assert.assertEquals("Invalid: empty/null card number", ex.getMessage());
        }
    }

    @Test
    public void testCreateCreditCardNullCardNumber() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber(null)
            .build();

        try {
            CreditCardFactory.createCreditCard(creditCardDetailsInput);
        } catch (InvalidCardNumberException ex) {
            Assert.assertEquals("Invalid: empty/null card number", ex.getMessage());
        }
    }

    @Test
    public void testCreateCreditCardLargeNumber() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber("123456789101112131516171819")
            .build();

        try {
            CreditCardFactory.createCreditCard(creditCardDetailsInput);
        } catch (InvalidCardNumberException ex) {
            Assert.assertEquals("Invalid: More than 19 digits", ex.getMessage());
        }
    }

    @Test
    public void testCreateCreditCardNotANumericNumber() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber("123456abcdefgh5748")
            .build();

        try {
            CreditCardFactory.createCreditCard(creditCardDetailsInput);
        } catch (InvalidCardNumberException ex) {
            Assert.assertEquals("Invalid: non numeric characters", ex.getMessage());
        }
    }

    @Test
    public void testCreateCreditCardNotAPossibleCardNumber() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber("3601112345678789")
            .build();

        try {
            CreditCardFactory.createCreditCard(creditCardDetailsInput);
        } catch (InvalidCardNumberException ex) {
            Assert.assertEquals("Invalid: Not a possible card number", ex.getMessage());
        }
    }

    @Test
    public void testCreateMasterCreditCard() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber("5567894523129089")
            .build();

        Optional<CreditCard> creditCardOptional = CreditCardFactory.createCreditCard(creditCardDetailsInput);

        Assert.assertTrue(creditCardOptional.isPresent());

        CreditCard creditCard = creditCardOptional.get();

        Assert.assertTrue(creditCard instanceof MasterCC);
    }

    @Test
    public void testCreateVisaCreditCard() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber("4123456789123999")
            .build();

        Optional<CreditCard> creditCardOptional = CreditCardFactory.createCreditCard(creditCardDetailsInput);

        Assert.assertTrue(creditCardOptional.isPresent());

        CreditCard creditCard = creditCardOptional.get();

        Assert.assertTrue(creditCard instanceof VisaCC);
    }

    @Test
    public void testCreateAmexCreditCard() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber("377856341908126")
            .build();

        Optional<CreditCard> creditCardOptional = CreditCardFactory.createCreditCard(creditCardDetailsInput);

        Assert.assertTrue(creditCardOptional.isPresent());

        CreditCard creditCard = creditCardOptional.get();

        Assert.assertTrue(creditCard instanceof AmExCC);
    }

    @Test
    public void testCreateDiscoverCreditCard() {

        CreditCardDetailsInput creditCardDetailsInput = CreditCardDetailsInput
            .builder()
            .cardNumber("6011111100007756")
            .build();

        Optional<CreditCard> creditCardOptional = CreditCardFactory.createCreditCard(creditCardDetailsInput);

        Assert.assertTrue(creditCardOptional.isPresent());

        CreditCard creditCard = creditCardOptional.get();

        Assert.assertTrue(creditCard instanceof DiscoverCC);
    }

}