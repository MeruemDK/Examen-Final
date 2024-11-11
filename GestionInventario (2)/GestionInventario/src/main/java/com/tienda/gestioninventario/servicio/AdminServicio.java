package com.tienda.gestioninventario.servicio;

import com.tienda.gestioninventario.modelo.Admin;
import com.tienda.gestioninventario.repositorio.AdminRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServicio {

    @Autowired
    private AdminRepositorio adminRepositorio;

    public Admin guardarAdmin(Admin admin) {
        return adminRepositorio.save(admin);
    }

    public boolean existeAdmin(String nombre) {
        return adminRepositorio.findByNombre(nombre) != null;
    }
}