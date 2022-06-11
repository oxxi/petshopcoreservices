package com.jramos.petshopcoreservices.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FacturaDetalleModels {

    private Long id;
    private String Nombre;
    private Double Precio;
    private Integer Cantidad;
    private boolean Descuento;
    private Double ValorDescuento;


}
