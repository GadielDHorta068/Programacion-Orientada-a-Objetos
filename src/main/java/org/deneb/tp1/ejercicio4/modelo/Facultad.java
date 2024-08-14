package org.deneb.tp1.ejercicio4.modelo;

import java.util.ArrayList;
import java.util.List;

public class Facultad {
    private String nombre;
    private String ciudad;
    private List<Materia> materias;
    private List<Profesor> profesores;
    private List<Alumno> alumnos;

    public Facultad(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        profesores = new ArrayList<>();
        materias = new ArrayList<>();
        alumnos = new ArrayList<>();
    }

    public Alumno agregarAlumno(int i, String nombre, String apellido) throws AlumnoRepetidoException {
        Alumno alum = new Alumno(i, nombre, apellido);
        for (Alumno e : alumnos) {
            if (e.equals(alum)) {
                throw new AlumnoRepetidoException("Alumno repetido");
            }
        }
        alumnos.addLast(alum);
        return alumnos.getLast();
    }

    public Materia agregarMateria(int i, String materia) throws MateriaRepetidaException {
        Materia mate = new Materia(materia, i);
        if (materias.contains(mate)) {
            throw new MateriaRepetidaException("Materia Repetida");
        }
        materias.add(mate);
        return mate;
    }

    public Profesor agregarProfesor(int i, String nombre, String apellido, Materia materia) throws ProfesorRepetidoException, MateriaRepetidaException {
        Profesor profesor = new Profesor(i, nombre, apellido, materia);
        if (profesores.contains(profesor)) {
            throw new ProfesorRepetidoException("profesor Repetida");
        }
        profesores.addLast(profesor);
        return profesores.getLast();
    }
}
