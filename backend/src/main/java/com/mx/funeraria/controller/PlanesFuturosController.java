package com.mx.funeraria.controller;

import com.mx.funeraria.entidades.PagoPlanes;
import com.mx.funeraria.entidades.PlanesFuturos;
import com.mx.funeraria.entidades.Recordatorios;
import com.mx.funeraria.entidades.ServicioInmediato;
import com.mx.funeraria.services.PagoPlanesService;
import com.mx.funeraria.services.PlanesFuturosService;
import com.mx.funeraria.services.RecordatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("planes")
public class PlanesFuturosController {

    @Autowired
    private PlanesFuturosService service;

    @Autowired
    private PagoPlanesService service2;

    @Autowired
    private RecordatoriosService service3;

    @GetMapping("/listar")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(200).body(service.listarPlanes());
    }

    @GetMapping("/buscar/cliente/{id}")
    public ResponseEntity<?> findByCliente(@PathVariable int id){
        return ResponseEntity.status(200).body(service.findByCliente(String.valueOf(id)));
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody PlanesFuturos planesFuturos){
        service.guardarPlanesFuturos(planesFuturos);
        LocalDate hoy = LocalDate.now();
        for (int i = 1; i <= planesFuturos.getMensualidades(); i++) {
            PagoPlanes planes = new PagoPlanes();
            Period period = Period.ofMonths(i);
            planes.setNoPago(i);
            planes.setPagado(false);
            planes.setMonto(planesFuturos.getCosto() / planesFuturos.getMensualidades());
            planes.setFechaPago(Date.from(hoy.plus(period).atStartOfDay(ZoneId.systemDefault()).toInstant()));
            planes.setPlanes(planesFuturos);
            service2.guardarFactura(planes);
        }

        return ResponseEntity.status(200).build();
    }

    @PostMapping("/editar")
    public ResponseEntity<?> update(@RequestBody PlanesFuturos planesFuturos){
        service.guardarPlanesFuturos(planesFuturos);
        return ResponseEntity.status(200).build();
    }

    @PostMapping("/eliminar")
    public ResponseEntity<?> delete(@RequestBody PlanesFuturos planesFuturos){
        List<PagoPlanes> planes = service2.listarFacturas(planesFuturos);
        List<Recordatorios> recs = service3.buscarPorPlan(planesFuturos);
        for (PagoPlanes planes1 : planes){
            service2.eliminarFactura(planes1);
        }
        for (Recordatorios recs2 : recs){
            service3.eliminarRecordatorios(recs2);
        }
        service.eliminarPlanesFuturos(planesFuturos);
        return ResponseEntity.status(200).build();
    }
}
