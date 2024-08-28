// Notificable.java
package org.deneb.tp3.ejercicio3.inmobiliaria;

public interface Notificable {
	String getNombre( );
	void avisarCambioPrecio (Inmueble x, int nuevoPrecio);
	void avisarReserva (Inmueble x);
	void avisarVenta (Inmueble x);
	void avisarRetiroVenta(Inmueble x);
}
