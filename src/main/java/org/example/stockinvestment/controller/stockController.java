package org.example.stockinvestment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class stockController {

    @GetMapping("/stockMarket")
    public String stockMarket(){
        return "stock/stockMarket";
    }

    @GetMapping("/ranking")
    public String ranking(){
        return "stock/ranking";
    }

    @GetMapping("/community")
    public String community(){
        return "stock/community";
    }
}
