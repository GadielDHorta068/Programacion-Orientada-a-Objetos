package org.deneb.tp1.ejercicio5.modelo;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private int codigo;
    private List<Materia> correlativas;

    public Materia(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        correlativas = new ArrayList<>();
    }

    public void agregarCorrelativa(Materia materia) throws MateriaRepetidaException{
        if (correlativas.contains(materia)){
            throw new MateriaRepetidaException("Materia repetida");
        }
        correlativas.addLast(materia);
    }
}
