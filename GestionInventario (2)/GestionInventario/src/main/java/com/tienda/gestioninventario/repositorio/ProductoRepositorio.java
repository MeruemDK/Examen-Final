package com.tienda.gestioninventario.repositorio;

import com.tienda.gestioninventario.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Long> {
    List<Producto> findByStockLessThan(Integer cantidad);
}