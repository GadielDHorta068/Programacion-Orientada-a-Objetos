package org.deneb.parcial1.modelo;

import java.time.LocalDate;

public class Pago {
    private final LocalDate fecha;
    private final double importe;
    private final Persona transfiere;
    private final Persona recibe;

    public Pago(LocalDate fecha, double importe, Persona transfiere, Persona recibe) {
        this.fecha = fecha;
        this.importe = importe;
        this.transfiere = transfiere;
        this.recibe = recibe;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }


    public Persona getTransfiere() {
        return transfiere;
    }


    public Persona getRecibe() {
        return recibe;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "fecha=" + fecha +
                ", importe=" + importe +
                ", transfiere=" + transfiere +
                ", recibe=" + recibe +
                '}';
    }
}
