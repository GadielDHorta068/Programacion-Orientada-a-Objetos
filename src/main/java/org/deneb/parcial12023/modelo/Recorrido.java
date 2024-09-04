package org.deneb.parcial12023.modelo;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {
    private int id;
    private final List<Localidad> localidades;

    public Recorrido(int id, Localidad l1, Localidad l2) {
        localidades = new ArrayList<>();
        localidades.addFirst(l1);
        localidades.addLast(l2);
        this.id = id;
    }

    public List<Localidad> getLocalidades() {
        return localidades;
    }

    public boolean agregarTramo(Localidad t){
        return localidades.add(t);
    }

    /**
     * Listado de todas las localidades por las que pasa el colectivo entre dos
     * localidades dadas
     *
     * @param origen:  localidad inicial del tramo
     * @param destino: localidad final del tramo
     * @return retorna una lista con todas las localidades de un tramo dado. En la
     *         lista retornada incluye la localidad de origen y no incluye la
     *         localidad de destino
     */
    public List<Localidad> tramos(Localidad origen, Localidad destino){
        List<Localidad> tr = new ArrayList<Localidad>();
        int posOrigen = localidades.indexOf(origen);
        int posDestino = localidades.indexOf(destino);
        if (posOrigen == -1 || posDestino == -1)
            return tr;
        for (int i = posOrigen; i < posDestino; i++)
            tr.add(localidades.get(i));
        return tr;
    }

    public void agregarLocalidad(Localidad loc) {
        localidades.add(loc);
    }
}
