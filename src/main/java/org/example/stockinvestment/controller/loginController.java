package org.example.stockinvestment.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.stockinvestment.entity.userDTO;
import org.example.stockinvestment.service.loginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class loginController {

    private final loginService ls;

    @GetMapping("/login")
    public String login(){

        return "auth/login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam("email")String email, @RequestParam("password")String password,
                               HttpSession session, Model model){
        userDTO user= ls.login(email, password);

        if(user==null){
            model.addAttribute("error", "이메일 또는 비밀번호가 일치하지 않습니다.");
            return "auth/login";
        }

        session.setAttribute("loginUser",user.getEmail());

        return "redirect:/";

    }

    @GetMapping("/signup")
    public String signup(){

        return "auth/signup";
    }
}
