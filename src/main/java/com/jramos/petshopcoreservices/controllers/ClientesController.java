package com.jramos.petshopcoreservices.controllers;

import com.jramos.petshopcoreservices.Models.ClienteModels;
import com.jramos.petshopcoreservices.services.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {


    private final IClientService _clientService;

    @Autowired
    public ClientesController(IClientService clientService) {

        _clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<?> getClientes()
    {
        List<ClienteModels> models = (List<ClienteModels>) _clientService.getAll();

        return ResponseEntity.ok(models);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable long id)
    {
        ClienteModels model = _clientService.getById(id);

        if(model == null) return ResponseEntity.badRequest().body("unexpected value, please check the id");

        return ResponseEntity.ok(model);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> createClient(@Valid @RequestBody ClienteModels model)
    {
        var dto = _clientService.save(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClient(@Valid @RequestBody ClienteModels model, @RequestParam long id)
    {
        var user = _clientService.getById(id);
        if(user == null) return  ResponseEntity.badRequest().body("Cliente no encontrado");

        var result = _clientService.update(model);

        return ResponseEntity.ok(result);
    }
}
