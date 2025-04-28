package com.mx.funeraria.services;

import com.mx.funeraria.dao.PersonalizacionServiciosDAO;
import com.mx.funeraria.entidades.PersonalizacionServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalizacionServService {

    @Autowired
    private PersonalizacionServiciosDAO personalizacionDAO;

    public List<PersonalizacionServicios> listarPersonalizacionServicios(){
        return personalizacionDAO.findAll();
    }

    public PersonalizacionServicios buscarPersonalizacionServicios(int id){
        return personalizacionDAO.findById(String.valueOf(id)).orElse(null);
    }

    public void guardarPersonalizacionServicios(PersonalizacionServicios clientes){
        System.out.println(clientes);
        personalizacionDAO.save(clientes);
    }

    public void eliminarPersonalizacionServicios(PersonalizacionServicios clientes){
        personalizacionDAO.delete(clientes);
    }

}
