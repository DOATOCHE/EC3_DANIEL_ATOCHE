package com.daniel.atoche.pe.ec3danielatoche.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daniel.atoche.pe.ec3danielatoche.model.UsuarioCliente;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioCliente, Integer> {
    UsuarioCliente findByUsuario(String usuario);
}
