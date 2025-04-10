package org.estructurales.bridge2.abstraction;

import org.estructurales.bridge2.implementor.EmailSender;
import org.estructurales.bridge2.implementor.NotificacionSender;
import org.estructurales.bridge2.implementor.PushSender;
import org.estructurales.bridge2.implementor.SlackSender;

import java.util.ArrayList;
import java.util.List;

public class NotificacionPromocional extends Notificacion {
    private String producto;
    private String oferta;
    private String validoHasta;

    public NotificacionPromocional(NotificacionSender sender, String destinatario,
                                   String producto, String oferta, String validoHasta) {
        super(sender, destinatario);
        this.producto = producto;
        this.oferta = oferta;
        this.validoHasta = validoHasta;
    }

    @Override
    protected void enviarImplementacion() {
        String titulo = "Oferta especial: " + oferta + " en " + producto;
        String mensaje = "Aprovecha esta oferta:" +
                "\n• Producto: " + producto +
                "\n• Oferta: " + oferta +
                "\n• Válido hasta: " + validoHasta;

        // Personalizamos según el canal
        if (sender instanceof EmailSender) {
            List<String> adjuntos = new ArrayList<>();
            adjuntos.add("catalogo_ofertas.pdf");
            agregarMetadato("adjuntos", adjuntos);
        } else if (sender instanceof PushSender) {
            agregarMetadato("accion", "abrir_oferta");
        } else if (sender instanceof SlackSender) {
            List<String> botones = new ArrayList<>();
            botones.add("Ver oferta");
            agregarMetadato("botones", botones);
        }

        sender.enviar(titulo, mensaje, destinatario, metadatos);
    }
}