package com.mx.funeraria.controller;

import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.entidades.ServicioInmediato;
import com.mx.funeraria.services.ServInmediatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("servicio")
public class ServicioInmediatoController {

    @Autowired
    private ServInmediatoService service;

    @GetMapping("/listar")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(200).body(service.findAll());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody ServicioInmediato servicioInmediato){
        System.out.println(servicioInmediato);
        service.guardar(servicioInmediato);
        return ResponseEntity.status(200).build();
    }
}
