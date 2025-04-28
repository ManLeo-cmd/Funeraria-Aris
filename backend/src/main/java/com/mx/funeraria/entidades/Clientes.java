package com.mx.funeraria.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre; //

    private long telefono;

    private String email; //

    private String contrasena; //

    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<PersonalizacionServicios> productos;

    @OneToMany(mappedBy = "cliente")
    private List<PlanesFuturos> planes;

    @OneToMany(mappedBy = "cliente")
    private List<Facturacion> facturacion;

    @OneToMany(mappedBy = "cliente")
    private List<Recordatorios> recordatorios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<PersonalizacionServicios> getProductos() {
        return productos;
    }

    public void setProductos(List<PersonalizacionServicios> productos) {
        this.productos = productos;
    }

    public List<PlanesFuturos> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlanesFuturos> planes) {
        this.planes = planes;
    }

    public List<Facturacion> getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(List<Facturacion> facturacion) {
        this.facturacion = facturacion;
    }

    public List<Recordatorios> getRecordatorios() {
        return recordatorios;
    }

    public void setRecordatorios(List<Recordatorios> recordatorios) {
        this.recordatorios = recordatorios;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion='" + direccion + '\'' +
                ", productos=" + productos +
                ", planes=" + planes +
                ", facturacion=" + facturacion +
                ", recordatorios=" + recordatorios +
                '}';
    }
}
