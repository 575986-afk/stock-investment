package org.example.stockinvestment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class loginController {

    @GetMapping("/login")
    public String login(){

        return "auth/login";
    }

    @GetMapping("/signup")
    public String signup(){

        return "auth/signup";
    }
}
