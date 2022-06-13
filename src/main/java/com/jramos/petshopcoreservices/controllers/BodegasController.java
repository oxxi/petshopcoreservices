package com.jramos.petshopcoreservices.controllers;

import com.jramos.petshopcoreservices.Models.BodegaModels;
import com.jramos.petshopcoreservices.services.interfaces.IWareHouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("warehouse")
public class BodegasController {

    private final IWareHouseService _wareHouseService;

    public BodegasController(IWareHouseService wareHouseService)
    {

        _wareHouseService = wareHouseService;
    }

    @GetMapping()
    public ResponseEntity<?> GetAll()
    {
        var model = _wareHouseService.GetAll();
        return ResponseEntity.ok(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable Long id)
    {
        var result = _wareHouseService.GetById(id);
        if(result == null) return ResponseEntity.badRequest().body("unexpected value, please check the id");
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create")
    public ResponseEntity<?> CreateWereHouse(@Valid @RequestBody BodegaModels model)
    {
        var dto = _wareHouseService.Create(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> UpdateWhereHouse(@Valid @RequestBody BodegaModels model,@RequestParam long id)
    {
        var bodega = _wareHouseService.GetById(id);
        if(bodega == null) return  ResponseEntity.badRequest().body("Bodega no encontrada");
        _wareHouseService.Update(model);
        var result = _wareHouseService.GetById(id);

        return ResponseEntity.ok(result);
    }



}
