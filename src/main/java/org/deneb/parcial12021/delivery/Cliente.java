package org.deneb.parcial12021.delivery;

import java.util.Objects;

public class Cliente {
    private String nombre;
    private String telefono;
    private String calle;
    private int nroPuerta;

    public Cliente(String nombre, String telefono, String calle, int nroPuerta) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.calle = calle;
        this.nroPuerta = nroPuerta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNroPuerta() {
        return nroPuerta;
    }

    public void setNroPuerta(int nroPuerta) {
        this.nroPuerta = nroPuerta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return nroPuerta == cliente.nroPuerta && Objects.equals(nombre, cliente.nombre) && Objects.equals(telefono, cliente.telefono) && Objects.equals(calle, cliente.calle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono, calle, nroPuerta);
    }

    @Override
    public String toString() {
        return STR."Cliente{nombre='\{nombre}\{'\''}, telefono='\{telefono}\{'\''}, calle='\{calle}\{'\''}, nroPuerta=\{nroPuerta}\{'}'}";
    }
}
