package org.deneb.tp2.ejercicio2.inmobiliarias;

public class Campo extends Inmueble {

 private final String ciudad;
 private final int distancia;

    public Campo(String domicilio, double superficie, int cantidadAmbientes, int precio,
                String ciudad, int distancia) {
        super (domicilio, superficie, cantidadAmbientes, precio);
        this.ciudad = ciudad;
        this.distancia = distancia;
    }

    public void imprimirDatos( ) {
        super.imprimirDatos( );
        System.out.println ("Ciudad: " + getCiudad());
        System.out.println ("Jardin: " + getDistancia());
    }

    // nuevo m�todo:
    public double comisionVendedor( ) {
        if(distancia < 100){
            return 0.01 * getPrecio( );
        }
        return 0.005 * getPrecio( );
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getDistancia() {
        return distancia;
    }
}
