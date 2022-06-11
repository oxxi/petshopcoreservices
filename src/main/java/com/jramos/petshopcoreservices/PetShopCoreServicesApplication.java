package com.jramos.petshopcoreservices;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;




@SpringBootApplication
@ComponentScan(basePackages = "com.jramos.petshopcoreservices.*")
@EnableSwagger2
public class PetShopCoreServicesApplication {

    private static final Logger log = LoggerFactory.getLogger(PetShopCoreServicesApplication.class);

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jramos.petshopcoreservices.controllers"))
                .paths(PathSelectors.any())
                .build();
    }
    public static void main(String[] args) {
        log.info("Iniciando API");
        SpringApplication.run(PetShopCoreServicesApplication.class, args);
    }




}
