package com.mx.funeraria.controller;

import com.mx.funeraria.entidades.PersonalizacionServicios;
import com.mx.funeraria.services.PersonalizacionServService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("personalizacion")
public class PersonalizacionServiciosController {

    @Autowired
    private PersonalizacionServService service;

    @GetMapping("/listar")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(200).body(service.listarPersonalizacionServicios());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody PersonalizacionServicios personalizacionServicios){
        System.out.println(personalizacionServicios);
        service.guardarPersonalizacionServicios(personalizacionServicios);
        return ResponseEntity.status(200).build();
    }
}
