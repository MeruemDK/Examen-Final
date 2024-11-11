package com.tienda.gestioninventario.servicio;

import com.tienda.gestioninventario.modelo.Proveedor;
import com.tienda.gestioninventario.repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepository;

    public List<Proveedor> listarTodos() {
        return proveedorRepository.findAll();
    }

    public Proveedor obtenerPorId(Long id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public void guardarProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}