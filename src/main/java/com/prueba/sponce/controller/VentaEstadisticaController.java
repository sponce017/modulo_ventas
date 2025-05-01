package com.prueba.sponce.controller;

import com.prueba.sponce.dto.ClienteMayorIngresoDTO;
import com.prueba.sponce.dto.IngresoMensualDTO;
import com.prueba.sponce.dto.ProductoMasVendidoDTO;
import com.prueba.sponce.service.VentaEstadisticaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas/estadisticas")
@RequiredArgsConstructor
public class VentaEstadisticaController {

    private final VentaEstadisticaService ventaEstadisticaService;

    @GetMapping("/top-productos")
    public ResponseEntity<List<ProductoMasVendidoDTO>> top3Productos() {
        return ResponseEntity.ok(ventaEstadisticaService.obtenerTop3Productos());
    }

    @GetMapping("/mejor-cliente")
    public ResponseEntity<ClienteMayorIngresoDTO> mejorCliente() {
        return ResponseEntity.ok(ventaEstadisticaService.clienteMayorIngreso());
    }

    @GetMapping("/ingreso-ultimo-mes")
    public ResponseEntity<IngresoMensualDTO> ingresoUltimoMes() {
        double total = ventaEstadisticaService.ingresoTotalUltimoMes();
        return ResponseEntity.ok(new IngresoMensualDTO(total));
    }
}
