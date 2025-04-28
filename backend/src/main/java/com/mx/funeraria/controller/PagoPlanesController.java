package com.mx.funeraria.controller;

import com.mx.funeraria.entidades.Facturacion;
import com.mx.funeraria.entidades.PagoPlanes;
import com.mx.funeraria.entidades.PlanesFuturos;
import com.mx.funeraria.services.PagoPlanesService;
import com.mx.funeraria.services.PlanesFuturosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("pagos")
public class PagoPlanesController {

    @Autowired
    private PagoPlanesService service;

    @Autowired
    private PlanesFuturosService service2;

    @GetMapping("/buscar/planes/{id}")
    public ResponseEntity<?> findAll(@PathVariable int id){
        PlanesFuturos aux = service2.buscarPlanesFuturos(String.valueOf(id));
        return ResponseEntity.status(200).body(service.listarFacturas(aux));
    }

    @GetMapping("/nopagado/{id}")
    public ResponseEntity<?> buscarPorFechaYNoPagado(@PathVariable int id){
        PlanesFuturos aux = service2.buscarPlanesFuturos(String.valueOf(id));
        List<PagoPlanes> au = service.listarFacturas(aux);
        for (PagoPlanes x : au){
            if (!x.isPagado()) {
                return ResponseEntity.status(200).body(x);
            }


        }
        return ResponseEntity.status(500).build();

    }


    @GetMapping("/listar")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.status(200).body(service.listar());
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> save(@RequestBody PagoPlanes pagoPlanes){
        service.guardarFactura(pagoPlanes);
        return ResponseEntity.status(200).build();
    }

}
