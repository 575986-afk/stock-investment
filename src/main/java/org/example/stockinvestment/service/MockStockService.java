package org.example.stockinvestment.service;

import org.example.stockinvestment.dto.StockQuoteDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * 하드코딩 시세를 제공하는 StockService 구현체.
 * <p>
 * 기존 MainController 에 있던 데이터를 그대로 옮겼다. KIS appkey 발급 전 개발용이며,
 * {@code stock.data-source=mock} 이거나 설정이 없을 때 활성화된다.
 */
@Service
@ConditionalOnProperty(name = "stock.data-source", havingValue = "mock", matchIfMissing = true)
public class MockStockService implements StockService {

    private static final List<StockQuoteDto> POPULAR_STOCKS = List.of(
            quote("005930", "삼성전자", "KOSPI", 72_500, 1_200, "1.68"),
            quote("000660", "SK하이닉스", "KOSPI", 168_000, -2_500, "-1.46"),
            quote("373220", "LG에너지솔루션", "KOSPI", 392_000, 4_000, "1.03"),
            quote("005380", "현대차", "KOSPI", 245_000, 3_500, "1.45"),
            quote("068270", "셀트리온", "KOSPI", 188_200, -800, "-0.42")
    );

    @Override
    public List<StockQuoteDto> getPopularStocks() {
        return POPULAR_STOCKS;
    }

    @Override
    public Optional<StockQuoteDto> getQuote(String code) {
        return POPULAR_STOCKS.stream()
                .filter(stock -> stock.getCode().equals(code))
                .findFirst();
    }

    private static StockQuoteDto quote(String code, String name, String market,
                                       long price, long changePrice, String changeRate) {
        return StockQuoteDto.builder()
                .code(code)
                .name(name)
                .market(market)
                .price(price)
                .changePrice(changePrice)
                .changeRate(new BigDecimal(changeRate))
                .build();
    }
}
