package com.mx.funeraria.controller;

import com.mx.funeraria.dao.PlanesFuturosDAO;
import com.mx.funeraria.entidades.PagoPlanes;
import com.mx.funeraria.entidades.PlanesFuturos;
import com.mx.funeraria.entidades.Recordatorios;
import com.mx.funeraria.services.NotificacionService;
import com.mx.funeraria.services.PagoPlanesService;
import com.mx.funeraria.services.RecordatoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Component
public class RecordatorioScheduler {

    @Autowired
    private PlanesFuturosDAO planesFuturosDAO;

    @Autowired
    private PagoPlanesService service;

    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private RecordatoriosService recordatoriosService;

    @Scheduled(cron = "0 * * * * *")
    public void enviarRecordatoriosDiarios(){
        List<PlanesFuturos> planesFuturos = planesFuturosDAO.findAll();

        System.out.println("🔔 Ejecutando recordatorio a las: " + LocalTime.now());
        for (var plan : planesFuturos){
            List<PagoPlanes> pagos = service.listarFacturas(plan);
            for (var pags : pagos){
                LocalDate date = pags.getFechaPago().toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate();
                LocalDate hoy = LocalDate.now();
                if(!pags.isPagado() & hoy.plusDays(30).isEqual(date)){
                    Recordatorios recordatorio = new Recordatorios();
                    recordatorio.setFechaEnvio(new Date());
                    recordatorio.setEstadoEnvio("ENVIADO");
                    recordatorio.setPlanes(plan);
                    recordatorio.setCliente(plan.getCliente());
                    recordatoriosService.guardarRecordatorios(recordatorio);
                    notificacionService.enviarNotificacion(plan);
                }
            }



        }
    }
}
