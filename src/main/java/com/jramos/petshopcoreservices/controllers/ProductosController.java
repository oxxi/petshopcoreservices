package com.jramos.petshopcoreservices.controllers;

import com.jramos.petshopcoreservices.PetShopCoreServicesApplication;
import com.jramos.petshopcoreservices.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductosController {
    private static final Logger log = LoggerFactory.getLogger(ProductosController.class);
    @Autowired
    private ProductService _productService;

    @GetMapping(value = "/GetServices",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<String[]> GetList(){
        String[] t = _productService.ListOfServices();
        return ResponseEntity.ok(t);
    }

}
