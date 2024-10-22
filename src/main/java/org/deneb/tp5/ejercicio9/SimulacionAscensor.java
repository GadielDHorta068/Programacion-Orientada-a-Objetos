package org.deneb.tp5.ejercicio9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulacionAscensor {
    public static void main(String[] args) throws InterruptedException {
        Ascensor ascensor = new Ascensor();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++){
            executor.execute((new Operario(ascensor)));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Total de operarios que utilizaron el ascensor: " + ascensor.getTotalOperariosAtendidos());
        System.out.println("Total de pedidos no atendidos: " + ascensor.getPedidosNoAtendidos());

    }
}
