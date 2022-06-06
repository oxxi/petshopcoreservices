package com.jramos.petshopcoreservices.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter
@Getter
@ToString
public class ProductosModels {

    private int id;

    private String nombre;

    private String descripcion;

    private Date fechaCreado;

    private boolean disponible;
}
