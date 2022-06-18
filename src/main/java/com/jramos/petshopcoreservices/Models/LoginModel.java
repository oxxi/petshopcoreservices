package com.jramos.petshopcoreservices.Models;

import javax.validation.constraints.NotNull;

public class LoginModel {

    @NotNull(message = "Campo Requerido")
    private String UserName;

    @NotNull(message = "Campo Requerido")
    private String Password;

}
