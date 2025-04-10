package org.estructurales.bridge.implementor;

public interface DispositivoElectronico {
    void encender();
    void apagar();
    void setVolumen(int nivel);
    void setCanal(int canal);
    boolean estaEncendido();
}
