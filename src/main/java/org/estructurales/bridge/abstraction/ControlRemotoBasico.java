package org.estructurales.bridge.abstraction;

import org.estructurales.bridge.implementor.DispositivoElectronico;

public class ControlRemotoBasico extends ControlRemoto{

    private int nivelVolumen = 50;

    public ControlRemotoBasico(DispositivoElectronico dispositivo){
        super(dispositivo);
        if(dispositivo.estaEncendido()){
            dispositivo.setVolumen(nivelVolumen);
        }
    }

    @Override
    public void subirVolumen(){
        nivelVolumen = Math.min(100, nivelVolumen + 10);
        dispositivo.setVolumen(nivelVolumen);
        System.out.println("Control Básico: Subiendo volumen a " + nivelVolumen);
    }

    @Override
    public void bajarVolumen() {
        nivelVolumen = Math.max(0, nivelVolumen - 10);
        dispositivo.setVolumen(nivelVolumen);
        System.out.println("Control Básico: Bajando volumen a " + nivelVolumen);
    }
}
