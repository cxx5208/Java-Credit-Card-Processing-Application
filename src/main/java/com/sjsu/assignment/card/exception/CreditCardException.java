package com.sjsu.assignment.card.exception;

public class CreditCardException extends RuntimeException {

    public CreditCardException(Exception ex) {
        super(ex);
    }

    public CreditCardException(String msg) {
        super(msg);
    }

    public CreditCardException(String msg, Exception cause) {
        super(msg, cause);
    }

}
