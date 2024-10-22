package org.deneb.tp5.ejercicio6;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Taxi implements Runnable{
    int id;
    private BlockingQueue<Taxi> taxiQueue;

    public Taxi(int id, BlockingQueue<Taxi> taxiQueue) {
        this.id = id;
        this.taxiQueue = taxiQueue;
    }

    @Override
    public void run(){
        try{
            Random random = new Random();
            while (true){
                //taxi espera ser tomado por pasajero
                taxiQueue.put(this);
                System.out.println("Taxi " + id + " esperando en fila");

                //yendo no, llegando
                int travelTime = random.nextInt(8) +1 ;
                Thread.sleep(travelTime *1000);
                System.out.println("Completado viaje");

                //Vuelve
                Thread.sleep(travelTime*1000);

            }
        } catch (InterruptedException e) {
            System.out.println("Taxi " + id + " ha sido interrumpido.");
        }
    }
}
