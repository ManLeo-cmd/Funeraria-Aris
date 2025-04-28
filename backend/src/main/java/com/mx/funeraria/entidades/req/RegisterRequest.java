package com.mx.funeraria.entidades.req;

public record RegisterRequest (
        String email,
        String password,
        String name,
        long telefono,
        String direccion
){}