package com.mx.funeraria.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class ServicioInmediato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int servicioInmediatoId;

    private String nombre;

    private int edad;

    private Date fechaDefuncion;

    private String causaMuerte;

    private String tipoServicio;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Clientes cliente;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificado_Defuncion", referencedColumnName = "id_factura")
    private Facturacion factura;


    public int getServicioInmediatoId() {
        return servicioInmediatoId;
    }

    public void setServicioInmediatoId(int servicioInmediatoId) {
        this.servicioInmediatoId = servicioInmediatoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(Date fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public String getCausaMuerte() {
        return causaMuerte;
    }

    public void setCausaMuerte(String causaMuerte) {
        this.causaMuerte = causaMuerte;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Facturacion getFactura() {
        return factura;
    }

    public void setFactura(Facturacion factura) {
        this.factura = factura;
    }
}


