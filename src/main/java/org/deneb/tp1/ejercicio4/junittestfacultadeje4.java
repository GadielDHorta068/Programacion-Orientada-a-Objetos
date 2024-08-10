package org.deneb.tp1.ejercicio4;

import org.deneb.tp1.ejercicio4.modelo.*;
import org.junit.Before;
import org.junit.Test;

// Test ejercicio 14

public class junittestfacultadeje4 {

	private Facultad mifacultad = new Facultad("Ingenieria", "Puerto Madryn");

	private Alumno alumno1, alumno2, alumno3;
	private Materia materia1, materia2, materia3, materia4;
	private Profesor profesor1, profesor2, profesor3;

	@Before
	public void antesDelTest() throws MateriaRepetidaException, AlumnoRepetidoException, ProfesorRepetidoException {

		alumno1 = mifacultad.agregarAlumno(1, "Juan", "Perez");
		alumno2 = mifacultad.agregarAlumno(2, "Miguel", "Sanchez");
		alumno3 = mifacultad.agregarAlumno(3, "Nicolas", "Fernandez");

		materia1 = mifacultad.agregarMateria(1, "Algebra");
		materia2 = mifacultad.agregarMateria(2, "Algebra 2");
		materia3 = mifacultad.agregarMateria(3, "Programacion");
		materia4 = mifacultad.agregarMateria(4, "Logica");

		profesor1 = mifacultad.agregarProfesor(1, "Alvaro", "Dominguez", materia1);
		profesor2 = mifacultad.agregarProfesor(2, "Esteban", "Alosa", materia3);
		profesor3 = mifacultad.agregarProfesor(3, "Matias", "Gimenez", materia4);

		profesor1.agregarMateria(materia2);

		alumno1.agregarMateria(materia1);

		alumno2.agregarMateria(materia1);
		alumno2.agregarMateria(materia4);

		alumno3.agregarMateria(materia2);
		alumno3.agregarMateria(materia3);

	}

	@Test(expected = MateriaRepetidaException.class)
	public void agregarMateriaRepetidaAAlumno() throws MateriaRepetidaException{
		alumno1.agregarMateria(materia1);
	}

	@Test(expected = MateriaRepetidaException.class)
	public void agrgearMateriaRepetidaAProfesor() throws MateriaRepetidaException{
		profesor1.agregarMateria(materia2);
	}

	@Test(expected = MateriaRepetidaException.class)
	public void agregarMateriaRepetidaAFacultad() throws MateriaRepetidaException{
		mifacultad.agregarMateria(1, "Algebra");
	}

	@Test(expected = AlumnoRepetidoException.class)
	public void agregarAlumnoRepetidoAFacultad() throws AlumnoRepetidoException{
		mifacultad.agregarAlumno(3, "Nicolas", "Fernandez");
	}

	@Test(expected = ProfesorRepetidoException.class)
	public void agregarProfesorRepetidoAFacultad() throws ProfesorRepetidoException, MateriaRepetidaException {
		mifacultad.agregarProfesor(3, "Matias", "Gimenez", materia4);
	}

}
