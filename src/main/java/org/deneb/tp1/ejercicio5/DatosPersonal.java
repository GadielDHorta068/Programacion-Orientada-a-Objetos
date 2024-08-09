package org.deneb.tp1.ejercicio5;

public class DatosPersonal {
    private String calle;
    private String ciudad;
    private int telefono;
    private String email;

    public DatosPersonal(String calle, String ciudad, int telefono, String email) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.email = email;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
