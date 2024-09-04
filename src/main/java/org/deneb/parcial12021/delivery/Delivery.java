package org.deneb.parcial12021.delivery;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Delivery {
    private String nombre;
    private List<Negocio> negocios;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;
    private List<Repartidor> repartidores;

    public Delivery(String nombre) {
        this.nombre = nombre;
        negocios = new ArrayList<>();
        clientes = new ArrayList<>();
        pedidos = new ArrayList<>();
        repartidores = new ArrayList<>();
    }

    public static void setComisionVentaRealizada(int i) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Negocio> getNegocios() {
        return negocios;
    }

    public void setNegocios(List<Negocio> negocios) {
        this.negocios = negocios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(nombre, delivery.nombre) && Objects.equals(negocios, delivery.negocios) && Objects.equals(clientes, delivery.clientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, negocios, clientes);
    }

    @Override
    public String toString() {
        return STR."Delivery{nombre='\{nombre}\{'\''}, negocios=\{negocios}, clientes=\{clientes}\{'}'}";
    }

    public Negocio agregarNegocio(String nombre, String tel, String calle, int nroPuerta, String cuit, double costoEnvio) {
        Negocio n = new Negocio(nombre,tel,calle,nroPuerta,cuit,costoEnvio);
        negocios.addLast(n);
        return negocios.getLast();
    }

    public Cliente agregarCliente(String  nombre, String telefono, String direccion, int calle) {
        Cliente c = new Cliente(nombre,telefono,direccion,calle);
        clientes.addLast(c);
        return clientes.getLast();
    }

    public Repartidor agregarRepartidor(String mnombre, String telefono) {
        Repartidor r = new Repartidor(mnombre, telefono);
        repartidores.addLast(r);
        return repartidores.getLast();
    }

    public Pedido agregarPedido(Negocio negocio, Cliente cliente, LocalDateTime fecha, String observacion) {
        Pedido p = new Pedido(fecha, observacion );
        pedidos.addLast(p);
        clientes.add(cliente);
        negocios.add(negocio);
        return pedidos.getLast();

    }
}
