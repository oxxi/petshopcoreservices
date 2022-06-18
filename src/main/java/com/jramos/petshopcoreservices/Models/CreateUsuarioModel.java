package com.jramos.petshopcoreservices.Models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class CreateUsuarioModel {

    @NotNull(message = "Campo Requerido")
    private String Nombre;
    @NotNull(message = "Campo Requerido")
    private String Apellido;
    @NotNull(message = "Campo Requerido")
    @Email(message = "formato de correo no válido")
    private String Correo;
    @NotNull(message = "Campo Requerido")
    private String NombreUsuario;
    @NotNull(message = "Campo Requerido")
    private Byte[] Password;

    private List<String> Rol;

    private List<Long> RolId;
}
