package com.mx.funeraria.services;

import com.mx.funeraria.dao.PlanesFuturosDAO;
import com.mx.funeraria.entidades.PlanesFuturos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanesFuturosService {

    @Autowired
    private PlanesFuturosDAO planesFuturosDAO;

    public List<PlanesFuturos> listarPlanes(){
        return planesFuturosDAO.findAll();
    }

    public PlanesFuturos buscarPlanesFuturos(int id){
        return planesFuturosDAO.findById(String.valueOf(id)).orElse(null);
    }

    public void guardarPlanesFuturos(PlanesFuturos planesFuturos){
        planesFuturosDAO.save(planesFuturos);
    }

    public void eliminarPlanesFuturos(PlanesFuturos planesFuturos){
        planesFuturosDAO.delete(planesFuturos);
    }


}
