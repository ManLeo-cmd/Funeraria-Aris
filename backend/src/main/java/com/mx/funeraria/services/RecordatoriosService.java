package com.mx.funeraria.services;

import com.mx.funeraria.dao.FacturacionDAO;
import com.mx.funeraria.dao.RecordatoriosDAO;
import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.entidades.Facturacion;
import com.mx.funeraria.entidades.PlanesFuturos;
import com.mx.funeraria.entidades.Recordatorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordatoriosService {

    @Autowired
    private RecordatoriosDAO recordatoriosDAO;

    public List<Recordatorios> listarRecordatorios(){
        return recordatoriosDAO.findAll();
    }

    public Recordatorios buscarRecordatorios(int id){
        return recordatoriosDAO.findById(String.valueOf(id)).orElse(null);
    }

    public void guardarRecordatorios(Recordatorios recordatorios){
        recordatoriosDAO.save(recordatorios);
    }

    public void eliminarRecordatorios(Recordatorios recordatorios){
        recordatoriosDAO.delete(recordatorios);
    }

    public List<Recordatorios> buscarPorCliente(Clientes clientes){
        return recordatoriosDAO.findByCliente(clientes);
    }

    public List<Recordatorios> buscarPorPlan(PlanesFuturos planesFuturos){
        return recordatoriosDAO.findByPlanes(planesFuturos);
    }
}
