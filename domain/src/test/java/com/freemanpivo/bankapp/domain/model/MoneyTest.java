package com.freemanpivo.bankapp.domain.model;

import com.freemanpivo.bankapp.domain.exception.IllegalMoneyAmountException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

class MoneyTest {
    private static final String FORMATED_CURRENCY_SYMBOL = "$ ";

    @ParameterizedTest
    @MethodSource("moneySamples")
    void testMoneyCreation(BigDecimal inputAmount) {
        final var money = Money.of(inputAmount);

        Assertions.assertNotNull(money);
        Assertions.assertEquals(inputAmount, money.getAmount());
    }

    @Test
    void testExceptionCreatingMoney() {
        Assertions.assertThrows(IllegalMoneyAmountException.class, () -> Money.of(null));
    }

    @ParameterizedTest
    @MethodSource("formatedMoneySamples")
    void testMoneyPresentation(BigDecimal moneyAmount, String moneyPresentation) {
        final var money = Money.of(moneyAmount);
        Assertions.assertEquals(moneyPresentation, money.getPresentationAmount());
    }

    private static Stream<Arguments> moneySamples() {
        return Stream.of(
                Arguments.of(new BigDecimal("0.00")),
                Arguments.of(new BigDecimal("100.00")),
                Arguments.of(new BigDecimal("2000.00")),
                Arguments.of(new BigDecimal("30000000000000000000.00")),
                Arguments.of(new BigDecimal("-150.00")),
                Arguments.of(new BigDecimal("123.00000000"))
        );
    }

    private static Stream<Arguments> formatedMoneySamples() {
        return Stream.of(
                Arguments.of(new BigDecimal("0.00"), FORMATED_CURRENCY_SYMBOL.concat("0.00")),
                Arguments.of(new BigDecimal("100.00"), FORMATED_CURRENCY_SYMBOL.concat("100.00")),
                Arguments.of(new BigDecimal("2000.00"), FORMATED_CURRENCY_SYMBOL.concat("2000.00")),
                Arguments.of(new BigDecimal("30000000000000000000.00"), FORMATED_CURRENCY_SYMBOL.concat("30000000000000000000.00")),
                Arguments.of(new BigDecimal("-150.00"), FORMATED_CURRENCY_SYMBOL.concat("-150.00")),
                Arguments.of(new BigDecimal("123.00000000"), FORMATED_CURRENCY_SYMBOL.concat("123.00")),
                Arguments.of(new BigDecimal("123.00000000"), FORMATED_CURRENCY_SYMBOL.concat("123.00")),
                Arguments.of(new BigDecimal("12345.99123"), FORMATED_CURRENCY_SYMBOL.concat("12345.99")),
                Arguments.of(new BigDecimal("12345.99499999999"), FORMATED_CURRENCY_SYMBOL.concat("12345.99")),
                Arguments.of(new BigDecimal("12345.995"), FORMATED_CURRENCY_SYMBOL.concat("12346.00")),
                Arguments.of(new BigDecimal("12345.99555"), FORMATED_CURRENCY_SYMBOL.concat("12346.00")),
                Arguments.of(new BigDecimal("12345.9959"), FORMATED_CURRENCY_SYMBOL.concat("12346.00"))
        );
    }
}