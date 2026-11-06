package org.example.stockinvestment.service;

import lombok.RequiredArgsConstructor;
import org.example.stockinvestment.entity.userDTO;
import org.example.stockinvestment.mapper.loginMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class loginService {

    private final loginMapper lm;

    public userDTO login(String email, String password){
        return lm.findByUser(email, password);
    }



}
