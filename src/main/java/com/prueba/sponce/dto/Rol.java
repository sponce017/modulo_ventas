package com.prueba.sponce.dto;

import lombok.Data;

import java.util.List;

@Data
public class Rol {
    private String nombre;
    private String codigo;
    private String descripcion;
    private String rolSuperior;
    private String nivel;
    private String activo;
    private List<String> permisos;
}
