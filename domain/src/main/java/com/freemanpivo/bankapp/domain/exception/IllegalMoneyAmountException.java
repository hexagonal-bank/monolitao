package com.freemanpivo.bankapp.domain.exception;

public class IllegalMoneyAmountException extends RuntimeException {
    private final String message;

    public IllegalMoneyAmountException() {
        message = "Money can't be [null]";
    }

    public String getMessage() {
        return message;
    }
}
