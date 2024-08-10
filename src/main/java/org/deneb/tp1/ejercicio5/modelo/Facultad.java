package org.deneb.tp1.ejercicio5.modelo;

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
        alumnos.add(alum);
        return alumnos.getLast();
    }

    public Materia agregarMateria(int i, String materia) throws MateriaRepetidaException {
        Materia mate = new Materia(materia, i);
        if (materias.contains(mate)) {
            throw new MateriaRepetidaException("Materia Repetida");
        }
        materias.add(mate);
        return materias.getLast();
    }

    public Profesor agregarProfesor(int i, String nombre, String apellido, Materia materia) throws ProfesorRepetidoException, MateriaRepetidaException {
        Profesor profesor= new Profesor(i,nombre,apellido,materia);
        if(profesores.contains(profesor)){
            throw new ProfesorRepetidoException("profesor Repetida");
        }
        profesores.addLast(profesor);
        return profesores.getLast();
    }

    public List<Materia> materiasPorProfesor(Profesor profesor) {
        for (Profesor e: profesores){
            if (e.equals(profesor)){
                return e.getMaterias();
            }
        }
        return null;
    }

    public List<Alumno> alumnosPorMateria(Materia materia) {
        List<Alumno> matriculados = new ArrayList<>();
        for (Alumno e: alumnos){
            if (e.getMaterias().contains(materia)){
                matriculados.addLast(e);
            }
        }
        return matriculados;
    }

    public Alumno agregarAlumno(int i, String nombre, String apellido, String calle, String ciudad, String number, String mail) throws AlumnoRepetidoException {
        Alumno alum = new Alumno(i, nombre, apellido,calle,ciudad,number,mail);
        for (Alumno e : alumnos) {
            if (e.equals(alum)) {
                throw new AlumnoRepetidoException("Alumno repetido");
            }
        }
        alumnos.add(alum);
        return alumnos.getLast();
    }

    public Profesor agregarProfesor(int i, String nombre, String apellido, Materia materia, String calle, String ciudad, String number, String mail) throws MateriaRepetidaException, ProfesorRepetidoException {
        Profesor prof = new Profesor(i,nombre,apellido,materia, calle, ciudad, number,mail);
        if (profesores.contains(prof)){
            throw new ProfesorRepetidoException("onettied");
        }
        profesores.addLast(prof);
        return profesores.getLast();
    }

    public int cantidadAlumnosPorMateria(Materia materia) {
        int aux = 0;
        for (Alumno e: alumnos){
            if (e.getMaterias().contains(materia)){
                aux++;
            }
        }
        return aux;
    }
}
