package com.demo.stocks.exceptions;

public class StockNotFoundException extends NoResultException {

    public StockNotFoundException(String ticker) {
        super(String.format("Cotação não encontrada: Ticker[%s]", ticker));
    }
}
