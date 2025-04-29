package com.prueba.sponce.service;

import com.prueba.sponce.dto.ProductoRequestDTO;
import com.prueba.sponce.dto.ProductoResponseDTO;

import java.util.List;

public interface ProductoService {

    List<ProductoResponseDTO> listarTodos();

    ProductoResponseDTO crearProducto(ProductoRequestDTO productoRequestDTO);

    ProductoResponseDTO obtenerProductoPorId(Long id);

    ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO productoRequestDTO);

    void eliminarProducto(Long id);
}