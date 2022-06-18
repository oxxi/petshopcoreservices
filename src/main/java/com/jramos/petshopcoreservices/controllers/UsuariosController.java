package com.jramos.petshopcoreservices.controllers;

import com.jramos.petshopcoreservices.Models.CreateUsuarioModel;
import com.jramos.petshopcoreservices.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final IUserService _userService;

    public UsuariosController(IUserService userService) {
        _userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> Get(@PathVariable Long id)
    {
        var result = _userService.GetById(id);
        if( result == null) return ResponseEntity.badRequest().body("User not found please check parameter id");

        return ResponseEntity.ok(result);
    }

    @PostMapping("/add")
    public ResponseEntity<?> Create(@Valid @RequestBody CreateUsuarioModel model)
    {
        var result = _userService.CreateUser(model);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
