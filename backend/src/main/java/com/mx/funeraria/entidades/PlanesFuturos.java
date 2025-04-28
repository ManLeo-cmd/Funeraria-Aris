package com.mx.funeraria.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlanesFuturos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_plan;

    private String nombre;

    private double costo;

    private int mensualidades;

    private double saldoRestante;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    @OneToMany(mappedBy = "planes")
    private List<Recordatorios> recordatorios;

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getMensualidades() {
        return mensualidades;
    }

    public void setMensualidades(int mensualidades) {
        this.mensualidades = mensualidades;
    }

    public double getSaldoRestante() {
        return saldoRestante;
    }

    public void setSaldoRestante(double saldoRestante) {
        this.saldoRestante = saldoRestante;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}
