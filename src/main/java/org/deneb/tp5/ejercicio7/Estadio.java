package org.deneb.tp5.ejercicio7;

import java.util.concurrent.TimeUnit;

public class Estadio {
    private int asientosLocales = 30;
    private int asientosVisitantes = 30;

    public synchronized boolean comprarEntradaLocal(int cantidad){
        if (asientosLocales >= cantidad){
            asientosLocales -= cantidad;
            return true;
        }
        return false;
    }

    public synchronized boolean comprarEntradaVisitante(int cantidad){
        if (asientosVisitantes >= cantidad){
            asientosVisitantes -= cantidad;
            return true;
        }
        return false;
    }

    public void ingresarLocal(int hinchaID){
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Ingreso a la cancha por la puerta Local" + hinchaID);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public void ingresarVisitante(int hinchaID){
        try {
            TimeUnit.SECONDS.sleep(10);
            System.out.println("Ingreso a la cancha por la puerta visitante" + hinchaID);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
