package org.example.stockinvestment.service;

import org.example.stockinvestment.dto.StockQuoteDto;

import java.util.List;
import java.util.Optional;

/**
 * 주식 시세 조회 서비스.
 * <p>
 * 컨트롤러는 이 인터페이스에만 의존한다. 구현체는 application.yaml 의
 * {@code stock.data-source} 값으로 선택한다.
 * <ul>
 *     <li>mock : {@link MockStockService} - 하드코딩 데이터 (현재 기본값)</li>
 *     <li>kis  : KisStockService - 한국투자증권 Open API (추후 구현)</li>
 * </ul>
 */
public interface StockService {

    /** 메인 페이지 "실시간 인기 종목" 목록 */
    List<StockQuoteDto> getPopularStocks();

    /** 종목코드로 현재 시세 조회. 없는 종목이면 빈 Optional */
    Optional<StockQuoteDto> getQuote(String code);
}
