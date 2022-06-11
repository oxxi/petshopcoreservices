package com.jramos.petshopcoreservices.controllers;


import com.jramos.petshopcoreservices.Models.ProductosModels;
import com.jramos.petshopcoreservices.services.interfaces.IProductService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@RestController
@RequestMapping("/productos")
public class ProductosController {
    private static final Logger log = LoggerFactory.getLogger(ProductosController.class);

    private final IProductService _productService;


    public ProductosController(IProductService productService)
    {
        log.info("productos controller init");
       _productService = productService;
    }


    @GetMapping("/")
    public ResponseEntity<?> getAll()
    {
        var result= _productService.getAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getById(@PathVariable Long id)
    {
        var product = _productService.getById(id);
        if(product == null){ return  ResponseEntity.badRequest().body("unexpected value please check parameter id ");}

        return ResponseEntity.ok(product);
    }


    @PostMapping("/add")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductosModels model)
    {
        var result = _productService.save(model);

        return  ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProducto(@Valid @RequestBody ProductosModels model,@PathVariable Long id)
    {
        var producto = _productService.getById(id);
        if (producto == null) { return ResponseEntity.badRequest().body("Product not found, please check parameter id"); }

        var result = _productService.update(model);
        return ResponseEntity.ok(result);
    }
}
