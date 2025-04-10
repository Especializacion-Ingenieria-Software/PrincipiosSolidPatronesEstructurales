package org.estructurales.bridge.implementor;

public class AireAcondicionadoLG implements DispositivoElectronico {
    private boolean encendido = false;
    private int temperatura = 16;
    private int modo = 1;


    @Override
    public void encender() {
        encendido = true;
        System.out.println("Aire LG encendido: Iniciando sistema de enfriamiento");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("Aire LG: Sistema de enfriamiento apagado");
    }

    @Override
    public void setVolumen(int nivel) {
        this.temperatura = nivel;
        System.out.println("Aire LG: Temperatura ajustada a " + nivel + "°C");

    }

    @Override
    public void setCanal(int canal) {
        // Reinterpretamos canal como modo
        if (encendido && canal >= 1 && canal <= 3) {
            this.modo = canal;
            String[] modos = {"", "frío", "calor", "ventilador"};
            System.out.println("Aire LG: Modo cambiado a " + modos[canal]);
        }
    }

    @Override
    public boolean estaEncendido() {
        return encendido;
    }
}
