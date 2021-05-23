package com.demo.stocks.controller;

import com.demo.stocks.entity.Stocks;
import feign.FeignException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface StocksController {

    @GetMapping
    @Cacheable(value = "stocksCache", key = "'stocks'")
    @ResponseStatus(code = HttpStatus.OK)
    @Retryable( value = FeignException.FeignClientException.NotFound.class,
            maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    List<Stocks> findAll();

    @GetMapping("/{ticker}")
    @ResponseStatus(code = HttpStatus.OK)
    @Cacheable(value = "tickerStocksCache", key = "#ticker")
    @Retryable( value = FeignException.FeignClientException.NotFound.class,
            maxAttemptsExpression = "${retry.maxAttempts}",
            backoff = @Backoff(delayExpression = "${retry.maxDelay}"))
    Stocks findBySymbol(@PathVariable(required = false) String ticker);
}
