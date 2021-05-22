package com.demo.stocks.controller.impl;

import com.demo.stocks.controller.StocksClient;
import com.demo.stocks.controller.StocksController;
import com.demo.stocks.entity.Stocks;
import com.demo.stocks.exceptions.StockNotFoundException;
import com.demo.stocks.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class StocksControllerImpl implements StocksController {

    private static final Logger log =
            LoggerFactory.getLogger(StocksControllerImpl.class);

    private final StocksClient stocksClient;

    public StocksControllerImpl(StocksClient stocksClient) {
        this.stocksClient = stocksClient;
    }

    @Override
    public List<Stocks> findAll() {
        try {
            log.info("Buscando cotação de todas as ações");
            return stocksClient.findAll().getStocks();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        }
    }

    @Override
    public Stocks findBySymbol(String ticker) {
        if (StringUtils.isBlank(ticker)) {
            throw new IllegalArgumentException("Ticker não informado");
        }

        log.info("Buscando cotação do ticker [" + ticker + "]");
        var stocksResponse= stocksClient.findByTicker(ticker);

        if (!stocksResponse.isValid()) {
            log.info("Nenhuma cotação encontrada para o ticker [" + ticker + "]");
            throw new StockNotFoundException(ticker);
        }
        log.info("Retornando cotação do ticker [" + ticker + "]");
        return stocksResponse;
    }

}
