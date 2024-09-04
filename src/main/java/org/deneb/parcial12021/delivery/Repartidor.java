package org.deneb.parcial12021.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Repartidor implements PorPagar{
    private String nombre;
    private static double valorViaje;
    private String telefono;
    private List<Pedido> pedidos;

    public Repartidor(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        pedidos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static double getValorViaje() {
        return valorViaje;
    }

    public static void setValorViaje(double valorViaje) {
        Repartidor.valorViaje = valorViaje;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repartidor that = (Repartidor) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(telefono, that.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono);
    }

    @Override
    public String toString() {
        return STR."Repartidor{nombre='\{nombre}\{'\''}, telefono='\{telefono}\{'\''}\{'}'}";
    }

    public Pedido agregarPedido(Pedido pedido){
        pedidos.addLast(pedido);
        return pedidos.getLast();
    }

    @Override
    public double calcularPago() {
        return 0;
    }
}
