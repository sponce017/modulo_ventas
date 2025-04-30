package com.prueba.sponce.dto;

import lombok.Data;

import java.util.List;

@Data
public class Body {
    private String user;
    private String token;
    private Rol rol;
    private List<String> roles;
    private String tokenType;
    private String estado;
    private String fhProcesamiento;
    private String codigoMsg;
    private String descripcionMsg;
    private String observaciones;
    private String clasificaMsg;

}
