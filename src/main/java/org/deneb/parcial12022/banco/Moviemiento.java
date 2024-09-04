package org.deneb.parcial12022.banco;


import java.time.LocalDate;

public class Moviemiento {
    private LocalDate fecha;
    private String detalle;
    private double importe;

    public Moviemiento(LocalDate fecha, String detalle, double importe) {
        this.fecha = fecha;
        this.detalle = detalle;
        this.importe = importe;
    }

    @Override
    public String toString() {
        return STR."Moviemiento{fecha=\{fecha}, detalle='\{detalle}\{'\''}, importe=\{importe}\{'}'}";
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
}
