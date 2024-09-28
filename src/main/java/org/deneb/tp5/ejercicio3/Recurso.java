package org.deneb.tp5.ejercicio3;

import java.util.concurrent.ThreadLocalRandom;

public class Recurso {
    public void read(int readerId) throws InterruptedException {
        System.out.println("Lector " + readerId + " está leyendo...");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5001));
        System.out.println("Lector " + readerId + " terminó de leer.");
    }

    public void write(int writerId) throws InterruptedException {
        System.out.println("Escritor " + writerId + " está escribiendo...");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5001));
        System.out.println("Escritor " + writerId + " terminó de escribir.");
    }
}
