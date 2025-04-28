package com.mx.funeraria.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Recordatorios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_recordatorio;

    private Date fechaEnvio;

    private String estadoEnvio;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private PlanesFuturos planes;

    public int getId_recordatorio() {
        return id_recordatorio;
    }

    public void setId_recordatorio(int id_recordatorio) {
        this.id_recordatorio = id_recordatorio;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(String estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public PlanesFuturos getPlanes() {
        return planes;
    }

    public void setPlanes(PlanesFuturos planes) {
        this.planes = planes;
    }
}
