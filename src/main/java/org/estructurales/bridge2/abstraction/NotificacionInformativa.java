package org.estructurales.bridge2.abstraction;

import org.estructurales.bridge2.implementor.NotificacionSender;

public class NotificacionInformativa extends Notificacion {
    private String asunto;
    private String detalle;
    private String categoria;

    public NotificacionInformativa(NotificacionSender sender, String destinatario,
                                   String asunto, String detalle, String categoria) {
        super(sender, destinatario);
        this.asunto = asunto;
        this.detalle = detalle;
        this.categoria = categoria;
    }

    @Override
    protected void enviarImplementacion() {
        String titulo = "Información [" + categoria + "]: " + asunto;
        String mensaje = detalle;

        sender.enviar(titulo, mensaje, destinatario, metadatos);
    }
}

