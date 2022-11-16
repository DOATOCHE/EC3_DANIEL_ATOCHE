package com.daniel.atoche.pe.ec3danielatoche.service;

import java.util.List;

import com.daniel.atoche.pe.ec3danielatoche.model.Cliente;

public interface ClienteService {
    void guardar(Cliente cliente);
    void actualizar(Cliente cliente);
    void eliminar(Integer id);
    List<Cliente> listar();
    Cliente obtener(Integer id);
}
