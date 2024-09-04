package org.deneb.parcial12021.delivery;

import java.util.Objects;

public class Item {
    private double cantidad;
    private Producto producto;

    public Item(double cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(cantidad, item.cantidad) == 0 && Objects.equals(producto, item.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, producto);
    }

    @Override
    public String toString() {
        return STR."Item{cantidad=\{cantidad}, producto=\{producto}\{'}'}";
    }
}
