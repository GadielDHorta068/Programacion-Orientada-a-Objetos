package org.deneb.tp1.ejercicio2.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int numFactura;
    private LocalDate fecha;
    private List<ItemFactura> items;

    public Factura(int numFactura, LocalDate fecha, Articulo articulo, int cantidad) throws ArticuloRepetidoException, StockInsuficienteException {
        this.numFactura = numFactura;
        this.fecha = fecha;
        items = new ArrayList<>();
        agregarItem(articulo, cantidad);
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void agregarItem(Articulo articulo, int cantidad) throws ArticuloRepetidoException, StockInsuficienteException{
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

    public double importeTotal() {
        double aux = 0;
        for (ItemFactura factos : items){
                aux += factos.getPrecio();
        }
        return aux;
    }
}
     class ItemFactura {
        private int cantidadVendida;
        private double precio;
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

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(float precio) {
            this.precio = precio;
        }

        public Articulo getArticulo(){
            return articulo;
        }
    }


