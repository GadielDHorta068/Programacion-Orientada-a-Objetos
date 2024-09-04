package org.deneb.parcial12022.banco;

import java.util.Objects;

public class Titular {
    private String nombre;
    private String dni;

    public Titular(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return STR."Titular{nombre='\{nombre}\{'\''}, dni='\{dni}\{'\''}\{'}'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titular titular = (Titular) o;
        return Objects.equals(nombre, titular.nombre) && Objects.equals(dni, titular.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni);
    }
}
