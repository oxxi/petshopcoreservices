package com.jramos.petshopcoreservices.controllers;

import com.jramos.petshopcoreservices.Models.LoginModel;
import com.jramos.petshopcoreservices.services.interfaces.ILoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final ILoginService _login;

    public LoginController(ILoginService loginService ) {
        _login = loginService;
    }

    @PostMapping()
    public ResponseEntity<?> Login(@Valid @RequestBody LoginModel model)
    {
        if(!_login.IsValid(model)) return ResponseEntity.badRequest().body("Invalid request please check parameters");
        var token = _login.GenerateToken(model);
        Map<String,String> result = new HashMap<>();
        result.put("Token",token);
        return ResponseEntity.ok(result);
    }
}
