package org.estructurales.bridge;


import org.estructurales.bridge.abstraction.ControlRemoto;
import org.estructurales.bridge.abstraction.ControlRemotoAvanzado;
import org.estructurales.bridge.abstraction.ControlRemotoBasico;
import org.estructurales.bridge.implementor.AireAcondicionadoLG;
import org.estructurales.bridge.implementor.DispositivoElectronico;
import org.estructurales.bridge.implementor.TVSamsung;
import org.estructurales.bridge.implementor.TVSony;

public class Main {
    public static void main(String[] args) {
        // Creamos diferentes dispositivos
        DispositivoElectronico tvSamsung = new TVSamsung();
        DispositivoElectronico tvSony = new TVSony();
        DispositivoElectronico aireLG = new AireAcondicionadoLG();


        // Creamos diferentes controles para diferentes dispositivos
        ControlRemoto controlBasicoSamsung = new ControlRemotoBasico(tvSamsung);
        ControlRemoto controlAvanzadoSony = new ControlRemotoAvanzado(tvSony);
        ControlRemoto controlAvanzadoAire = new ControlRemotoAvanzado(aireLG);

        // Demostración de uso
        System.out.println("==== Demostración del Control Samsung Básico ====");
        controlBasicoSamsung.encenderApagar(); // Enciende TV Samsung
        controlBasicoSamsung.subirVolumen();   // Sube volumen a 60
        controlBasicoSamsung.cambiarCanal(5);  // Cambia al canal 5

        System.out.println("\n==== Demostración del Control Sony Avanzado ====");
        controlAvanzadoSony.encenderApagar();  // Enciende TV Sony
        controlAvanzadoSony.subirVolumen();    // Sube volumen a 35

        // Usando funciones del control avanzado (necesitamos hacer cast)
        if (controlAvanzadoSony instanceof ControlRemotoAvanzado) {
            ControlRemotoAvanzado avanzado = (ControlRemotoAvanzado) controlAvanzadoSony;
            avanzado.irACanal(2);  // Va al canal favorito #2 (canal 20)
            avanzado.silenciar();   // Activa modo silencioso
        }

        System.out.println("\n==== Demostración del Control Aire Acondicionado ====");
        controlAvanzadoAire.encenderApagar();  // Enciende el aire
        // Ajustamos "volumen" que en realidad es temperatura para el aire
        controlAvanzadoAire.subirVolumen();    // 30 + 5 = 35 limitado a 30°C
        // El "canal" es el modo de operación para el aire
        controlAvanzadoAire.cambiarCanal(2);   // Modo calor


    }
}