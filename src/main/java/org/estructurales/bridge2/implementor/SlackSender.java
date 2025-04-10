package org.estructurales.bridge2.implementor;

import java.util.List;
import java.util.Map;

public class SlackSender implements NotificacionSender {
    @Override
    public void enviar(String titulo, String mensaje, String destinatario, Map<String, Object> metadatos) {
        System.out.println("\n[SLACK] Canal: " + destinatario);
        System.out.println("*" + titulo + "*");
        System.out.println(mensaje);

        if (metadatos != null && metadatos.containsKey("botones")) {
            @SuppressWarnings("unchecked")
            List<String> botones = (List<String>) metadatos.get("botones");
            System.out.println("Botones: " + botones);
        }
    }

    @Override
    public String getNombreCanal() {
        return "Slack";
    }
}