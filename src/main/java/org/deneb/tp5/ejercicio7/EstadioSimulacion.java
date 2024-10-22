package org.deneb.tp5.ejercicio7;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EstadioSimulacion {
    public static void main(String[] args) {
        Estadio estadio = new Estadio();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Random rand = new Random();

        for (int i = 1; i<= 20; i++){
            boolean esLocal = rand.nextBoolean();
            Hincha hincha = new Hincha(i,estadio,esLocal);
            executor.execute(hincha);

              try {
                TimeUnit.SECONDS.sleep(rand.nextInt(2) + 1); // Hinchas llegan cada 1-2 minutos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
