package com.mx.funeraria.dao;

import com.mx.funeraria.entidades.Facturacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturacionDAO extends JpaRepository<Facturacion, String> {
}
