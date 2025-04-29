package com.prueba.sponce.service;

import com.prueba.sponce.dto.ProductoRequestDTO;
import com.prueba.sponce.dto.ProductoResponseDTO;
import com.prueba.sponce.model.Producto;
import com.prueba.sponce.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<ProductoResponseDTO> listarTodos() {
        return productoRepository.findAll().stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoResponseDTO crearProducto(ProductoRequestDTO productoRequestDTO) {
        Producto producto = convertirAEntidad(productoRequestDTO);
        Producto guardado = productoRepository.save(producto);
        return convertirAResponseDTO(guardado);
    }

    @Override
    public ProductoResponseDTO obtenerProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto con ID " + id + " no encontrado."));
        return convertirAResponseDTO(producto);
    }

    @Override
    public ProductoResponseDTO actualizarProducto(Long id, ProductoRequestDTO productoRequestDTO) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Producto con ID " + id + " no encontrado."));

        productoExistente.setNombre(productoRequestDTO.getNombre());
        productoExistente.setPrecio(productoRequestDTO.getPrecio());
        productoExistente.setStock(productoRequestDTO.getStock());

        Producto actualizado = productoRepository.save(productoExistente);
        return convertirAResponseDTO(actualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new NoSuchElementException("Producto con ID " + id + " no encontrado.");
        }
        productoRepository.deleteById(id);
    }

    private Producto convertirAEntidad(ProductoRequestDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        return producto;
    }

    private ProductoResponseDTO convertirAResponseDTO(Producto producto) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        return dto;
    }
}