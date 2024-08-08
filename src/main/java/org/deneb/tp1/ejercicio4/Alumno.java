package org.deneb.tp1.ejercicio4;

public class Alumno {
    private int legajo;
    private String nombre;
    private String apellido;
    private Materia[] materias;

    public Alumno(int legajo, String nombre, String apellido, Materia[] materias) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias = materias;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Materia[] getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = materias;
    }
}
