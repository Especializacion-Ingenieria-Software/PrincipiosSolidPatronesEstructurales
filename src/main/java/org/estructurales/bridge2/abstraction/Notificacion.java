package org.estructurales.bridge2.abstraction;

import org.estructurales.bridge2.implementor.NotificacionSender;

import java.util.HashMap;
import java.util.Map;

public abstract class Notificacion {
    protected NotificacionSender sender;
    protected String destinatario;
    protected Map<String, Object> metadatos;

    public Notificacion(NotificacionSender sender, String destinatario) {
        this.sender = sender;
        this.destinatario = destinatario;
        this.metadatos = new HashMap<>();
    }

    public void agregarMetadato(String clave, Object valor) {
        metadatos.put(clave, valor);
    }

    public void enviar() {
        System.out.println("\n>> NOTIFICACIÓN: " + getClass().getSimpleName() + " <<");
        System.out.println("Canal: " + sender.getNombreCanal());
        enviarImplementacion();
    }

    protected abstract void enviarImplementacion();

    public void cambiarSender(NotificacionSender nuevoSender) {
        System.out.println("\nCambiando canal de " + sender.getNombreCanal() + " a " + nuevoSender.getNombreCanal());
        this.sender = nuevoSender;
    }
}

