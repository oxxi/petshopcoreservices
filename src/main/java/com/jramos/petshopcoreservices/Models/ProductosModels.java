package com.jramos.petshopcoreservices.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
public class ProductosModels {

    private int id;
    @NotBlank(message = "El campo es obligatorio")
    private String nombre;

    @NotBlank(message = "El campo es obligatorio")
    private String descripcion;

    private LocalDateTime fechaCreado;

    private boolean disponible;

    private String Categoria;

    private Long IdCategoria;
}
