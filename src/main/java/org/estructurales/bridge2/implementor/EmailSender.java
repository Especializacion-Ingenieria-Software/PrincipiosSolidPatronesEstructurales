package org.estructurales.bridge2.implementor;


import java.util.List;
import java.util.Map;

public class EmailSender implements NotificacionSender {
    @Override
    public void enviar(String titulo, String mensaje, String destinatario, Map<String, Object> metadatos) {
        System.out.println("\n[EMAIL] Para: " + destinatario);
        System.out.println("Asunto: " + titulo);
        System.out.println("Mensaje: " + mensaje);

        if (metadatos != null && metadatos.containsKey("adjuntos")) {

            List<String> adjuntos = (List<String>) metadatos.get("adjuntos");
            System.out.println("Adjuntos: " + adjuntos);
        }
    }

    @Override
    public String getNombreCanal() {
        return "Email";
    }
}