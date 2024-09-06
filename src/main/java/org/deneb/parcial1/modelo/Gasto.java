package org.deneb.parcial1.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gasto {
    private LocalDate fecha;
    private String descripcion;
    private List<Division> division;
    private Persona persona;

    public Gasto(LocalDate fecha, String descripcion, Persona persona) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        division = new ArrayList<>();
        this.persona = persona;
    }

    public void agregarDivision( Persona persona,double importe) throws PersonaRepetidaException {
        for (Division div : division){
            if (div.getPersona().equals(persona)) {
                throw new PersonaRepetidaException();
            }
        }
        this.division.add(new Division(importe,persona));
    }

    /**
     * Suma todos los importes que gasto cada integrante en un gasto en común
     *
     * @return importe total del gasto
     *
     * Ejemplo: En el almuerzo Juan gasta $5000, Ana $3000 y Pedro $10000 el total
     * gastado es $18000
     *
     */
    public double importePagado(){
        double total = 0;
        for (Division pagoIndividual : division){
                total += pagoIndividual.getImporte();
        }
        return total;
    }

    /**
     * Retorna cuanto gasto una persona dentro de un gasto en común
     *
     * @param persona
     * @return importe que gasto una persona dentro de un gasto en común. Si la
     *         persona no participo en el gasto retorna cero
     *
     * Ejemplo: En el almuerzo Juan gasta $5000, Ana $3000 y Pedro $10000 el total
     * gastado por Juan es $5000
     *
     */
    public double importeGastado(Persona persona){
        for (Division dividido : division){
            if(dividido.getPersona().equals(persona)){
                return dividido.getImporte();
            }
        }
        return 0;
    }

    /**
     * Metodo que devuelve las personas que gastaron
     * @return Lista de personas
     */
    public List<Persona> pagoPersona(){
       List<Persona> p = new ArrayList<>();
        for (Division div : division){
            p.add(div.getPersona());
        }
        return p;
    }

    //---------Getters Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public Persona getPersona() {
        return persona;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public List<Division> getDivision() {
        return division;
    }


    @Override
    public String toString() {
        return "Gasto{" +
                "fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", division=" + division +
                '}';
    }
    public class Division {
        private double importe;
        private Persona persona;

        public Division(double importe, Persona persona) {
            this.importe = importe;
            this.persona = persona;
        }

        public double getImporte() {
            return importe;
        }


        public Persona getPersona() {
            return persona;
        }

    }
}


