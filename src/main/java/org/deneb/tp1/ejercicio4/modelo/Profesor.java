package org.deneb.tp1.ejercicio4.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profesor {
    private int legajo;
    private String Nombre;
    private String Apellido;
    private List<Materia> materias;

    public Profesor(int legajo, String nombre, String apellido, Materia materias) throws MateriaRepetidaException {
        this.legajo = legajo;
        Nombre = nombre;
        Apellido = apellido;
        this.materias = new ArrayList<>();
        agregarMateria(materias);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void agregarMateria(Materia materia) throws MateriaRepetidaException{
        if (materias.contains(materia)){
            throw new MateriaRepetidaException("Materia Repetida");
        }
        materias.addLast(materia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return legajo == profesor.legajo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(legajo);
    }
}
