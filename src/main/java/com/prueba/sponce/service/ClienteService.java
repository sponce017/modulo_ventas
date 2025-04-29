package com.prueba.sponce.service;

import com.prueba.sponce.dto.ClienteRequestDTO;
import com.prueba.sponce.dto.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteResponseDTO> listarTodos();

    ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO);

    ClienteResponseDTO obtenerClientePorId(Long id);

    ClienteResponseDTO actualizarCliente(Long id, ClienteRequestDTO clienteRequestDTO);

    void eliminarCliente(Long id);
}

