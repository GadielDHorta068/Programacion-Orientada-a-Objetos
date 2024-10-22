package org.deneb.tp5.ejercicio10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulacionAscensor {
    public static void main(String[] args) throws InterruptedException {
        Ascensor ascensor1 = new Ascensor(1);
        Ascensor ascensor2 = new Ascensor(2);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++){
            executor.execute((new Operario(ascensor1, ascensor2)));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);


        System.out.println("Total de operarios que utilizaron el ascensor #1: " + ascensor1.getTotalOperariosAtendidos());
        System.out.println("Total de operarios que utilizaron el ascensor #2: " + ascensor2.getTotalOperariosAtendidos());
        System.out.println("Total de pedidos no atendidos: " + (ascensor1.getPedidosNoAtendidos() + ascensor2.getPedidosNoAtendidos()));
    }
}
