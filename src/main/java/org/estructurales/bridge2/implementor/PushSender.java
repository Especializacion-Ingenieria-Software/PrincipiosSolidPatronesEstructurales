package org.estructurales.bridge2.implementor;

import java.util.Map;

public class PushSender implements NotificacionSender {
    @Override
    public void enviar(String titulo, String mensaje, String destinatario, Map<String, Object> metadatos) {
        System.out.println("\n[PUSH] Dispositivo: " + destinatario);
        System.out.println("Título: " + titulo);
        System.out.println("Mensaje: " + mensaje);

        if (metadatos != null) {
            if (metadatos.containsKey("accion")) {
                System.out.println("Acción: " + metadatos.get("accion"));
            }
            if (metadatos.containsKey("sonido")) {
                System.out.println("Sonido: " + metadatos.get("sonido"));
            }
        }
    }

    @Override
    public String getNombreCanal() {
        return "Push";
    }
}

