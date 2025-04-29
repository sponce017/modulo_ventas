package com.prueba.sponce.service;

import com.prueba.sponce.dto.ClienteRequestDTO;
import com.prueba.sponce.dto.ClienteResponseDTO;
import com.prueba.sponce.model.Cliente;
import com.prueba.sponce.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<ClienteResponseDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteResponseDTO crearCliente(ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = convertirAEntidad(clienteRequestDTO);
        Cliente guardado = clienteRepository.save(cliente);
        return convertirAResponseDTO(guardado);
    }

    @Override
    public ClienteResponseDTO obtenerClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente con ID " + id + " no encontrado."));
        return convertirAResponseDTO(cliente);
    }

    @Override
    public ClienteResponseDTO actualizarCliente(Long id, ClienteRequestDTO clienteRequestDTO) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente con ID " + id + " no encontrado."));

        clienteExistente.setNombre(clienteRequestDTO.getNombre());
        clienteExistente.setCorreo(clienteRequestDTO.getCorreo());

        Cliente actualizado = clienteRepository.save(clienteExistente);
        return convertirAResponseDTO(actualizado);
    }

    @Override
    public void eliminarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new NoSuchElementException("Cliente con ID " + id + " no encontrado.");
        }
        clienteRepository.deleteById(id);
    }

    private Cliente convertirAEntidad(ClienteRequestDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        return cliente;
    }

    private ClienteResponseDTO convertirAResponseDTO(Cliente cliente) {
        ClienteResponseDTO dto = new ClienteResponseDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setCorreo(cliente.getCorreo());
        return dto;
    }
}