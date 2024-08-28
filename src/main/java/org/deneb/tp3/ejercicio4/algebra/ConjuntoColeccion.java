package org.deneb.tp3.ejercicio4.algebra;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoColeccion extends BaseConjunto {

    private final Set<Integer> implementacion;
    private final int base;

    public ConjuntoColeccion(int base) {
        if (base > 0 && base <= 64)
            this.base = base;
        else
            this.base = 64;
        this.implementacion = new HashSet<>();
    }

    @Override
    public int getBase() {
        return base;
    }

    @Override
    public boolean pertenece(int x) {
        return implementacion.contains(x);
    }

    @Override
    public boolean vacio() {
        return implementacion.isEmpty();
    }

    @Override
    public void vaciar() {
        implementacion.clear();
    }

    @Override
    public void agregarElemento(int x) {
        if (x >= 0 && x < base) {
            implementacion.add(x);
        }
    }

    @Override
    public void sacarElemento(int x) {
        implementacion.remove(x);
    }

    @Override
    public int cardinalidad() {
        return implementacion.size();
    }

    @Override
    public String toString() {
        return implementacion.toString();
    }

    @Override
    public Conjunto diferenciaSimetrica(Conjunto b) {
        Conjunto diferenciaAB = this.diferencia(b);
        Conjunto diferenciaBA = b.diferencia(this);
        return diferenciaAB.union(diferenciaBA);
    }
}