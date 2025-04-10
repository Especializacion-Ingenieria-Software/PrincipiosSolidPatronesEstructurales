package org.estructurales.bridge2;

import org.estructurales.bridge2.abstraction.NotificacionEmergencia;
import org.estructurales.bridge2.abstraction.NotificacionInformativa;
import org.estructurales.bridge2.abstraction.NotificacionPromocional;
import org.estructurales.bridge2.abstraction.NotificacionRecordatorio;
import org.estructurales.bridge2.implementor.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creamos diferentes implementadores (canales de envío)
        NotificacionSender emailSender = new EmailSender();
        NotificacionSender smsSender = new SMSSender();
        NotificacionSender pushSender = new PushSender();
        NotificacionSender slackSender = new SlackSender();

        // Creamos diferentes notificaciones usando diferentes canales
        NotificacionEmergencia emergencia = new NotificacionEmergencia(
                emailSender, "equipo@empresa.com", "Falla en el servidor principal", 5);

        NotificacionRecordatorio recordatorio = new NotificacionRecordatorio(
                smsSender, "+34123456789", "Reunión con el cliente", "Mañana 10:00 AM");

        NotificacionInformativa informativa = new NotificacionInformativa(
                pushSender, "dispositivo-123", "Nueva actualización",
                "Versión 2.0 disponible con nuevas funciones", "Sistema");

        NotificacionPromocional promocion = new NotificacionPromocional(
                slackSender, "#canal-marketing", "Curso Premium", "50% de descuento", "31/05/2025");

        // Agregamos metadatos adicionales
        List<String> adjuntos = new ArrayList<>();
        adjuntos.add("logs_servidor.txt");
        emergencia.agregarMetadato("adjuntos", adjuntos);

        List<String> botones = new ArrayList<>();
        botones.add("Reiniciar Servidor");
        botones.add("Escalar Incidente");
        emergencia.agregarMetadato("botones", botones);

        // Enviamos las notificaciones
        System.out.println("===== SISTEMA DE NOTIFICACIONES DEMOSTRACIÓN =====");
        emergencia.enviar();
        recordatorio.enviar();
        informativa.enviar();
        promocion.enviar();

        // Demostración de cambio de canal en tiempo de ejecución
        System.out.println("\n===== DEMOSTRACIÓN DE CAMBIO DE CANAL =====");

        // La misma notificación de emergencia ahora se envía por SMS
        emergencia.cambiarSender(smsSender);
        emergencia.enviar();

        // La promoción ahora se envía como email
        promocion.cambiarSender(emailSender);
        promocion.enviar();
    }
}