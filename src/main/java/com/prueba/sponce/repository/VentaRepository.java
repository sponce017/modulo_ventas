package com.prueba.sponce.repository;

import com.prueba.sponce.dto.ClienteMayorIngresoProjection;
import com.prueba.sponce.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query(value = """
        SELECT 
            c.nombre AS cliente, 
            SUM(vp.total) AS totalGenerado
        FROM venta_producto vp
        JOIN venta v ON v.id = vp.venta_id
        JOIN cliente c ON c.id = v.cliente_id
        GROUP BY c.nombre
        ORDER BY totalGenerado DESC
        LIMIT 1
        """, nativeQuery = true)
    ClienteMayorIngresoProjection clienteMayorIngreso();
}