package com.mx.funeraria.services;

import com.mx.funeraria.dao.FacturacionDAO;
import com.mx.funeraria.dao.PagoPlanesDAO;
import com.mx.funeraria.entidades.Facturacion;
import com.mx.funeraria.entidades.PagoPlanes;
import com.mx.funeraria.entidades.PlanesFuturos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoPlanesService {

    @Autowired
    private PagoPlanesDAO pagoPlanesDAO;

    public List<PagoPlanes> listarFacturas(PlanesFuturos planesFuturos){
        return pagoPlanesDAO.findByPlanes(planesFuturos);
    }

    public List<PagoPlanes> listar(){
        return pagoPlanesDAO.findAll();
    }


    public PagoPlanes buscarFacturas(int id){
        return pagoPlanesDAO.findById(String.valueOf(id)).orElse(null);
    }

    public void guardarFactura(PagoPlanes pagoPlanes){
        pagoPlanesDAO.save(pagoPlanes);
    }

    public void eliminarFactura(PagoPlanes pagoPlanes){
        pagoPlanesDAO.delete(pagoPlanes);
    }


}
