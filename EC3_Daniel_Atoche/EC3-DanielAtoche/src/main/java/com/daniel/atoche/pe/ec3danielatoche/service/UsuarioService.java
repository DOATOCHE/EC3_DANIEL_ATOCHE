package com.daniel.atoche.pe.ec3danielatoche.service;

import java.util.List;

import com.daniel.atoche.pe.ec3danielatoche.model.UsuarioCliente;

public interface UsuarioService {
    void guardar(UsuarioCliente usuario);
    void actualizar(UsuarioCliente usuario);
    void eliminar(Integer id);
    List<UsuarioCliente> listar();
    UsuarioCliente obtener(Integer id);
}
