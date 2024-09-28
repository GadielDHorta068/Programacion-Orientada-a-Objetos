package org.deneb.tp5.ejercicio4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Peluqueria {
    private static final int NUM_SILLAS_ESPERA = 5;

    public static void main(String[] args) {
        BlockingQueue<Cliente> sillasEspera = new LinkedBlockingQueue<>(NUM_SILLAS_ESPERA);
        Peluquero peluquero = new Peluquero(sillasEspera);

        new Thread(peluquero).start();

        for (int i = 1; i <= 10; i++) {
            int clienteId = i;
            new Thread(() -> {
                try {
                    Cliente cliente = new Cliente(clienteId);
                    if (sillasEspera.offer(cliente)) {
                        System.out.println("Cliente " + clienteId + " se sienta en la sala de espera.");
                    } else {
                        System.out.println("Cliente " + clienteId + " se va porque no hay sillas disponibles.");
                    }
                    Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3001));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}



