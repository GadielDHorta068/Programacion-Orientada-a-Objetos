package org.deneb.tp5.ejercicio10;

import java.util.Random;

public class Operario implements Runnable{
    private static int contadorPedidos =1;
    private int idPedido;
    private Ascensor ascensor1;
    private Ascensor ascensor2;
    private Random random = new Random();

    public Operario(Ascensor ascensor1, Ascensor ascensor2){
        this.idPedido = contadorPedidos ++;
        this.ascensor1 = ascensor1;
        this.ascensor2 = ascensor2;
    }
    @Override
    public void run() {
        try {
            // Simulación del tiempo de llegada del operario para realizar el pedido (5 a 10 segundos)
            Thread.sleep(random.nextInt(5000) + 5000);

            // 50% de probabilidades de que el operario vaya desde planta baja a un piso, o desde un piso a planta baja
            int pisoOrigen, pisoDestino;
            if (random.nextBoolean()) {
                pisoOrigen = 0; // Planta baja
                pisoDestino = random.nextInt(5) + 1; // A un piso entre 1 y 5
            } else {
                pisoOrigen = random.nextInt(5) + 1; // Desde un piso entre 1 y 5
                pisoDestino = 0; // A planta baja
            }

            System.out.println("Pedido: " + idPedido + " piso origen: " + pisoOrigen + " piso destino: " + pisoDestino);

            // Decidir qué ascensor tomar
            asignarAscensor(pisoOrigen, pisoDestino);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void asignarAscensor(int pisoOrigen, int pisoDestino) {
        boolean atendido = false;

        // Si ambos ascensores están libres, seleccionar el más cercano
        if (!ascensor1.estaOcupado() && !ascensor2.estaOcupado()) {
            int distanciaAscensor1 = Math.abs(ascensor1.getPisoActual() - pisoOrigen);
            int distanciaAscensor2 = Math.abs(ascensor2.getPisoActual() - pisoOrigen);

            if (distanciaAscensor1 < distanciaAscensor2) {
                ascensor1.llamarAscensor(pisoOrigen, idPedido);
                ascensor1.usarAscensor(pisoOrigen, pisoDestino, idPedido);
            } else if (distanciaAscensor2 < distanciaAscensor1) {
                ascensor2.llamarAscensor(pisoOrigen, idPedido);
                ascensor2.usarAscensor(pisoOrigen, pisoDestino, idPedido);
            } else {
                // Si están a la misma distancia, usar cualquiera
                if (random.nextBoolean()) {
                    ascensor1.llamarAscensor(pisoOrigen, idPedido);
                    ascensor1.usarAscensor(pisoOrigen, pisoDestino, idPedido);
                } else {
                    ascensor2.llamarAscensor(pisoOrigen, idPedido);
                    ascensor2.usarAscensor(pisoOrigen, pisoDestino, idPedido);
                }
            }
            atendido = true;

            // Si uno está libre, usar el ascensor disponible
        } else if (!ascensor1.estaOcupado()) {
            ascensor1.llamarAscensor(pisoOrigen, idPedido);
            ascensor1.usarAscensor(pisoOrigen, pisoDestino, idPedido);
            atendido = true;
        } else if (!ascensor2.estaOcupado()) {
            ascensor2.llamarAscensor(pisoOrigen, idPedido);
            ascensor2.usarAscensor(pisoOrigen, pisoDestino, idPedido);
            atendido = true;
        }

        // Si los dos están ocupados, el pedido no se atiende
        if (!atendido) {
            System.out.println("Pedido descartado: " + idPedido);
        }
    }
}
