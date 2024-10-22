package org.deneb.tp5.ejercicio10;

public class Ascensor {
    private int pisoActual = 0;
    private int id;
    private boolean ocupado = false;
    private int totalOperariosAtendidos = 0;
    private int pedidosNoAtendidos = 0;

    public Ascensor(int id){
        this.id = id;
    }

    public synchronized boolean llamarAscensor(int pisoOrigen, int idPedido){
        if(!ocupado){
            ocupado =  true;
            System.out.println("Arranca ascensor en piso " + pisoActual + " para atender pedido #" + idPedido);
            moverAscensor(pisoOrigen);
            return true;
        }else{
            System.out.println("pedido descartado: #"+ idPedido);
            pedidosNoAtendidos++;
            return false;
        }
    }

    public void moverAscensor(int pisoDestino){
        while (pisoActual != pisoDestino) {
            if (pisoActual < pisoDestino) {
                pisoActual++;
            } else {
                pisoActual--;
            }
            System.out.println("Ascensor Piso: " + pisoActual);
            try {
                Thread.sleep(1000); // El ascensor tarda 1 segundo por piso
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void usarAscensor(int pisoOrigen, int pisoDestino, int idPedido) {
        if (llamarAscensor(pisoOrigen, idPedido)) {
            System.out.println("Sube al ascensor (pedido #" + idPedido + ")");
            moverAscensor(pisoDestino);
            System.out.println("Baja del ascensor (pedido #" + idPedido + ")");
            totalOperariosAtendidos++;
            ocupado = false;
        }
    }

    public int getTotalOperariosAtendidos() {
        return totalOperariosAtendidos;
    }
    public boolean estaOcupado(){return ocupado;};
    public int getPisoActual(){return pisoActual;};
    public int getPedidosNoAtendidos() {
        return pedidosNoAtendidos;
    }
}
