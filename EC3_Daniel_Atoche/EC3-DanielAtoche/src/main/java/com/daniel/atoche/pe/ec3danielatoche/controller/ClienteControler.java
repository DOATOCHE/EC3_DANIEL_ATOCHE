package com.daniel.atoche.pe.ec3danielatoche.controller;

import com.daniel.atoche.pe.ec3danielatoche.model.Cliente;
import com.daniel.atoche.pe.ec3danielatoche.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {

    @Autowired
    private ClienteService service;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listar(){
        return new ResponseEntity<List<Cliente>>(service.listar(), HttpStatus.OK) ;
    }

    @RequestMapping(path="/guardar", method = RequestMethod.POST)
    public ResponseEntity<Void> guardar(@RequestBody Cliente cliente ){
        service.guardar(cliente);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Integer id){

        Cliente cliente = service.obtener(id);

        if( cliente != null) {
            return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
        }else {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/editar", method = RequestMethod.PUT)
    public ResponseEntity<Void> editar(@RequestBody Cliente cliente){

        Cliente c = service.obtener(cliente.getIdCliente());

        if( c != null) {
            service.actualizar(cliente);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void>eliminar(@PathVariable Integer id){

        Cliente cliente = service.obtener(id);

        if(cliente != null) {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
}
