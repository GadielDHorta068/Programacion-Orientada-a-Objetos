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

    /**
     * Agregar alumno al padron
     * @param i numero de legajo
     * @param nombre Nombre
     * @param apellido Apellido
     * @return Alumno creao
     * @throws AlumnoRepetidoException Alumno duplicado en el padron
     */
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

    /**
     * Agregar matera a disponibles
     * @param i codigo de materia
     * @param materia nombre de materia
     * @return Materia creada
     * @throws MateriaRepetidaException la materia ya existe en la lista
     */
    public Materia agregarMateria(int i, String materia) throws MateriaRepetidaException {
        Materia mate = new Materia(materia, i);
        if (materias.contains(mate)) {
            throw new MateriaRepetidaException("Materia Repetida");
        }
        materias.add(mate);
        return materias.getLast();
    }

    /**
     * Profesor a ser agregado al padron
     * @param i numero de legajo
     * @param nombre Nombre
     * @param apellido Apellido
     * @param materia Materia a ser agregado (al menos una)
     * @return Profesor agregado
     * @throws ProfesorRepetidoException ya existe el profesor
     * @throws MateriaRepetidaException ya esta asignado a esa materia
     */
    public Profesor agregarProfesor(int i, String nombre, String apellido, Materia materia) throws ProfesorRepetidoException, MateriaRepetidaException {
        Profesor profesor= new Profesor(i,nombre,apellido,materia);
        if(profesores.contains(profesor)){
            throw new ProfesorRepetidoException("profesor Repetida");
        }
        profesores.addLast(profesor);
        return profesores.getLast();
    }

    /**
     * Lista de materias a la que un profesor asiste
     * @param profesor Profesor a ser analizado
     * @return List<Materia>
     */
    public List<Materia> materiasPorProfesor(Profesor profesor) {
        for (Profesor e: profesores){
            if (e.equals(profesor)){
                return e.getMaterias();
            }
        }
        return null;
    }

    /**
     * Lista de alumnos a la que asisten a una materia
     * @param materia Materia a ser analizada
     * @return List<Alumno>
     */
    public List<Alumno> alumnosPorMateria(Materia materia) {
        List<Alumno> matriculados = new ArrayList<>();
        for (Alumno e: alumnos){
            if (e.getMaterias().contains(materia)){
                matriculados.addLast(e);
            }
        }
        return matriculados;
    }

    /**
     * Crear un nuevo alumno con la clase compuesta DatosPersonal
     * @param i Numero de legajo
     * @param nombre Nombre
     * @param apellido Apellido
     * @param calle domicilio
     * @param ciudad ciudad
     * @param number Numero de telefono
     * @param mail mail del alumno
     * @return Alumno agregado al padron
     * @throws AlumnoRepetidoException El alumno ya existe en el padron
     */
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

    /**
     * Agregar profesor con la dependencia DatosPersonal
     * @param i Numero de legajo
     * @param nombre Nombre
     * @param apellido Apellido
     * @param materia Materia
     * @param calle Domicilio
     * @param ciudad Ciudad
     * @param number Numero de telefono
     * @param mail mail
     * @return Profesor agregado al padron
     * @throws MateriaRepetidaException Evitar agregar una materia repetida
     * @throws ProfesorRepetidoException Evitar agregar un profesor repetido al padron
     */
    public Profesor agregarProfesor(int i, String nombre, String apellido, Materia materia, String calle, String ciudad, String number, String mail) throws MateriaRepetidaException, ProfesorRepetidoException {
        Profesor prof = new Profesor(i,nombre,apellido,materia, calle, ciudad, number,mail);
        if (profesores.contains(prof)){
            throw new ProfesorRepetidoException("onettied");
        }
        profesores.addLast(prof);
        return profesores.getLast();
    }

    /**
     * Devuelve la cantidad de alumnos que cursa esa materia
     * @param materia Materia a ser analizada
     * @return int
     */
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
