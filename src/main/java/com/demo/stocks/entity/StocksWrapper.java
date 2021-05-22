package com.demo.stocks.entity;

import java.util.ArrayList;
import java.util.List;

public class StocksWrapper {

    private List<Stocks> stocks = new ArrayList<>();

    public StocksWrapper() {
    }

    public StocksWrapper(List<Stocks> stocks) {
        this.stocks = stocks;
    }

    public List<Stocks> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stocks> stocks) {
        this.stocks = stocks;
    }
}
