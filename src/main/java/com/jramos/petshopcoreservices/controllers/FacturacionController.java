package com.jramos.petshopcoreservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facturacion")
public class FacturacionController {

    @ResponseBody
    String Facturacion()
    {
        return "";
    }
}
