package org.deneb.tp5.ejercicio6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Pasajero implements Runnable{
    private final int id;
    private final BlockingQueue<Taxi> taxiQueue;

    public Pasajero(int id, BlockingQueue<Taxi> taxiQueue){
        this.id = id;
        this.taxiQueue = taxiQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Pasajero " + id + " ha llegado a la parada.");

            // Espera hasta que haya un taxi disponible, o se retira después de 1 minuto
            Taxi taxi = taxiQueue.poll(1, TimeUnit.MINUTES);

            if (taxi != null) {
                System.out.println("Pasajero " + id + " ha tomado el taxi " + taxi.id);
            } else {
                System.out.println("Pasajero " + id + " se ha retirado al no encontrar taxis disponibles.");
            }
        } catch (InterruptedException e) {
            System.out.println("Pasajero " + id + " ha sido interrumpido.");
        }
    }
}
