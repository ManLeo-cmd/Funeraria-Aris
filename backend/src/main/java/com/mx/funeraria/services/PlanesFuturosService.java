package com.mx.funeraria.services;

import com.mx.funeraria.dao.ClientesDAO;
import com.mx.funeraria.dao.PlanesFuturosDAO;
import com.mx.funeraria.entidades.Clientes;
import com.mx.funeraria.entidades.PlanesFuturos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanesFuturosService {

    @Autowired
    private PlanesFuturosDAO planesFuturosDAO;

    @Autowired
    private ClientesDAO clientesDAO;

    public List<PlanesFuturos> listarPlanes(){
        return planesFuturosDAO.findAll();
    }

    public PlanesFuturos buscarPlanesFuturos(String id){
        return planesFuturosDAO.findById(id).orElse(null);
    }

    public void guardarPlanesFuturos(PlanesFuturos planesFuturos){
        planesFuturosDAO.save(planesFuturos);
    }

    public void eliminarPlanesFuturos(PlanesFuturos planesFuturos){
        planesFuturosDAO.delete(planesFuturos);
    }

    public List<PlanesFuturos> findByCliente(String idCliente){
        Clientes aux = clientesDAO.findById(idCliente).orElse(null);
        return planesFuturosDAO.findByCliente(aux);
    }

}
