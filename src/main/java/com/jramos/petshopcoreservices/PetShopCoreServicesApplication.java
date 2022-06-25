package com.jramos.petshopcoreservices;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import springfox.documentation.spi.service.contexts.SecurityContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@SpringBootApplication
@ComponentScan(basePackages = "com.jramos.petshopcoreservices.*")
@EnableSwagger2
public class PetShopCoreServicesApplication {

    private static final Logger log = LoggerFactory.getLogger(PetShopCoreServicesApplication.class);
    public static final String AUTHORIZATION_HEADER = "Authorization";
    @Autowired
    private static  Test t;
    private ApiInfo apiInfo() {
        return new ApiInfo("Core API",
                "Api en construcción para petShop",
                "1.0",
                "Terms of service",
                new Contact("Jose Ramos", "", "joseoxi@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    };

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jramos.petshopcoreservices.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope
                = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }

    public static void main(String[] args) {
        SpringApplication.run(PetShopCoreServicesApplication.class, args);
    }

    @Component
    class Test{}
 }
