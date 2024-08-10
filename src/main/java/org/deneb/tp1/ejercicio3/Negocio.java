package org.deneb.tp1.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Negocio {

    private String cuil;
    private String nombre;

    List<Articulo> stock = new ArrayList<>();
    List<Factura> facturas = new ArrayList<>();


    public Negocio(String cuil, String nombre) {
        this.cuil = cuil;
        this.nombre = nombre;
    }

    /**
     * Cambia en un porcentaje el precio de todos los artículos del stock
     *
     * @param porcCambio: porcentaje de cambios de precio
     *
     */
    public void cambiarPrecio(double porcCambio){
        for (Articulo e : stock){
            double precioActual = e.getPrecio();
            double nuevoPrecio =  precioActual * (1 + porcCambio) * 0.1;
            e.setPrecio(nuevoPrecio);
        }
    }

    /**
     * Retorna el valor total del stock multiplicando la cantidad existente por el
     * precio
     *
     * @return stock valorizado
     */
    public double stockValorizado(){
        double valor = 0;
        for (Articulo e : stock){
            valor += e.getPrecio() * e.getCantidad();
        }
        return valor;
    }

    public Articulo agregarArticulo(int i, String destornillador, double v, int i1) {
        Articulo art = new Articulo(i,destornillador,v, i1);
        stock.add(art);
        return art;
    }

    public Cliente agregarCliente(int i, String juan, String s, String s1, String s2) {
        return new Cliente(i,juan,s,s1,s2);
    }

    public Factura agregarFactura(int i, LocalDate of, Articulo des, int i1) throws StockInsuficienteException, ArticuloRepetidoException {
        return new Factura(i, of, des, i1);
    }

    public double totalFacturado(LocalDate of, LocalDate to) {
        double aux = 0;
        for (Factura e : facturas) {
            LocalDate fecha = e.getFecha();
            if ((fecha.isEqual(of) || fecha.isAfter(of)) && (fecha.isEqual(to) || fecha.isBefore(to))) {
                aux += e.importe();
            }
        }
        return aux;
    }

    public double totalFacturadoCtaCte(LocalDate of, LocalDate of1) {
        double auxiliar = 0;
        for(Factura e: facturas){
            if(e.isCtaCte()){
                if(e.getFecha().isEqual(of) || e.getFecha().isAfter(of) && e.getFecha().isEqual(of1) || e.getFecha().isBefore(of1)){
                    for(ItemFactura item : e.getItems()){
                        auxiliar += item.getPrecio();
                    }
                }
            }
            }
        return auxiliar;
    }

    public double totalFacturadoClienteCtaCte(LocalDate of, LocalDate of1, Cliente cliente) {
        double auxiliar = 0;
        for(Factura e: facturas){
            if (e.getCliente().equals(cliente)){
                if(e.getFecha().isEqual(of) || e.getFecha().isAfter(of) && e.getFecha().isEqual(of1) || e.getFecha().isBefore(of1)){
                    for(ItemFactura item : e.getItems()){
                        auxiliar += item.getPrecio();
                    }
                }
            }
        }
        return auxiliar;
    }

    public double totalFacturadoCliente(LocalDate of, LocalDate of1, Cliente cliente) {
        List<ItemFactura> aux = new ArrayList<>();
        double auxiliar = 0;
        for(Factura e: facturas){
            if (e.getCliente().equals(cliente)){
                for(ItemFactura item : e.getItems()){
                    auxiliar += item.getPrecio();
                }
            }
        }
        return auxiliar;
    }

    public Factura agregarFactura(int numero, LocalDate fecha, Cliente cliente, Articulo articulo, int cantidad, boolean ctaCte) throws StockInsuficienteException, ArticuloRepetidoException, ClienteNuloException {
        if (cliente == null) {
            throw new ClienteNuloException("El cliente no puede ser nulo");
        }
        Factura factura = new Factura(numero, fecha, cliente, articulo, cantidad, ctaCte);
        facturas.add(factura);
        return factura;
    }
}
