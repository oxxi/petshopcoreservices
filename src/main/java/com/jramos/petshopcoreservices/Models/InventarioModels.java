package com.jramos.petshopcoreservices.Models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class InventarioModels {

    private Long IdBodega;
    private String Nombre;

    private List<ProductosModels> Productos;

}
