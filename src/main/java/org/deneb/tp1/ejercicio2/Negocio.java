package org.deneb.tp1.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Negocio {

    List<Articulo> stock = new ArrayList<Articulo>();
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
        float valor = 0;
        for (Articulo e : stock){
            valor += e.getPrecio();
        }
        return valor;
    }


}
