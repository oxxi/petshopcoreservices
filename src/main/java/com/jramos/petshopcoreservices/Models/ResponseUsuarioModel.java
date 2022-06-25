package com.jramos.petshopcoreservices.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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


    public ResponseUsuarioModel toResponseUsuario(CreateUsuarioModel model)
    {
       var result =new  ResponseUsuarioModel();
       result.setNombre(model.getNombre());
       result.setNombreUsuario(model.getNombreUsuario());
       result.setApellido(model.getApellido());
       result.setCorreo(model.getCorreo());
       return  result;
    }

}
