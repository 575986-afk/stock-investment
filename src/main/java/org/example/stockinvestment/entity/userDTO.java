package org.example.stockinvestment.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class userDTO {

    private String email;
    private String password;
    private int balance;
    private Date createAT;

}
