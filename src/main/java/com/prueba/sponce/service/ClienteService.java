package com.prueba.sponce.service;

import com.prueba.sponce.dto.ClienteRequestDTO;
import com.prueba.sponce.dto.ClienteResponseDTO;
import com.prueba.sponce.dto.PageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

    List<ClienteResponseDTO> listarTodos();

    ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO);

    ClienteResponseDTO obtenerClientePorId(Long id);

    ClienteResponseDTO actualizarCliente(Long id, ClienteRequestDTO clienteRequestDTO);

    void eliminarCliente(Long id);

    PageResponseDTO<ClienteResponseDTO> listarPaginado(String nombre, Pageable pageable);
}

