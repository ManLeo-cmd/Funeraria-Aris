package com.mx.funeraria.dao;

import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.entidades.PlanesFuturos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;

import java.util.List;

public interface PlanesFuturosDAO extends JpaRepository<PlanesFuturos, String> {

    List<PlanesFuturos> findByCliente(Clientes clientes);


}
