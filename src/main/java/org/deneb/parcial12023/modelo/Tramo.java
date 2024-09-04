package org.deneb.parcial12023.modelo;

public class Tramo {
    private double precio;
    private Localidad origen;
    private Localidad destino;

    public Tramo(double precio, Localidad origen, Localidad destino) {
        this.precio = precio;
        this.origen = origen;
        this.destino = destino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Localidad getOrigen() {
        return origen;
    }

    public void setOrigen(Localidad origen) {
        this.origen = origen;
    }

    public Localidad getDestino() {
        return destino;
    }

    public void setDestino(Localidad destino) {
        this.destino = destino;
    }
}
