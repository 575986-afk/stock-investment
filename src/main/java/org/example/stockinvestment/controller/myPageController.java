package org.example.stockinvestment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class myPageController {

    @GetMapping("/mypage")
    public String page(){
        return "mypage/page";
    }
}
