package org.deneb.tp1.ejercicio3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Factura {
    private int numFactura;
    private Date fecha;
    private List<ItemFactura> items;
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public Factura(int numFactura, Date fecha, Articulo articulo, int cantidad) throws ArticuloRepetidoException, StockInsuficienteException {
        this.numFactura = numFactura;
        this.fecha = fecha;
        items = new ArrayList<>();
        agregarItemFactura(articulo, cantidad);
    }

    public Factura(int numFactura, Date fecha, Articulo articulo, int cantidad, Cliente cliente) throws ArticuloRepetidoException, StockInsuficienteException {
        this.numFactura = numFactura;
        this.fecha = fecha;
        items = new ArrayList<>();
        agregarItemFactura(articulo, cantidad);
        this.cliente = cliente;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<ItemFactura> getItems(){
        return items;
    }

    public void agregarItemFactura(Articulo articulo, int cantidad) throws ArticuloRepetidoException, StockInsuficienteException {
        ItemFactura fac = new ItemFactura(articulo, cantidad);
        boolean contiene = false;
        for (ItemFactura factos : items){
            if (factos.getArticulo().equals(articulo)) {
                contiene = true;
                throw new ArticuloRepetidoException("Articulo repetido en la factura");
            }
        }
        if (articulo.getCantidad() < cantidad){
            throw new StockInsuficienteException("StockInsuficienteDelArticulo");
        }
        items.add(new ItemFactura(articulo, cantidad));
    }

}
     class ItemFactura {
        private int cantidadVendida;
        private float precio;
        private Articulo articulo;

        public ItemFactura(Articulo articulo, int cantidadVendida) {
            this.precio = articulo.getPrecio() * cantidadVendida;
            this.cantidadVendida = cantidadVendida;
            this.articulo = articulo;
        }

        public int getCantidadVendida() {
            return cantidadVendida;
        }

        public void setCantidadVendida(int cantidadVendida) {
            this.cantidadVendida = cantidadVendida;
        }

        public float getPrecio() {
            return precio;
        }

        public void setPrecio(float precio) {
            this.precio = precio;
        }

        public Articulo getArticulo(){
            return articulo;
        }
    }


