package org.estructurales.bridge.abstraction;

import org.estructurales.bridge.implementor.DispositivoElectronico;

public abstract class ControlRemoto {
    protected DispositivoElectronico dispositivo;

    public ControlRemoto(DispositivoElectronico dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void encenderApagar(){
        if(dispositivo.estaEncendido()){
            dispositivo.apagar();
        }
        else{
            dispositivo.encender();
        }
    }

    public void subirVolumen(){

        //Implementación que va a depender del tipo de control

    }

    public void bajarVolumen(){
        //Implementación que va a depender del tipo de control

    }

    public void cambiarCanal(int canal){
        dispositivo.setCanal(canal);
    }
}
