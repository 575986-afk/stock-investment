package org.example.stockinvestment;

import lombok.RequiredArgsConstructor;
import org.example.stockinvestment.service.StockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StockService stockService;

    @GetMapping("/")
    public String index(Model model) {
        // 로그인 상태 예시 (나중에 세션이나 Spring Security로 대체)
        boolean isLogin = false;
        model.addAttribute("isLogin", isLogin);
        model.addAttribute("username", "홍길동"); // 로그인 시 표시할 이름

        // 주식 종목 리스트 데이터 (StockService 구현체가 제공: 현재 Mock, 추후 KIS API)
        model.addAttribute("stockList", stockService.getPopularStocks());
        return "index";
    }
}
