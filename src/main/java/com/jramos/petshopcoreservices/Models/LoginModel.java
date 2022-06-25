package com.jramos.petshopcoreservices.Models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Setter
@Getter
public class LoginModel {

    @NotNull(message = "Campo Requerido")
    private String UserName;

    @NotNull(message = "Campo Requerido")
    @NotBlank(message = "La contraseña es un campo requerido")
    private String Password;

}
