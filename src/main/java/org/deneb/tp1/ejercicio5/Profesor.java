package org.deneb.tp1.ejercicio5;

public class Profesor {
    private int legajo;
    private String Nombre;
    private String Apellido;
    private Materia[] materias;

    public Profesor(int legajo, String nombre, String apellido, Materia[] materias) {
        this.legajo = legajo;
        Nombre = nombre;
        Apellido = apellido;
        this.materias = materias;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }
}
