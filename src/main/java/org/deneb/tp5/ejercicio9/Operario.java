package org.deneb.tp5.ejercicio9;

import java.util.Random;

public class Operario implements Runnable{
    private static int contadorPedidos =1;
    private int idPedido;
    private Ascensor ascensor;
    private Random random = new Random();

    public Operario(Ascensor ascensor){
        this.idPedido = contadorPedidos ++;
        this.ascensor = ascensor;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(random.nextInt(5000) + 5000);

            int pisoOrigen, pisoDestino;
            if (random.nextBoolean()) {
                pisoOrigen = 0; // Planta baja
                pisoDestino = random.nextInt(5) + 1; // A un piso entre 1 y 5
            } else {
                pisoOrigen = random.nextInt(5) + 1; // Desde un piso entre 1 y 5
                pisoDestino = 0; // A planta baja
            }

            System.out.println("Pedido: " + idPedido + " piso origen: " + pisoOrigen + " piso destino: " + pisoDestino);

            // Usar el ascensor
            ascensor.usarAscensor(pisoOrigen, pisoDestino, idPedido);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
