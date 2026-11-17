package org.example.stockinvestment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 화면 표시용 주식 시세 DTO.
 * <p>
 * 기존 StockDto(문자열 가격)를 대체한다. 가격/등락은 숫자 타입으로 보관해
 * 평가금액·손익 계산에 그대로 쓸 수 있고, 화면용 문자열은 getFormatted*() 로 만든다.
 * 데이터 출처(Mock, 한국투자증권 API 등)와 무관하게 동일한 형태를 유지한다.
 */
@Getter
@Builder
@AllArgsConstructor
@ToString
public class StockQuoteDto {

    /** 종목코드 (예: 005930) */
    private final String code;
    /** 종목명 */
    private final String name;
    /** 시장 구분 (KOSPI, KOSDAQ, NASDAQ ...) */
    private final String market;
    /** 현재가 (원) */
    private final long price;
    /** 전일 대비 (원, 하락 시 음수) */
    private final long changePrice;
    /** 전일 대비 등락률 (%, 하락 시 음수, 예: 1.68) */
    private final BigDecimal changeRate;

    /** 전일 종가 = 현재가 - 전일 대비 */
    public long getPreviousClose() {
        return price - changePrice;
    }

    /** 상승 여부 (보합은 false) */
    public boolean isRise() {
        return changePrice > 0;
    }

    /** 하락 여부 */
    public boolean isFall() {
        return changePrice < 0;
    }

    /** 전일 대비와 전일 종가로 등락률(%)을 계산한다. 소수점 둘째 자리 반올림. */
    public static BigDecimal calculateChangeRate(long price, long changePrice) {
        long previousClose = price - changePrice;
        if (previousClose == 0) {
            return BigDecimal.ZERO.setScale(2);
        }
        return BigDecimal.valueOf(changePrice)
                .multiply(BigDecimal.valueOf(100))
                .divide(BigDecimal.valueOf(previousClose), 2, RoundingMode.HALF_UP);
    }

    // ===== 화면 표시용 =====

    /** "72,500" */
    public String getFormattedPrice() {
        return new DecimalFormat("#,##0").format(price);
    }

    /** "+1,200" / "-2,500" / "0" */
    public String getFormattedChangePrice() {
        if (changePrice == 0) {
            return "0";
        }
        return new DecimalFormat("+#,##0;-#,##0").format(changePrice);
    }

    /** "+1.68%" / "-1.46%" / "0.00%" */
    public String getFormattedChangeRate() {
        if (changeRate == null || changeRate.signum() == 0) {
            return "0.00%";
        }
        return new DecimalFormat("+0.00;-0.00").format(changeRate) + "%";
    }
}
