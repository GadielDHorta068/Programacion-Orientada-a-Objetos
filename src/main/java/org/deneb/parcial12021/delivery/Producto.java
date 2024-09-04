package org.deneb.parcial12021.delivery;

import java.util.Objects;

public class Producto {
    private int codigo;
    private String descripcion;
    private double precio;

    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return codigo == producto.codigo && Double.compare(precio, producto.precio) == 0 && Objects.equals(descripcion, producto.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, descripcion, precio);
    }

    @Override
    public String toString() {
        return STR."Producto{codigo=\{codigo}, descripcion='\{descripcion}\{'\''}, precio=\{precio}\{'}'}";
    }
}
