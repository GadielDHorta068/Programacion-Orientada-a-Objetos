package org.deneb.tp1.ejercicio5.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Materia {
    private String nombre;
    private int codigo;
    private List<Materia> correlativas;

    public Materia(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        correlativas = new ArrayList<>();
    }

    /**
     * Materia correlativa a esta
     * @param materia
     * @throws MateriaRepetidaException
     */
    public void agregarCorrelativa(Materia materia) throws MateriaRepetidaException{
        if (correlativas.contains(materia)){
            throw new MateriaRepetidaException("Materia repetida");
        }
        correlativas.addLast(materia);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return codigo == materia.codigo && Objects.equals(nombre, materia.nombre) && Objects.equals(correlativas, materia.correlativas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, codigo, correlativas);
    }
}
