package org.deneb.parcial12021.delivery;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido implements PorPagar {
    private LocalDateTime fechaHora;
    private String observaciones;
    private List<Item> items;

    public Pedido(LocalDateTime fechaHora, String observaciones) {
        this.fechaHora = fechaHora;
        this.observaciones = observaciones;
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(fechaHora, pedido.fechaHora) && Objects.equals(observaciones, pedido.observaciones) && Objects.equals(items, pedido.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHora, observaciones, items);
    }

    @Override
    public String toString() {
        return STR."Pedido{fechaHora=\{fechaHora}, observaciones='\{observaciones}\{'\''}, items=\{items}\{'}'}";
    }

    @Override
    public double calcularPago() {
        double precio = 0;
        for(Item it : items){
            precio += it.getCantidad() * it.getProducto().getPrecio();
        }
        return precio;
    }

    public void agregarItem(Producto producto, int i) {
        items.add(new Item(i, producto));
    }
}
