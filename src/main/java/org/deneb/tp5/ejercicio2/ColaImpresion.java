package org.deneb.tp5.ejercicio2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class ColaImpresion {
    private static final int CAPACIDAD_COLA = 5;

    public static void main(String[] args) {
        BlockingQueue<Documento> colaImpresion = new LinkedBlockingQueue<>(CAPACIDAD_COLA);

        for (int i = 1; i <= 2; i++) {
            int impresoraId = i;
            new Thread(() -> imprimirDocumentos(impresoraId, colaImpresion)).start();
        }

        new Thread(() -> encolarDocumentos(colaImpresion)).start();
    }

    private static void encolarDocumentos(BlockingQueue<Documento> colaImpresion) {
        int documentoId = 1;
        while (true) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2001));
                Documento documento = new Documento("Documento " + documentoId, ThreadLocalRandom.current().nextInt(1, 11), ThreadLocalRandom.current().nextInt(1, 6));
                colaImpresion.put(documento);
                System.out.println(documento.getNombre() + " ingres� a la cola de impresi�n con " + documento.getPaginas() + " p�ginas y " + documento.getCopias() + " copias.");
                documentoId++;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void imprimirDocumentos(int impresoraId, BlockingQueue<Documento> colaImpresion) {
        while (true) {
            try {
                Documento documento = colaImpresion.take();
                int totalPaginas = documento.getPaginas() * documento.getCopias();
                for (int i = 1; i <= totalPaginas; i++) {
                    Thread.sleep(1000);
                    System.out.println("Impresora " + impresoraId + " imprimi� p�gina " + i + " de " + totalPaginas + " del " + documento.getNombre());
                }
                System.out.println("Impresora " + impresoraId + " termin� de imprimir " + documento.getNombre());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}