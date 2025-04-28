package com.mx.funeraria.dao;

import com.mx.funeraria.entidades.PagoPlanes;
import com.mx.funeraria.entidades.PlanesFuturos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoPlanesDAO extends JpaRepository<PagoPlanes, String> {

    List<PagoPlanes> findByPlanes(PlanesFuturos planesFuturos);

}