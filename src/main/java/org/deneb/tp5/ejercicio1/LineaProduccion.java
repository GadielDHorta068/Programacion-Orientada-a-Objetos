package org.deneb.tp5.ejercicio1;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class LineaProduccion {
    private static final int CAPACIDAD_CINTA = 12;
    private static final int TOTAL_PRODUCTOS_POR_EQUIPO = 24;

    public static void main(String[] args) {
        BlockingQueue<String> cintaEmpaque = new LinkedBlockingQueue<>(CAPACIDAD_CINTA);
        for (int i = 1; i <= 3; i++) {
            int equipoId = i;
            new Thread(() -> producirProductos(equipoId, cintaEmpaque)).start();
        }
        new Thread(() -> empacarProductos(cintaEmpaque)).start();
    }

    private static void producirProductos(int equipoId, BlockingQueue<String> cintaEmpaque) {
        for (int i = 1; i <= TOTAL_PRODUCTOS_POR_EQUIPO; i++) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 3001));
                String producto = STR."Producto \{i} del Equipo \{equipoId}";
                cintaEmpaque.put(producto);
                System.out.println(STR."\{producto} ingresó a la cinta de empaque.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void empacarProductos(BlockingQueue<String> cintaEmpaque) {
        int productosEmpacados = 0;
        while (true) {
            try {
                String producto = cintaEmpaque.take();
                productosEmpacados++;
                Thread.sleep(1000);
                System.out.println(STR."Empacadora empacó: \{producto}");

                if (productosEmpacados % 6 == 0) {
                    Thread.sleep(3000);
                    System.out.println("Empacadora cerró una caja.");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

