package com.demo.stocks.entity;

import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

public class StocksWrapper {

    private List<Stocks> stocks = new ArrayList<>();

    @Deprecated
    public StocksWrapper() {
    }

    public StocksWrapper(@NonNull List<Stocks> stocks) {
        this.stocks = stocks;
    }

    public List<Stocks> getStocks() {
        return List.copyOf(stocks);
    }

    public void setStocks(List<Stocks> stocks) {
        this.stocks = stocks;
    }
}
