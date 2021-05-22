package com.demo.stocks.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StocksTest {

    @Test
    public void returnedIsValidStocksWhenTickerIsNotNull() {
        var stocks = new Stocks();
        stocks.setSymbol("ITUB3");

        var isValid = stocks.isValid();
        Assertions.assertTrue(isValid);
    }

    @Test
    public void returnedIsNotValidStocksWhenTickerIsNotNull() {
        var stocks = new Stocks();
        var isValid = stocks.isValid();
        Assertions.assertFalse(isValid);
    }
}
