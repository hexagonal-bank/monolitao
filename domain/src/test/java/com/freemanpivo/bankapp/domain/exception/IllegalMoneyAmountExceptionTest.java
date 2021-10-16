package com.freemanpivo.bankapp.domain.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IllegalMoneyAmountExceptionTest {
    private final IllegalMoneyAmountException exception = new IllegalMoneyAmountException();
    private static final String EXPECTED_MESSAGE = "Money can't be [null]";

    @Test
    void testExceptionCreation() {
        Assertions.assertEquals(EXPECTED_MESSAGE, exception.getMessage());
    }

}