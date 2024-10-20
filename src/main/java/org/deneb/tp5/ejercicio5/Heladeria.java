package org.deneb.tp5.ejercicio5;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Heladeria {
    private int empleadosCaja;
    private int empleadosPublico;
    private Queue<Cliente> colaCaja = new LinkedList<>();
    private Queue<Cliente> colaPublico = new LinkedList<>();
    private Random random = new Random();

    public Heladeria(int empleadosCaja, int empleadosPublico){
        this.empleadosCaja = empleadosCaja;
        this.empleadosPublico = empleadosPublico;
    }

    public synchronized void atenderEnCaja(Cliente cliente){
        colaCaja.add(cliente);
        while (colaCaja.peek() != cliente){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int tiempoAtencion = random.nextInt(3)+2;
        try {
            Thread.sleep(tiempoAtencion * 1000); // Convertir minutos a milisegundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Cliente" + cliente.getID() + " atendido en publico");
        colaPublico.poll();
        notifyAll();
    }

    public synchronized void atenderEnPublico(Cliente cliente){
        colaPublico.add(cliente);
        while (colaPublico.peek() != cliente){
            try{
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int tiempoAtencion = random.nextInt(3) +2;
        try{
            Thread.sleep(tiempoAtencion *1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }

        System.out.println("Cliente " + cliente.getId() + " atendido en público.");
        colaPublico.poll();
        notifyAll();
    }
}
