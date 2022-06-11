package com.jramos.petshopcoreservices.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
public class ClienteModels {

    private int id;
    @NotBlank(message = "Nombre es un campo obligatorio")
    private String firstName;
    @NotBlank(message = "Apellido es un campo obligatorio")
    private String lastName;

    private String address;

    private String phoneNumbers;


    @NotNull(message = "Teléfono es un campo obligatorio")
    private String principalPhoneNumber;
}
