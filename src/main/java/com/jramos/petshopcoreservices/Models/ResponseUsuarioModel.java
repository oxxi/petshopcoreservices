package com.jramos.petshopcoreservices.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@ToString
public class ResponseUsuarioModel {

    private Long Id;
    private String Nombre;

    private String Apellido;

    private String Correo;

    private String NombreUsuario;

    private List<String> Rol;

    private List<Long> RolId;
}
