package org.deneb.tp1.ejercicio4.modelo;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Alumno {
    private int legajo;
    private String nombre;
    private String apellido;
    private List<Materia> materias;

    public Alumno(int legajo, String nombre, String apellido) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        materias = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarMateria(Materia mate) throws MateriaRepetidaException{
        if (materias.contains(mate)){
            throw new MateriaRepetidaException("Materia repetida");
        }
        materias.addLast(mate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return legajo == alumno.legajo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(legajo);
    }
}
