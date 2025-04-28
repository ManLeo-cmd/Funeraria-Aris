package com.mx.funeraria.dao;

import com.mx.funeraria.entidades.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientesDAO extends JpaRepository<Clientes, String> {

    Optional<Clientes> findByEmail(String email);





}
