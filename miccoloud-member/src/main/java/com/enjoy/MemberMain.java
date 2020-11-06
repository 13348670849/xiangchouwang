package com.enjoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MemberMain {

    public static void main(String[] args) {
        SpringApplication.run(MemberMain.class, args);
    }
}
