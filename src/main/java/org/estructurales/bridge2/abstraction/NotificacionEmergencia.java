package org.estructurales.bridge2.abstraction;

import org.estructurales.bridge2.implementor.NotificacionSender;

public class NotificacionEmergencia extends Notificacion {
    private String alerta;
    private int nivelSeveridad; // 1-5

    public NotificacionEmergencia(NotificacionSender sender, String destinatario,
                                  String alerta, int nivelSeveridad) {
        super(sender, destinatario);
        this.alerta = alerta;
        this.nivelSeveridad = nivelSeveridad;
        agregarMetadato("prioritario", true);
    }

    @Override
    protected void enviarImplementacion() {
        String titulo = "ALERTA DE EMERGENCIA (Nivel: " + nivelSeveridad + ")";
        String mensaje = "Emergencia: " + alerta +
                "\nRequiere atención inmediata.";

        sender.enviar(titulo, mensaje, destinatario, metadatos);
    }
}
