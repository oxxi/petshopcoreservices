package com.jramos.petshopcoreservices.Models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class FacturaModels {

    @ReadOnlyProperty
    private Long Id;
    private String NombreCliente;
    private String RTN;
    @ReadOnlyProperty
    private LocalDateTime CreateAt;

    private List<FacturaDetalleModels> Detalle;
}
