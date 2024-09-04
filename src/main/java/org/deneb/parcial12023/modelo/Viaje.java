package org.deneb.parcial12023.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Viaje {
    private LocalDate fecha;
    private Colectivo colectivo;
    private List<Pasaje> pasajes;
    private Recorrido recorrido;

    public Viaje(LocalDate fecha, Recorrido recorrido,Colectivo colectivo) {
        this.fecha = fecha;
        this.colectivo = colectivo;
        this.recorrido = recorrido;
        pasajes = new ArrayList<>();
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public List<Pasaje> getPasajes() {
        return pasajes;
    }

    public void setPasajes(List<Pasaje> pasajes) {
        this.pasajes = pasajes;
    }

    public void setRecorrido(Recorrido recorrido) {
        this.recorrido = recorrido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viaje viaje = (Viaje) o;
        return Objects.equals(fecha, viaje.fecha) && Objects.equals(colectivo, viaje.colectivo) && Objects.equals(pasajes, viaje.pasajes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, colectivo, pasajes);
    }

    /**
     * Asientos libres en el colectivo
     *
     * @return retorna una lista con los números de asientos libre que hay en el
     *         colectivo
     */
    public List<Integer> asientosLibres(){
        List<Integer> libres = new ArrayList<Integer>();
        for (int i = 0; i < colectivo.getAsientos(); i++)
            libres.add(i + 1);
        for (Pasaje p : pasajes) {
            libres.remove((Integer) p.getAsiento());

        }
        return libres;
    }

    /**
     * Vende un pasaje del viaje a un pasajero para un tramo y asiento dado
     *
     * @throws RecorridoNoValidoException() El colectivo no pasa por el tramo
     *                                      solicitado o no para en las localidades
     *                                      del mismo (utilizar el método "tramos"
     *                                      ya implementado para la validación)
     *
     * @throws AsientoOcupadoException()    El asiento ya está vendido
     *
     */
    public void venderPasaje(String nombre, String dni, Tramo tramo, int asiento)throws RecorridoNoValidoException,AsientoOcupadoException{
        if(recorrido.tramos(tramo.getOrigen(), tramo.getDestino()).isEmpty()){
            throw new RecorridoNoValidoException();
        }
        if (!asientosLibres().contains(asiento)){
            throw new AsientoOcupadoException();
        }
        pasajes.add(new Pasaje(nombre,dni,tramo,asiento));
    }


}
