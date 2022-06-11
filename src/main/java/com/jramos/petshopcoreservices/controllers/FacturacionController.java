package com.jramos.petshopcoreservices.controllers;


import com.jramos.petshopcoreservices.Models.FacturaModels;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.validation.Valid;

@RestController
@RequestMapping("/facturacion")
public class FacturacionController {



    @GetMapping("/{id}")
    public EntityResponse<?> GetById(@PathVariable Long id)
    {


        return null;
    }

    @PostMapping("/generate")
    public EntityResponse<?> GenerateBilling(@Valid @RequestBody FacturaModels model)
    {

        return null;
    }

    @GetMapping("detail/{id}")
    public EntityResponse<?> ShowBillingDetail(@PathVariable Long id)
    {

        return  null;
    }


}
