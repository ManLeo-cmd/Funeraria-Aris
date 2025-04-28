package com.mx.funeraria.services;

import com.mx.funeraria.dao.ClientesDAO;
import com.mx.funeraria.entidades.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesService {

    @Autowired
    private ClientesDAO clientesDAO;

    public List<Clientes> listarClientes(){
        return clientesDAO.findAll();
    }

    public Clientes buscarCliente(int id){
        return clientesDAO.findById(String.valueOf(id)).orElse(null);
    }

    public void guardarCliente(Clientes clientes){
        clientesDAO.save(clientes);
    }

    public void eliminarClientes(Clientes clientes){
        clientesDAO.delete(clientes);
    }

    public Clientes buscarClientePorEmail(String email){
        return clientesDAO.findByEmail(email).orElse(null);
    }





}
