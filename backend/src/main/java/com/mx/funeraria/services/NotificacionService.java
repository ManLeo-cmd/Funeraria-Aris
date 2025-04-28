package com.mx.funeraria.services;

import com.mx.funeraria.entidades.PlanesFuturos;
import org.springframework.stereotype.Service;

@Service
public class NotificacionService {

    public void enviarNotificacion(PlanesFuturos plan) {
        System.out.println("🔔 Notificación: Tienes un plan pendiente → " + plan.getNombre());
    }
}
