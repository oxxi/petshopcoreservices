package com.jramos.petshopcoreservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "com")
@SpringBootApplication
public class PetShopCoreServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetShopCoreServicesApplication.class, args);
    }

}
