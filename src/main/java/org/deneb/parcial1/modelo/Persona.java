package org.deneb.parcial1.modelo;

import java.util.Objects;

public class Persona {
    private String nombre;
    private String email;

    public Persona(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return  Objects.equals(email, persona.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, email);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
