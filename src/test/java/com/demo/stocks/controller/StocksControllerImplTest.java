package com.demo.stocks.controller;

import com.demo.stocks.config.ExceptionAdviceConfiguration;
import com.demo.stocks.controller.impl.StocksControllerImpl;
import com.demo.stocks.entity.Stocks;
import com.demo.stocks.entity.StocksWrapper;
import com.demo.stocks.exceptions.StockNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class StocksControllerImplTest {

    private static final String CONTEXT_PATH = "/stocks";
    private static final String URI_PATH = CONTEXT_PATH + "/";

    @InjectMocks
    private StocksControllerImpl stocksController;

    @Mock
    private StocksClient stocksClient;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(stocksController)
                .setControllerAdvice(new ExceptionAdviceConfiguration())
                .build();
    }

    @Test
    public void returnedOkStatusWhenGetIsCalled() throws Exception {
        final String BBAS3 = "BBAS3";
        final String ITSA4 = "ITSA4";

        var bbas3Ticker = new Stocks(BBAS3);
        var itsa4Ticker = new Stocks(ITSA4);

        var stocksWrapper = new StocksWrapper(List.of(
                bbas3Ticker,
                itsa4Ticker
        ));

        when(stocksClient.findAll()).thenReturn(stocksWrapper);

        mockMvc.perform(get(URI_PATH)
                .contextPath(CONTEXT_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].symbol", is(equalTo(BBAS3))))
                .andExpect(jsonPath("$[1].symbol", is(equalTo(ITSA4))));
    }

    @Test
    public void returnedOkStatusWhenGetWithTickerIsCalled() throws Exception {
        final String BBAS3 = "BBAS3";

        var bbas3Ticker = new Stocks(BBAS3);

        when(stocksClient.findByTicker(BBAS3)).thenReturn(bbas3Ticker);

        mockMvc.perform(get(URI_PATH + "{ticker}", BBAS3)
                .contextPath(CONTEXT_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.symbol", is(equalTo(BBAS3))));
    }

    @Test
    public void givenStockNotFoundExceptionWhenGetTickerIsCalledWithNullTicker() throws Exception {
        final String ticker = "ABC123";

        when(stocksClient.findByTicker(any())).thenReturn(new Stocks());

        mockMvc.perform(get(URI_PATH + "{ticker}", ticker)
                .contextPath(CONTEXT_PATH)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StockNotFoundException));
    }
}
