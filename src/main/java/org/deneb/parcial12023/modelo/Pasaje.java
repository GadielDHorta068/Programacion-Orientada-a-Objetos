package org.deneb.parcial12023.modelo;

public class Pasaje {
    private String nombre;
    private String dni;
    private int asiento;
    private Tramo tramo;

    public Pasaje(String nombre, String dni,Tramo tramo, int asiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.asiento = asiento;
        this.tramo = tramo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getAsiento() {
        return asiento;
    }

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public Tramo getTramo() {
        return tramo;
    }

    public void setTramo(Tramo tramo) {
        this.tramo = tramo;
    }
}
