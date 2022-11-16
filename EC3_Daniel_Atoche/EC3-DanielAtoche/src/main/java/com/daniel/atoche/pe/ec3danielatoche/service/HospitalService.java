package com.daniel.atoche.pe.ec3danielatoche.service;


import java.util.List;

import com.daniel.atoche.pe.ec3danielatoche.model.Hospital;

public interface HospitalService {

    void guardar(Hospital hospital);
    void actualizar(Hospital hospital);
    void eliminar(Integer id);
    List<Hospital> listar();
    Hospital obtener(Integer id);
}
