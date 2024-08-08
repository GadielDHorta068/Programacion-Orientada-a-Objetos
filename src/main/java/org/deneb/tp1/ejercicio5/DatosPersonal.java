package org.deneb.tp1.ejercicio5;

public class DatosPersonal {
    private String calle;
    private String ciudad;
    private String mail;
    private int telefono;

    public DatosPersonal(String calle, String ciudad, String mail, int telefono) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.mail = mail;
        this.telefono = telefono;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
