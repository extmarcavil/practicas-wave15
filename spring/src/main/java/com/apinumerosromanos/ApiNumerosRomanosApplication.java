package com.apinumerosromanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "controllers")
public class ApiNumerosRomanosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiNumerosRomanosApplication.class, args);
    }

}
