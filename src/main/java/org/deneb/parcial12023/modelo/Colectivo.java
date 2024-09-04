package org.deneb.parcial12023.modelo;

import java.util.Objects;

public class Colectivo {
    private String patente;
    private int asientos;

    public Colectivo(String patente, int asientos) {
        this.patente = patente;
        this.asientos = asientos;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colectivo colectivo = (Colectivo) o;
        return asientos == colectivo.asientos && Objects.equals(patente, colectivo.patente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patente, asientos);
    }

    @Override
    public String toString() {
        return STR."Colectivo{patente='\{patente}\{'\''}, asientos=\{asientos}\{'}'}";
    }
}
