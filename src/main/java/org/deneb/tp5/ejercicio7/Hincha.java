package org.deneb.tp5.ejercicio7;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Hincha implements Runnable{
    private int id;
    private Estadio estadio;
    private boolean esLocal;

    public Hincha(int id, Estadio estadio, boolean esLocal) {
        this.id = id;
        this.estadio = estadio;
        this.esLocal = esLocal;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int entradas = rand.nextInt(6) +1;
        System.out.println("Ingresa a sacar una entrada Hicha " + id + (esLocal ? " Local" : " Visitante"));

        try {
            TimeUnit.MINUTES.sleep(rand.nextInt(2) +1);
            System.out.println("Ingreso a la cancha por la puerta visitante" + id);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        boolean compraExitosa = esLocal ? estadio.comprarEntradaLocal(entradas) : estadio.comprarEntradaVisitante(entradas);

        if (compraExitosa) {
            System.out.println("Boletería -> Hincha: " + id + " compró " + entradas + " entradas.");
            for (int i = 0; i < entradas; i++) {
                if (esLocal) {
                    estadio.ingresarLocal(id);
                } else {
                    estadio.ingresarVisitante(id);
                }
            }
        } else {
            System.out.println("Hincha: " + id + " no pudo comprar suficientes entradas y se retira.");
        }
    }
}
