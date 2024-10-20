package org.deneb.tp5.ejercicio5;

import java.util.Random;

public class Cliente extends Thread{
    private int id;
    private Heladeria heladeria;

    public Cliente(int id, Heladeria heladeria){
        this.id = id;
        this.heladeria = heladeria;
    }

    public int getID(){
        return id;
    }

    @Override
    public void run(){
        int tiempoLlegada = new Random().nextInt(3)+ 1;
        try {
            Thread.sleep(tiempoLlegada *1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        heladeria.atenderEnCaja(this);
        heladeria.atenderEnPublico(this);
    }
}
