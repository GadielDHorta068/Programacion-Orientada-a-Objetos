package org.deneb.tp1.ejercicio4.modelo;

import java.util.Objects;

public class Materia {
    private String nombre;
    private int codigo;

    public Materia(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return codigo == materia.codigo && Objects.equals(nombre, materia.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, codigo);
    }
}
