package org.example.stockinvestment.service;

import org.example.stockinvestment.dto.StockQuoteDto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MockStockServiceTest {

    private final StockService stockService = new MockStockService();

    @Test
    void 인기종목_5개_기존_순서_유지() {
        List<StockQuoteDto> stocks = stockService.getPopularStocks();
        assertEquals(List.of("삼성전자", "SK하이닉스", "LG에너지솔루션", "현대차", "셀트리온"),
                stocks.stream().map(StockQuoteDto::getName).toList());
    }

    @Test
    void 종목코드로_조회() {
        assertEquals("삼성전자", stockService.getQuote("005930").orElseThrow().getName());
        assertTrue(stockService.getQuote("999999").isEmpty());
    }
}
