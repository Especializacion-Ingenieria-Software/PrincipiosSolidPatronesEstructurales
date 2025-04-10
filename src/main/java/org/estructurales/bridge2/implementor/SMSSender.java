package org.estructurales.bridge2.implementor;

import java.util.Map;

public class SMSSender implements NotificacionSender {
    @Override
    public void enviar(String titulo, String mensaje, String destinatario, Map<String, Object> metadatos) {
        System.out.println("\n[SMS] Para: " + destinatario);
        System.out.println("Mensaje: " + titulo + " - " + mensaje);

        if (metadatos != null && metadatos.containsKey("prioritario")) {
            boolean prioritario = (Boolean) metadatos.get("prioritario");
            if (prioritario) {
                System.out.println("Mensaje PRIORITARIO");
            }
        }
    }

    @Override
    public String getNombreCanal() {
        return "SMS";
    }
}
