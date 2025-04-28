package com.mx.funeraria.entidades;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class PagoPlanes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int noPago;

    private Date fechaPago;

    private double monto;

    private boolean pagado;


    @ManyToOne
    @JoinColumn(name = "id_pago")
    private PlanesFuturos planes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public PlanesFuturos getPlanes() {
        return planes;
    }

    public void setPlanes(PlanesFuturos planes) {
        this.planes = planes;
    }

    public int getNoPago() {
        return noPago;
    }

    public void setNoPago(int noPago) {
        this.noPago = noPago;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "PagoPlanes{" +
                "id=" + id +
                ", fechaPago=" + fechaPago +
                ", monto=" + monto +
                ", planes=" + planes +
                '}';
    }
}
