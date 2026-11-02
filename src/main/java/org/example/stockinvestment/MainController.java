package org.example.stockinvestment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        // 로그인 상태 예시 (나중에 세션이나 Spring Security로 대체)
        boolean isLogin = false;
        model.addAttribute("isLogin", isLogin);
        model.addAttribute("username", "홍길동"); // 로그인 시 표시할 이름

        // 주식 종목 리스트 데이터
        List<StockDto> stockList = Arrays.asList(
                new StockDto("삼성전자", "72,500", "+1,200", "+1.68%", true),
                new StockDto("SK하이닉스", "168,000", "-2,500", "-1.46%", false),
                new StockDto("LG에너지솔루션", "392,000", "+4,000", "+1.03%", true),
                new StockDto("현대차", "245,000", "+3,500", "+1.45%", true),
                new StockDto("셀트리온", "188,200", "-800", "-0.42%", false)
        );

        model.addAttribute("stockList", stockList);
        return "index";
    }
}

class StockDto {
    private String name;
    private String price;
    private String changePrice;
    private String changeRate;
    private boolean isRise;

    public StockDto(String name, String price, String changePrice, String changeRate, boolean isRise) {
        this.name = name;
        this.price = price;
        this.changePrice = changePrice;
        this.changeRate = changeRate;
        this.isRise = isRise;
    }

    public String getName() { return name; }
    public String getPrice() { return price; }
    public String getChangePrice() { return changePrice; }
    public String getChangeRate() { return changeRate; }
    public boolean isRise() { return isRise; }
}