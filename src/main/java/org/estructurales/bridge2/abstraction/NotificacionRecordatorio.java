package org.estructurales.bridge2.abstraction;

import org.estructurales.bridge2.implementor.NotificacionSender;
import org.estructurales.bridge2.implementor.PushSender;

public class NotificacionRecordatorio extends Notificacion {
    private String evento;
    private String fecha;

    public NotificacionRecordatorio(NotificacionSender sender, String destinatario,
                                    String evento, String fecha) {
        super(sender, destinatario);
        this.evento = evento;
        this.fecha = fecha;
    }

    @Override
    protected void enviarImplementacion() {
        String titulo = "Recordatorio: " + evento;
        String mensaje = "No olvide: " + evento +
                "\nFecha: " + fecha;

        // Agregamos metadata específica si es una notificación push
        if (sender instanceof PushSender) {
            agregarMetadato("accion", "abrir_calendario");
            agregarMetadato("sonido", "calendar_alert.mp3");
        }

        sender.enviar(titulo, mensaje, destinatario, metadatos);
    }
}