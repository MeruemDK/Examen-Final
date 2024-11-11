package com.tienda.gestioninventario.servicio;

import com.tienda.gestioninventario.modelo.Producto;
import com.tienda.gestioninventario.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> obtenerProductosBajoStock() {
        return productoRepository.findByStockLessThan(5); // Asumiendo que 10 es el umbral de stock bajo
    }

}