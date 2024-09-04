package org.deneb.parcial12021.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Negocio {
    private String nombre;
    private String telefono;
    private String calle;
    private int nroPuerta;
    private String cuit;
    private double costoEnvio;
    private List<Producto> productos;

    public Negocio(String nombre, String telefono, String calle, int nroPuerta, String cuit, double costoEnvio) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.calle = calle;
        this.nroPuerta = nroPuerta;
        this.cuit = cuit;
        this.costoEnvio = costoEnvio;
        productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNroPuerta() {
        return nroPuerta;
    }

    public void setNroPuerta(int nroPuerta) {
        this.nroPuerta = nroPuerta;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return STR."Negocio{nombre='\{nombre}\{'\''}, telefono='\{telefono}\{'\''}, calle='\{calle}\{'\''}, nroPuerta=\{nroPuerta}, cuit='\{cuit}\{'\''}, costoEnvio=\{costoEnvio}\{'}'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Negocio negocio = (Negocio) o;
        return nroPuerta == negocio.nroPuerta && Double.compare(costoEnvio, negocio.costoEnvio) == 0 && Objects.equals(nombre, negocio.nombre) && Objects.equals(telefono, negocio.telefono) && Objects.equals(calle, negocio.calle) && Objects.equals(cuit, negocio.cuit) && Objects.equals(productos, negocio.productos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, telefono, calle, nroPuerta, cuit, costoEnvio, productos);
    }

    public Producto agregarProducto(int codigo, String nombre, double precio) {
        Producto p = new  Producto(codigo, nombre, precio);
        productos.addLast(p);
        return productos.getLast();
    }
}
