package com.jramos.petshopcoreservices.controllers;

import com.jramos.petshopcoreservices.Models.BodegaModels;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("warehouse")
public class BodegasController {



    @GetMapping()
    public ResponseEntity<?> GetAll()
    {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable Long id)
    {
        return null;
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateWereHouse(@Valid @RequestBody BodegaModels model)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body("");
    }

    @PutMapping("/update")
    public ResponseEntity<?> UpdateWhereHouse(@Valid @RequestBody BodegaModels model)
    {
        return null;
    }



}
