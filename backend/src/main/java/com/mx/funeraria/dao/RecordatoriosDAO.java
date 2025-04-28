package com.mx.funeraria.dao;

import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.entidades.PlanesFuturos;
import com.mx.funeraria.entidades.Recordatorios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordatoriosDAO extends JpaRepository<Recordatorios, String> {

    List<Recordatorios> findByCliente(Clientes cliente);

    List<Recordatorios> findByPlanes(PlanesFuturos planesFuturos);
}
