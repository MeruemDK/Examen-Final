package com.tienda.gestioninventario.repositorio;

import com.tienda.gestioninventario.modelo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepositorio extends JpaRepository<Admin, Long> {
    Admin findByNombre(String nombre);
}