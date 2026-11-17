package org.example.stockinvestment.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StockQuoteDtoTest {

    private StockQuoteDto quote(long price, long change, String rate) {
        return StockQuoteDto.builder()
                .code("005930").name("삼성전자").market("KOSPI")
                .price(price).changePrice(change).changeRate(new BigDecimal(rate))
                .build();
    }

    @Test
    void 상승_종목_표시형식() {
        StockQuoteDto q = quote(72_500, 1_200, "1.68");
        assertTrue(q.isRise());
        assertFalse(q.isFall());
        assertEquals("72,500", q.getFormattedPrice());
        assertEquals("+1,200", q.getFormattedChangePrice());
        assertEquals("+1.68%", q.getFormattedChangeRate());
        assertEquals(71_300, q.getPreviousClose());
    }

    @Test
    void 하락_종목_표시형식() {
        StockQuoteDto q = quote(168_000, -2_500, "-1.46");
        assertFalse(q.isRise());
        assertTrue(q.isFall());
        assertEquals("-2,500", q.getFormattedChangePrice());
        assertEquals("-1.46%", q.getFormattedChangeRate());
    }

    @Test
    void 보합_종목() {
        StockQuoteDto q = quote(10_000, 0, "0");
        assertFalse(q.isRise());
        assertFalse(q.isFall());
        assertEquals("0", q.getFormattedChangePrice());
        assertEquals("0.00%", q.getFormattedChangeRate());
    }

    @Test
    void 등락률_계산() {
        assertEquals(new BigDecimal("1.68"), StockQuoteDto.calculateChangeRate(72_500, 1_200));
        assertEquals(new BigDecimal("-0.42"), StockQuoteDto.calculateChangeRate(188_200, -800));
        assertEquals(new BigDecimal("0.00"), StockQuoteDto.calculateChangeRate(0, 0));
    }
}
