package com.sjsu.assignment.card.constants;

import java.util.Arrays;
import java.util.List;

public class CreditCardConstants {

    // General Constants
    public static final int CREDIT_CARD_NUMBER_MAX_LENGTH = 19;

    // Master Card Related Constants
    public static final int MASTER_CARD_NUMBER_VALID_LENGTH = 16;
    public static final char MASTER_CARD_FIRST_DIGIT = '5';
    public static final char MASTER_CARD_SECOND_DIGIT_LOWER_LIMIT = '1';
    public static final char MASTER_CARD_SECOND_DIGIT_UPPER_LIMIT = '5';

    // Visa Card Related Constants
    public static final List<Integer> visaCardNumberValidLengths = Arrays.asList(13, 16);
    public static final char VISA_CARD_FIRST_DIGIT = '4';

    // Amex Card Related Constants
    public static final int AMEX_CARD_NUMBER_VALID_LENGTH = 15;
    public static final int AMEX_CARD_FIRST_DIGIT = '3';
    public static final List<Character> amexCardSecondDigitValidNumbers = Arrays.asList('4', '7');

    // Discover Card Related Constants
    public static final int DISCOVER_CARD_NUMBER_VALID_LENGTH = 16;
    public static final String DISCOVER_CARD_FIRST_DIGITS = "6011";

    private CreditCardConstants () {
        // This class is not expected to be instantiated.
    }



}
