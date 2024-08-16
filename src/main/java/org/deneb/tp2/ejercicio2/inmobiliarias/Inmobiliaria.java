// Inmobiliaria.java
package org.deneb.tp2.ejercicio2.inmobiliarias;

import java.util.ArrayList;
import java.util.List;

public class Inmobiliaria {
	private final String nombre;
	private int cantidadInmuebles;
    private List<Inmueble> inmuebles;
	private final double comisionClienteCompra;	// atributo nuevo
	private final double comisionClienteVenta;		// atributo nuevo
		
	public Inmobiliaria (String nombre,
 			double comisionClienteCompra, double comisionClienteVenta) {
		this.nombre = nombre;
		this.inmuebles = new ArrayList<>(cantidadInmuebles);
		this.cantidadInmuebles = 0;
		// se agregaron dos l�neas:
		this.comisionClienteCompra = comisionClienteCompra;
		this.comisionClienteVenta = comisionClienteVenta;
}
		
	public String getNombre( ) {
		return nombre;
	}
		
	public int getCantidadInmuebles( ) {
		return cantidadInmuebles;
	}
		
	public void agregarInmueble (Inmueble x) {
        int maximoInmuebles = 100;
        if (cantidadInmuebles == maximoInmuebles) {
			System.out.println ("Se super� el m�ximo de inmuebles para esta inmobiliaria");
			return;
		}
		if (inmuebles.isEmpty())
			inmuebles = new ArrayList<>(maximoInmuebles);
		inmuebles.addLast(x);
		cantidadInmuebles++;
	}

	private int posicionInmueble (Inmueble x) {
		if (inmuebles == null)
			return -1;
		for (int pos = 0; pos < cantidadInmuebles; pos++)
			if (inmuebles.get(pos) == x)
				return pos;
		return -1;
	}

	public void quitarInmueble (Inmueble x) {
		int pos = posicionInmueble(x);
		if (pos > -1) {	// encontr� el inmueble
			// voy a eliminar el elemento del arreglo por compresi�n
			for (int i = pos; i < cantidadInmuebles-1; i++) {
				inmuebles.set(i, inmuebles.get(i + 1));
			}
			inmuebles.set(cantidadInmuebles - 1, null);
			cantidadInmuebles--;
		}
	}

	public void imprimirDatos ( ) {
		System.out.println ("Inmobiliaria: " + this.getNombre( ));
		if (inmuebles != null)
			for (int i = 0; i < cantidadInmuebles; i++)
				inmuebles.get(i).imprimirDatos( );
		System.out.println( );
	}

	// nueva propiedad:
	public double getComisionClienteCompra( ) {
		return comisionClienteCompra;
	}
	
	// nueva propiedad:
	public double getComisionClienteVenta( ) {
		return comisionClienteVenta;
	}

	// nuevo m�todo:
	public double beneficioEsperadoCartera( ) {
		double beneficio = 0;
		double comisionesCobradas =
 			(getComisionClienteCompra( ) + getComisionClienteVenta( )) / 100.0;
		for (int i = 0; i < cantidadInmuebles; i++) {
			int precio = inmuebles.get(i).getPrecio( );
			if (!inmuebles.get(i).getVendido( )) {
				beneficio += precio * comisionesCobradas
 						- inmuebles.get(i).comisionVendedor( );
			}
		}
		return beneficio;
	}

	// nuevo m�todo:
	public double beneficioEsperadoReservados( ) {
		double beneficio = 0;
		double comisionesCobradas =
 			(getComisionClienteCompra( ) + getComisionClienteVenta( )) / 100.0;
		for (int i = 0; i < cantidadInmuebles; i++) {
			int precio = inmuebles.get(i).getPrecio( );
			if (!inmuebles.get(i).getVendido( ) && inmuebles.get(i).getReservado( )) {
				beneficio += precio * comisionesCobradas
 						- inmuebles.get(i).comisionVendedor( );
			}
		}
		return beneficio;
	}
}
