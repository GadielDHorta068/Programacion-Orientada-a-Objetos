package org.deneb.tp5.ejercicio8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Espectador implements Runnable{
    private static int contadorEspectadores = 1;
    private int id;
    private Boleteria boleteria;
    private Queue<Integer> filaParaEntrar = new LinkedList<>();
    private Random random = new Random();

    public Espectador(Boleteria boleteria){
        this.id = contadorEspectadores++;
        this.boleteria = boleteria;
    }

    @Override
    public void run() {
        try{
            //Esperar en fila 2min
            Thread.sleep(random.nextInt(2000)+2000);
            System.out.println("Ingresa al cine -> Espectador: " + id);

            int entradasAComprar = random.nextInt(4) + 1;
            int entradasCompradas = boleteria.venderEntradas(entradasAComprar, id);

            if (entradasCompradas > 0) {
                filaParaEntrar.add(id);

                for (int i = 1; i < entradasCompradas; i++) {
                    filaParaEntrar.add(id);
                }

                // Simulación del tiempo de compra en la boletería (1 a 3 minutos)
                Thread.sleep(random.nextInt(2000) + 1000);

                // Pasar por el acomodador
                while (!filaParaEntrar.isEmpty()) {
                    Thread.sleep(1000); // Acomodador tarda 10 segundos por espectador
                    int espectadorEnSala = filaParaEntrar.poll();
                    System.out.println("Ingreso a la sala -> " + (espectadorEnSala == id ? "Espectador: " + id + " entrada #" + (13 - boleteria.getEntradasVendidas()) : "Acompañante espectador: " + id + " entrada #" + (13 - boleteria.getEntradasVendidas())));
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }//nunca protagonista

}
