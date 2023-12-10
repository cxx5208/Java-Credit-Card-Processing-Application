package com.sjsu.assignment.card.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDetailsOutput {

    // Credit Card Number
    private String cardNumber;

    // Type of the Card: Ex: Amex, Visa etc.
    // If the credit card number is Invalid, the corresponding error will be stored.
    private String cardType;

}
