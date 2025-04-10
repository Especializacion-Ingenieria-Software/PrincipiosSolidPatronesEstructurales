package org.estructurales.bridge2.implementor;

import java.util.Map;

public interface NotificacionSender {
    void enviar(String titulo, String mensaje, String destinatario, Map<String, Object> metadatos);
    String getNombreCanal();
}
