package org.deneb.tp1.ejercicio2.modelo;

import org.deneb.tp1.ejercicio3.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Negocio {

    private String cuil;
    private String nombre;

    List<Articulo> stock = new ArrayList<Articulo>();
    List<Factura> factura = new ArrayList<Factura>();


    public Negocio(String cuil, String nombre) {
        this.cuil = cuil;
        this.nombre = nombre;
    }

    /**
     * Cambia en un porcentaje el precio de todos los artículos del stock
     *
     * @param porcCambio: porcentaje de cambio de precio
     *
     */
    public void cambiarPrecio(double porcCambio){
        for (Articulo e : stock){
            e.setPrecio((float) ((e.getPrecio()/100) * porcCambio));
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
            valor += e.getPrecio();
        }
        return valor;
    }

    /**
     *
     * @param i int
     * @param articulo String
     * @param v double
     * @param i1 int
     * @return Articulo
     */
    public Articulo agregarArticulo(int i, String articulo, double v, int i1) {
        Articulo art = new Articulo(i,articulo,v, i1);
        stock.add(art);
        return art;
    }

    public Factura agregarFactura(int i, LocalDate of, Articulo des, int i1) throws StockInsuficienteException, ArticuloRepetidoException {
        return new Factura(i, of, des, i1);
    }


    public Cliente agregarCliente(int i, String nombre, String s, String s1, String s2) {
        return new Cliente(i,nombre,s,s1,s2);
    }
}
