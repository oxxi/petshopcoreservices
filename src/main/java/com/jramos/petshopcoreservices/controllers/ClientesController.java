package com.jramos.petshopcoreservices.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientesController {


    @GetMapping("/GetClientes")
    public String GetClientes()
    {
       return "Hola Mundo";
    }
}
