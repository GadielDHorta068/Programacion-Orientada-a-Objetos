package org.deneb.tp5.ejercicio3;

import java.util.concurrent.ThreadLocalRandom;

public class Recurso {
    public void read(int readerId) throws InterruptedException {
        System.out.println("Lector " + readerId + " est� leyendo...");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5001));
        System.out.println("Lector " + readerId + " termin� de leer.");
    }

    public void write(int writerId) throws InterruptedException {
        System.out.println("Escritor " + writerId + " est� escribiendo...");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5001));
        System.out.println("Escritor " + writerId + " termin� de escribir.");
    }
}
