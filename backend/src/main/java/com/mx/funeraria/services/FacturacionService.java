package com.mx.funeraria.services;

import com.mx.funeraria.dao.FacturacionDAO;
import com.mx.funeraria.entidades.Facturacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturacionService {

    @Autowired
    private FacturacionDAO facturacionDAO;

    public List<Facturacion> listarFacturas(){
        return facturacionDAO.findAll();
    }

    public Facturacion buscarFacturas(int id){
        return facturacionDAO.findById(String.valueOf(id)).orElse(null);
    }

    public void guardarFactura(Facturacion facturacion){
        facturacionDAO.save(facturacion);
    }

    public void eliminarFactura(Facturacion facturacion){
        facturacionDAO.delete(facturacion);
    }

}
