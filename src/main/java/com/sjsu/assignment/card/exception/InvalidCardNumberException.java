package com.sjsu.assignment.card.exception;

public class InvalidCardNumberException extends CreditCardException{

    public InvalidCardNumberException(Exception ex) {
        super(ex);
    }

    public InvalidCardNumberException(String msg) {
        super(msg);
    }

    public InvalidCardNumberException(String msg, Exception cause) {
        super(msg, cause);
    }
}
