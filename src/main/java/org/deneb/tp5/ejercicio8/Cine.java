package org.deneb.tp5.ejercicio8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Cine {
    public static void main(String[] args) throws InterruptedException {
        Boleteria boleteria = new Boleteria();
        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 6; i++) {
            executor.execute(new Espectador(boleteria));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Total de entradas vendidas: " + boleteria.getEntradasVendidas());

    }
}
