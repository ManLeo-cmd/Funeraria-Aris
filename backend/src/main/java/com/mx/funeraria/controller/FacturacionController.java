package com.mx.funeraria.controller;


import com.mx.funeraria.entidades.Facturacion;
import com.mx.funeraria.entidades.ServicioInmediato;
import com.mx.funeraria.services.FacturacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("facturacion")
public class FacturacionController {

    @Autowired
    private FacturacionService service;

    @GetMapping("/listar")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(200).body(service.listarFacturas());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody Facturacion facturacion){
        service.guardarFactura(facturacion);
        return ResponseEntity.status(200).build();
    }
}
