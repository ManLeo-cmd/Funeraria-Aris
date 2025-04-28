package com.mx.funeraria.controller;

import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class LoginController {

    @Autowired
    private ClientesService clientesService;



}
