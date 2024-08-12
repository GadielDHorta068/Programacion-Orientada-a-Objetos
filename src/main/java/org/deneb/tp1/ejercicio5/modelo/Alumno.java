package org.deneb.tp1.ejercicio5.modelo;


import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private int legajo;
    private String nombre;
    private String apellido;
    private List<Materia> materias;
    private DatosPersonal datos;

    public Alumno(int legajo, String nombre, String apellido) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        materias = new ArrayList<>();
    }


    public Alumno(int i, String nombre, String apellido, String calle, String ciudad, String number, String mail) {
        this.legajo = i;
        this.nombre = nombre;
        this.apellido = apellido;
        this.materias = new ArrayList<>();
        this.datos = new DatosPersonal(calle,ciudad, number, mail);
    }

    /**
     * Materia que cursa el alumno
     * @param mate Materia que cursa el alumno
     * @throws MateriaRepetidaException Excepcion lanzada en caso de que una materia este repetida
     */
    public void agregarMateria(Materia mate) throws MateriaRepetidaException {
        if (materias.contains(mate)){
            throw new MateriaRepetidaException("Materia repetida");
        }
        materias.addLast(mate);
    }

    public List<Materia> getMaterias(){
        return materias;
    }

    public class DatosPersonal {
        private String calle;
        private String ciudad;
        private String telefono;
        private String email;

        public DatosPersonal(String calle, String ciudad, String telefono, String email) {
            this.calle = calle;
            this.ciudad = ciudad;
            this.telefono = telefono;
            this.email = email;
        }
    }
}
