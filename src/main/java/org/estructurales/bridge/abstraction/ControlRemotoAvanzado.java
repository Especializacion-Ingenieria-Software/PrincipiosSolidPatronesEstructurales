package org.estructurales.bridge.abstraction;

import org.estructurales.bridge.implementor.DispositivoElectronico;

public class ControlRemotoAvanzado extends ControlRemoto {

    private int nivelVolumen = 30;
    private int ultimoCanal = 1;

    public ControlRemotoAvanzado(DispositivoElectronico dispositivo) {
        super(dispositivo);
        if(dispositivo.estaEncendido()){
            dispositivo.setVolumen(nivelVolumen);
        }
    }

    @Override
    public void subirVolumen() {
        nivelVolumen = Math.min(100, nivelVolumen + 5);  // Control más fino
        dispositivo.setVolumen(nivelVolumen);
        System.out.println("Control Avanzado: Volumen ajustado a " + nivelVolumen);
    }

    @Override
    public void bajarVolumen() {
        nivelVolumen = Math.max(0, nivelVolumen - 5);  // Control más fino
        dispositivo.setVolumen(nivelVolumen);
        System.out.println("Control Avanzado: Volumen ajustado a " + nivelVolumen);
    }

    // Funcionalidad adicional que solo tiene el control avanzado
    public void silenciar() {
        dispositivo.setVolumen(0);
        System.out.println("Control Avanzado: Modo silencioso activado");
    }

    public void irACanal(int favorito) {
        System.out.println("Control Avanzado: Yendo a canal favorito #" + favorito);
        dispositivo.setCanal(favorito * 10); // Simulando canales favoritos
    }
}
