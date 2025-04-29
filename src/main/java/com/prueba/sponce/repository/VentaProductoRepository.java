package com.prueba.sponce.repository;

import com.prueba.sponce.model.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VentaProductoRepository extends JpaRepository<VentaProducto, Long> {

    @Query(value = """
        SELECT p.nombre, SUM(vp.cantidad) as total_vendido
        FROM venta_producto vp
        JOIN producto p ON p.id = vp.producto_id
        GROUP BY p.nombre
        ORDER BY total_vendido DESC
        LIMIT 3
        """, nativeQuery = true)
    List<Object[]> top3ProductosMasVendidos();

    @Query(value = """
        SELECT COALESCE(SUM(vp.total), 0)
        FROM venta_producto vp
        JOIN venta v ON v.id = vp.venta_id
        WHERE v.fecha >= :fechaInicio
        """, nativeQuery = true)
    Double ingresoUltimoMes(LocalDate fechaInicio);
}

