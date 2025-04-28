package com.mx.funeraria.controller;

import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.entidades.Recordatorios;
import com.mx.funeraria.services.ClientesService;
import com.mx.funeraria.services.RecordatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recordatorio")
public class RecordatoriosController {

    @Autowired
    private ClientesService service2;

    @Autowired
    private RecordatoriosService service;

    @GetMapping("/listar")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(200).body(service.listarRecordatorios());
    }

    @PostMapping("/buscar/cliente")
    public ResponseEntity<?> findByCliente(@RequestBody String email){
        Clientes clientes = service2.buscarClientePorEmail(email);
        System.out.println(service.buscarPorCliente(clientes));
        return ResponseEntity.status(200).body(service.buscarPorCliente(clientes));
    }

    @PostMapping("/eliminar")
    public ResponseEntity<?> delete(@RequestBody Recordatorios recordatorios){
        service.eliminarRecordatorios(recordatorios);
        return ResponseEntity.status(200).build();
    }





}
