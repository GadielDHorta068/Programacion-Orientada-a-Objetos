package org.deneb.parcial1.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nombre;
    private List<Pago> pagos;
    private List<Persona> personas;
    private List<Gasto> gastos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        pagos = new ArrayList<>();
        personas = new ArrayList<>();
        gastos = new ArrayList<>();
    }

    public Pago agregarPago(Pago pago) throws PersonaRepetidaException {
        if(pago.getRecibe().equals(pago.getTransfiere())){
            throw new PersonaRepetidaException();
        }
        pagos.addLast(pago);
        return pagos.getLast();
    }

    public Pago agregarPago(LocalDate fecha, Persona p1, Persona p2, double importe) throws PersonaRepetidaException {
        Pago pago = new Pago(fecha,importe,p1,p2);

        if(pago.getRecibe().equals(pago.getTransfiere())){
            throw new PersonaRepetidaException();
        }
        pagos.addLast(pago);
        return pagos.getLast();
    }

    public Persona agregarPersona(Persona persona) throws PersonaRepetidaException{
        if (personas.contains(persona)){
            throw new PersonaRepetidaException();
        }
        personas.addLast(persona);
        return personas.getLast();
    }

    public Persona agregarIntegrante(String nombre, String mail) throws PersonaRepetidaException {
        Persona persona = new Persona(nombre, mail);
        if (personas.contains(persona)){
            throw new PersonaRepetidaException();
        }
        personas.addLast(persona);
        return personas.getLast();
    }

    public Gasto agregarGasto(LocalDate fecha, String descripcion, Persona persona) {
        Gasto gasto = new Gasto(fecha, descripcion, persona);
        gastos.addLast(gasto);
        return gastos.getLast();
    }

    /**
     * Suma todos los importes que pagó una persona
     *
     * @param persona: persona que realizó los pagos
     * @return importe total de todos los gastos que pagó una persona
     */
    public double totalPagado(Persona persona){
        double total = 0;
        for(Pago p : pagos){
            if (p.getTransfiere().equals(persona)){
                total += p.getImporte();
            }
        }
        return total;
    }

    /**
     * Suma todos los importes que gastó una persona
     *
     * @param persona: persona que realizó los gastos
     * @return importe total de todos los gastos que realizó una persona
     */
    public double totalGastado(Persona persona){
        double total = 0;
        for(Gasto g : gastos){
            total += g.importeGastado(persona);
        }
        return total;
    }

    /**
     * Retorna cuando le debe una persona a otra. Calcula todos los gastos
     * que le pago la persona1 a la persona2, los compensa con los gastos que pago la
     * persona2 a la persona1 y tiene en cuenta las transferencias que se hicieron
     * entre ambos
     *
     * @param persona1
     * @param persona2
     * @return saldo que tiene la persona1 con la persona2. El saldo puede ser:
     *
     *         acreedor: saldo positivo, la persona2 le debe a la persona1
     *
     *         deudor: saldo negativo, la persona1 le debe a la persona2
     *
     *         nulo: saldo cero, no hay deudas entre la persona1 y la persona2
     *
     */
    public double saldo(Persona persona1, Persona persona2){
        double cuentaPersona1 = 0;
        double cuentaPersona2 = 0;
        for (Pago p : pagos){
            if (p.getTransfiere().equals(persona1) && p.getRecibe().equals(persona2)){
                cuentaPersona1 += p.getImporte();
            } else if (p.getTransfiere().equals(persona2) && p.getRecibe().equals(persona1)) {
                cuentaPersona2 += p.getImporte();
            }
        }
        //hasta aca tengo los pagos entre ellos

        //ahora a agregarle los gastos
        for (Gasto g : gastos){
            if(g.getPersona().equals(persona1)){
                for (Gasto.Division d : g.getDivision()){
                    if(d.getPersona().equals(persona2)){
                        cuentaPersona2 -= d.getImporte();
                    }
                }
            }
            if(g.getPersona().equals(persona2)){
                for (Gasto.Division d : g.getDivision()){
                    if(d.getPersona().equals(persona1)){
                        cuentaPersona1 -= d.getImporte();
                    }
                }
            }
        }

        return cuentaPersona1 - cuentaPersona2;
    }



    // ------- Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "nombre='" + nombre + '\'' +
                ", pagos=" + pagos +
                ", personas=" + personas +
                ", gastos=" + gastos +
                '}';
    }
}
