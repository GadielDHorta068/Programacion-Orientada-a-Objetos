package org.deneb.tp1.ejercicio3;

import java.util.Objects;

public class Cliente {
    private int codigo;
    private String nombre;
    private String cuil;
    private String telefono;
    private String direccion;

    public Cliente(int codigo, String nombre, String cuil, String telefono, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuil = cuil;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return codigo == cliente.codigo && Objects.equals(cuil, cliente.cuil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, cuil);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cuil='" + cuil + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
