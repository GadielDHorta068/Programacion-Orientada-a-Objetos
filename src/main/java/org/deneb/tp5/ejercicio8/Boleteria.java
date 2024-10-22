package org.deneb.tp5.ejercicio8;

public class Boleteria {
    private int entradasDisponibles = 12;
    private int entradasVendidas = 0;

    public synchronized int venderEntradas(int numEntradas, int espectador) throws InterruptedException{
        if (entradasDisponibles >= numEntradas){
            System.out.println("Boletería 1 -> Espectador: " + espectador + " compra " + numEntradas + " entrada(s)");
            entradasDisponibles -= numEntradas;
            entradasVendidas += numEntradas;
            return numEntradas;
        }else {
            System.out.println("Boletería 1 -> Espectador: " + espectador + " intenta comprar " + numEntradas + " entrada(s), pero no hay suficientes.");
            return 0;
        }
    }

    public int getEntradasVendidas(){
        return entradasVendidas;
    }
}
