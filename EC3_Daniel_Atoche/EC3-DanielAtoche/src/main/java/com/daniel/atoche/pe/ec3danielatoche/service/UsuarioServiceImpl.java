package com.daniel.atoche.pe.ec3danielatoche.service;

import com.daniel.atoche.pe.ec3danielatoche.model.Hospital;
import com.daniel.atoche.pe.ec3danielatoche.model.UsuarioCliente;
import com.daniel.atoche.pe.ec3danielatoche.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;


    @Override
    public void guardar(UsuarioCliente usuario) {
        repository.save(usuario);
    }

    @Override
    public void actualizar(UsuarioCliente usuario) {
        repository.saveAndFlush(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<UsuarioCliente> listar() {
        return repository.findAll();
    }

    @Override
    public UsuarioCliente obtener(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
