package com.prueba.sponce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteMayorIngresoDTO {

    private String cliente;
    private Double totalGenerado;
}

