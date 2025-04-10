package org.estructurales.bridge.implementor;

public class TVSamsung implements DispositivoElectronico{
    private boolean encendido = false;
    private int volumen = 0;
    private int canal = 1;


    @Override
    public void encender() {
        encendido = true;
        System.out.println("TV Samsung encendido");
    }

    @Override
    public void apagar() {
        encendido = false;
        System.out.println("TV Samsung apagado");
    }

    @Override
    public void setVolumen(int nivel) {
        if(encendido && nivel >= 0 && nivel <=100) {
            this.volumen = nivel;
            System.out.println("TV Samsung volumen: " + nivel);
        }
    }

    @Override
    public void setCanal(int canal) {
        if(encendido && canal >0){
            this.canal = canal;
            System.out.println("TV Samsung canal: Canal se cambia a  " + canal);
        }
    }

    @Override
    public boolean estaEncendido() {
        return encendido;
    }
}
