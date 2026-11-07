package org.example.stockinvestment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.stockinvestment.mapper")
public class StockInvestmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockInvestmentApplication.class, args);
    }
}