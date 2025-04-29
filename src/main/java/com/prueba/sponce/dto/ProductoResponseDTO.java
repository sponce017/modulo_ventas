package com.prueba.sponce.dto;

import lombok.Data;

@Data
public class ProductoResponseDTO {

    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
}