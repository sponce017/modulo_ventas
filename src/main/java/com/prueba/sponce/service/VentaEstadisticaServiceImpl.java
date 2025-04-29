package com.prueba.sponce.service;

import com.prueba.sponce.dto.ClienteMayorIngresoDTO;
import com.prueba.sponce.dto.ClienteMayorIngresoProjection;
import com.prueba.sponce.dto.ProductoMasVendidoDTO;
import com.prueba.sponce.repository.VentaProductoRepository;
import com.prueba.sponce.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class VentaEstadisticaServiceImpl implements VentaEstadisticaService {

    private final VentaProductoRepository ventaProductoRepository;
    private final VentaRepository ventaRepository;

    @Override
    public List<ProductoMasVendidoDTO> obtenerTop3Productos() {
        List<Object[]> resultados = ventaProductoRepository.top3ProductosMasVendidos();
        List<ProductoMasVendidoDTO> respuesta = new ArrayList<>();

        for (Object[] row : resultados) {
            String nombre = (String) row[0];
            Long cantidad = ((Number) row[1]).longValue();
            respuesta.add(new ProductoMasVendidoDTO(nombre, cantidad));
        }

        return respuesta;
    }

    @Override
    public ClienteMayorIngresoDTO clienteMayorIngreso() {
        ClienteMayorIngresoProjection projection = ventaRepository.clienteMayorIngreso();

        if (projection == null) {
            return new ClienteMayorIngresoDTO("N/A", 0.0);
        }

        return new ClienteMayorIngresoDTO(
                projection.getCliente(),
                projection.getTotalGenerado() != null ? projection.getTotalGenerado() : 0.0
        );
    }

    @Override
    public Double ingresoTotalUltimoMes() {
        LocalDate haceUnMes = LocalDate.now().minusMonths(1);
        return ventaProductoRepository.ingresoUltimoMes(haceUnMes);
    }
}
