package org.deneb.tp5.ejercicio4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

class Peluquero implements Runnable {
    private final BlockingQueue<Cliente> sillasEspera;

    public Peluquero(BlockingQueue<Cliente> sillasEspera) {
        this.sillasEspera = sillasEspera;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Cliente cliente = sillasEspera.take();
                System.out.println("Peluquero está cortando el cabello del Cliente " + cliente.id());
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5001));
                System.out.println("Peluquero terminó de cortar el cabello del Cliente " + cliente.id());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

