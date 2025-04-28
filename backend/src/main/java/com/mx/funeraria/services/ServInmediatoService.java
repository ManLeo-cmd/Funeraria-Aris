package com.mx.funeraria.services;

import com.mx.funeraria.dao.ServicioInmediatoDAO;
import com.mx.funeraria.entidades.ServicioInmediato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServInmediatoService {

    @Autowired
    private ServicioInmediatoDAO servicioInmediatoDAO;

    public List<ServicioInmediato> findAll(){
        return servicioInmediatoDAO.findAll();
    }

    public void guardar(ServicioInmediato servicioInmediato){
        servicioInmediatoDAO.save(servicioInmediato);
    }

    public void eliminar(ServicioInmediato servicioInmediato){
        servicioInmediatoDAO.delete(servicioInmediato);
    }

}
