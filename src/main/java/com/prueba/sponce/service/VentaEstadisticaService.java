package com.prueba.sponce.service;

import com.prueba.sponce.dto.ClienteMayorIngresoDTO;
import com.prueba.sponce.dto.ProductoMasVendidoDTO;

import java.util.List;
import java.util.Map;

public interface VentaEstadisticaService {

    List<ProductoMasVendidoDTO> obtenerTop3Productos();

    ClienteMayorIngresoDTO clienteMayorIngreso();

    Double ingresoTotalUltimoMes();

}

