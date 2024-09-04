package org.deneb.parcial12023.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Empresa {
    private String nombre;
    private String cuit;
    private List<Tramo> tramos;
    private List<Viaje> viajes;

    public Empresa(String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;

        tramos = new ArrayList<>();
        viajes = new ArrayList<>();
    }

    /**
     * Tramo que contiene el precio del pasaje para las localidades ingresadas
     *
     * @param origen:  localidad donde sube el pasajero
     * @param destino: localidad donde baja el pasajero
     * @return tramo que contiene el precio del pasaje o null si la empresa no vende
     *         pasajes para las localidades ingresadas
     */
    public Tramo tramoPasaje(Localidad origen, Localidad destino){
        for(Tramo t : tramos){
            if(t.getDestino().equals(destino) && t.getOrigen().equals(origen)){
                return t;
            }
        }
        return null;
    }

     /**
     * Viajes que salen en la fecha dada y pasan por el tramo indicado
     *
     * @param fecha:   fecha en la que realiza el viaje
     * @param origen:  localidad donde sube el pasajero
     * @param destino: localidad donde baja el pasajero
     * @return Lista de todos los viajes que cumplen con la condición solicitada.
     *         Retorna null si la empresa no vende pasajes para las localidades
     *         ingresadas (utilizar el método "tramos" ya implementado para la
     *         validación)
     */
    public List<Viaje> viaje(LocalDate fecha, Localidad origen, Localidad destino){
       if (tramoPasaje(origen, destino) == null){
           return null;
       }

        List<Viaje> pasajes = new ArrayList<>();

        for (Viaje v: viajes){
            if(v.getFecha().equals(fecha)){
                    if(v.getRecorrido().getLocalidades().contains(origen) && v.getRecorrido().getLocalidades().contains(destino)){
                        pasajes.add(v);
                    }
            }
        }return pasajes;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nombre, empresa.nombre) && Objects.equals(cuit, empresa.cuit) && Objects.equals(tramos, empresa.tramos) && Objects.equals(viajes, empresa.viajes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cuit, tramos, viajes);
    }

    @Override
    public String toString() {
        return STR."Empresa{nombre='\{nombre}\{'\''}, cuit='\{cuit}\{'\''}, tramos=\{tramos}, viajes=\{viajes}\{'}'}";
    }

    public Viaje agregarViaje(Colectivo c1, Recorrido r1, LocalDate of) {
        viajes.addLast(new Viaje(of,r1, c1));
        return viajes.getLast();
    }

    public void agregarTramo(Localidad origen, Localidad destino, int i) {
        tramos.addLast(new Tramo(i,origen,destino));
    }
}
