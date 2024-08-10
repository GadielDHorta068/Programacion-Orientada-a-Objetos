package org.deneb.tp1.ejercicio4.modelo;


import java.util.ArrayList;
import java.util.List;

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
}
