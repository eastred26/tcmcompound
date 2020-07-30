package com.tcm.tcmcompound;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tcm.tcmcompound.dao")
public class TcmcompoundApplication {
    public static void main(String[] args) {
        SpringApplication.run(TcmcompoundApplication.class, args);
    }
}
