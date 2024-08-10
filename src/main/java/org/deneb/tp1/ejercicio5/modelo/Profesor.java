package org.deneb.tp1.ejercicio5.modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private int legajo;
    private String Nombre;
    private String Apellido;

    private List<Materia> materias;
    private DatosPersonal datos;

    public Profesor(int legajo, String nombre, String apellido, Materia materias) throws MateriaRepetidaException {
        this.legajo = legajo;
        Nombre = nombre;
        Apellido = apellido;
        this.materias = new ArrayList<>();
        agregarMateria(materias);
    }

    public Profesor(int legajo, String nombre, String apellido, Materia materia, String calle, String ciudad, String number, String mail) throws MateriaRepetidaException {
        this.legajo = legajo;
        Nombre = nombre;
        Apellido = apellido;
        this.materias = new ArrayList<>();
        agregarMateria(materia);
        this.datos = new DatosPersonal(calle,ciudad, number, mail );
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void agregarMateria(Materia materia) throws MateriaRepetidaException {
        if (materias.contains(materia)){
            throw new MateriaRepetidaException("Materia Repetida");
        }
        materias.addLast(materia);
    }

    public List<Materia> getMaterias() {
        return materias;
    }
}
