package com.demo.stocks.controller;

import com.demo.stocks.entity.Stocks;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface StocksController {

    @GetMapping
    @Cacheable(value = "stocksCache", key = "'stocks'")
    @ResponseStatus(code = HttpStatus.OK)
    List<Stocks> findAll();

    @GetMapping("/{ticker}")
    @ResponseStatus(code = HttpStatus.OK)
    @Cacheable(value = "tickerStocksCache", key = "#ticker")
    Stocks findBySymbol(@PathVariable(required = false) String ticker);
}
