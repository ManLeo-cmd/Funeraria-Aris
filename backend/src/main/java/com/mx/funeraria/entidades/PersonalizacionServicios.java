package com.mx.funeraria.entidades;

import jakarta.persistence.*;

@Entity
public class PersonalizacionServicios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_personalizacion;

    private String musica;

    private String flores;

    private String ataud;

    private String carroza;

    private String equipoPanteon;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;

    public int getId_personalizacion() {
        return id_personalizacion;
    }

    public void setId_personalizacion(int id_personalizacion) {
        this.id_personalizacion = id_personalizacion;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getFlores() {
        return flores;
    }

    public void setFlores(String flores) {
        this.flores = flores;
    }

    public String getAtaud() {
        return ataud;
    }

    public void setAtaud(String ataud) {
        this.ataud = ataud;
    }

    public String getCarroza() {
        return carroza;
    }

    public void setCarroza(String carroza) {
        this.carroza = carroza;
    }

    public String getEquipoPanteon() {
        return equipoPanteon;
    }

    public void setEquipoPanteon(String equipoPanteon) {
        this.equipoPanteon = equipoPanteon;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
}
