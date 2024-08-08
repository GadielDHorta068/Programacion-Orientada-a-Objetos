package org.deneb.tp1.ejercicio3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Negocio {

    List<Articulo> stock = new ArrayList<Articulo>();
    List<Factura> facturas = new ArrayList<Factura>();
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

    public double totalFacturadoEntre(Date inicio, Date fin){
        double auxiliar = 0;
        for(Factura e: facturas){
          //  if(inicio >e.getFecha() > fin){
                for(ItemFactura item : e.getItems()){
                    auxiliar += item.getPrecio();
                }
          //  }
        }
        return auxiliar;
    }

    public double totalFechaCliente(Cliente cliente, Date inicio, Date fin){
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
}
