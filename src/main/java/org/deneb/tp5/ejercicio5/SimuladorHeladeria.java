package org.deneb.tp5.ejercicio5;

public class SimuladorHeladeria {
    public static void main(String[] args){
        int empleadosCaja = 2;
        int empleadosPublico = 6;
        int cantidadClientes = 120;

        Heladeria heladeria = new Heladeria(empleadosCaja, empleadosPublico);
        Cliente[] clientes = new Cliente[cantidadClientes];

        for (int i = 0; i < cantidadClientes; i++){
            clientes[i] = new Cliente(i+1, heladeria);
            clientes[i].start();
        }

        for (Cliente cliente : clientes){
            try {
                cliente.join();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Clientes atendidos");
    }
}
