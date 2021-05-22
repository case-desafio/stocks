package com.demo.stocks.controller;

import com.demo.stocks.entity.Stocks;
import com.demo.stocks.entity.StocksWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stocks", url = "${stocks.url}")
public interface StocksClient {

    @GetMapping
    StocksWrapper findAll();

    @GetMapping("/{symbol}")
    Stocks findByTicker(@PathVariable String symbol);

}
