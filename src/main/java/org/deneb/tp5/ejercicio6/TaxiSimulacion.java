package org.deneb.tp5.ejercicio6;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TaxiSimulacion {
    public static void main(String[] args) {
        BlockingQueue<Taxi> taxiQueue = new LinkedBlockingQueue<>();
        int numeroTaxis = 5;
        int numeroPasajeros = 25;
        Random random = new Random();

        //Hilacho de taxis
        for ( int i = 1; i <= numeroTaxis; i++){
            Taxi taxi = new Taxi(i, taxiQueue);
            new Thread(taxi).start();
        }

        //Hilo pasajeros
        for (int i = 1; i <= numeroPasajeros; i++) {
            try {
                // Los pasajeros llegan cada 1 a 2 minutos
                int arrivalTime = random.nextInt(2) + 1;
                Thread.sleep(arrivalTime * 1000);

                Pasajero passenger = new Pasajero(i, taxiQueue);
                new Thread(passenger).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
