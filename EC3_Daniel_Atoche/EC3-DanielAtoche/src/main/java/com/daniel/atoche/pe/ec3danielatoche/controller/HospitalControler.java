package com.daniel.atoche.pe.ec3danielatoche.controller;

import com.daniel.atoche.pe.ec3danielatoche.model.Hospital;
import com.daniel.atoche.pe.ec3danielatoche.service.HospitalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalControler {

    @Autowired
    private HospitalService service;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<Hospital>> listar(){
        return new ResponseEntity<List<Hospital>>(service.listar(), HttpStatus.OK) ;
    }

    @RequestMapping(path="/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Hospital hospital ){
        service.guardar(hospital);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Hospital> obtenerPorId(@PathVariable Integer id){

        Hospital hospital = service.obtener(id);

        if( hospital != null) {
            return new ResponseEntity<Hospital>(hospital, HttpStatus.OK);
        }else {
            return new ResponseEntity<Hospital>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> editar(@RequestBody Hospital hospital){

        Hospital h = service.obtener(hospital.getIdHospital());

        if( h != null) {
            service.actualizar(hospital);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void>eliminar(@PathVariable Integer id){

        Hospital hospital = service.obtener(id);

        if(hospital != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
