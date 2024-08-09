package org.deneb.tp1.ejercicio3;

public class Cliente {
    private int codigo;
    private String nombre;
    private String cuil;
    private String telefono;
    private String direccion;

    public Cliente(int codigo, String nombre, String cuil, String telefono, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuil = cuil;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
