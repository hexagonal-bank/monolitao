package com.freemanpivo.bankapp.domain.model;

import com.freemanpivo.bankapp.domain.exception.IllegalMoneyAmountException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private final BigDecimal amount;
    private final String currency = "$"; // TODO: add multi-currency support.

    private Money(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalMoneyAmountException();
        }
        this.amount = amount;
    }

    public static Money of(BigDecimal amount) {
        return new Money(amount);
    }

    public Money plus(Money addition) {
        return Money.of(this.amount.add(addition.amount));
    }

    public Money minus(Money discount) {
        return Money.of(this.amount.subtract(discount.amount));
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getPresentationAmount() {
        return currency
                .concat(" ")
                .concat(amount.setScale(2, RoundingMode.HALF_EVEN).toString());
    }
}
