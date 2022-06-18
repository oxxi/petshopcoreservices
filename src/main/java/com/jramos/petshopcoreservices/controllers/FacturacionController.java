package com.jramos.petshopcoreservices.controllers;


import com.jramos.petshopcoreservices.Models.FacturaModels;
import com.jramos.petshopcoreservices.services.BillingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/facturacion")
public class FacturacionController {

    private final BillingService _billingService;

    public FacturacionController(BillingService billingService) {
        _billingService = billingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> GetById(@PathVariable Long id)
    {
        var result = _billingService.getBillingById(id);
        if (result == null) return ResponseEntity.badRequest().body("Billing not found please check id");

        return ResponseEntity.ok(result);
    }

    @PostMapping("/generate")
    public ResponseEntity<?> GenerateBilling(@Valid @RequestBody FacturaModels model)
    {
        _billingService.createBilling(model);
        return ResponseEntity.status(HttpStatus.CREATED).body("Billing created");
    }

    /*
    TODO: revisar si esta funcionalidad aplica
     @GetMapping("detail/{id}")
    public ResponseEntity<?> ShowBillingDetail(@PathVariable Long id)
     {

         return  null;
     }
    */


}
