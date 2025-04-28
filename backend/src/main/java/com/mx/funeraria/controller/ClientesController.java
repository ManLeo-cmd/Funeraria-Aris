package com.mx.funeraria.controller;

import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// REST -> XML JSON ...
@RestController
@RequestMapping("clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping("/listar")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(200).body(clientesService.listarClientes());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return ResponseEntity.status(200).body(clientesService.buscarCliente(id));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody Clientes clientes){
        if(clientesService.buscarCliente(clientes.getId()) != null){
            return ResponseEntity.status(500).body("ERROR");
        }

        clientesService.guardarCliente(clientes);
        return ResponseEntity.status(200).build();
    }

    @PutMapping("/editar")
    public ResponseEntity<?> update(@RequestBody Clientes clientes){

        if(clientesService.buscarCliente(clientes.getId()) == null){
            return ResponseEntity.status(500).build();
        }

        clientesService.guardarCliente(clientes);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/eliminar")
    public ResponseEntity<?> delete(@RequestBody Clientes clientes){

        if(clientesService.buscarCliente(clientes.getId()) == null){
            return ResponseEntity.status(500).build();
        }

        clientesService.eliminarClientes(clientes);
        return ResponseEntity.status(200).build();

    }

    // M - C

}
