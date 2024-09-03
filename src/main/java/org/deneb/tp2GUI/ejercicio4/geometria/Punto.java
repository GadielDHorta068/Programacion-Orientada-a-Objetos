// Punto.java

package org.deneb.tp2GUI.ejercicio4.geometria;

import java.util.Objects;

public class Punto {

		// atributos:
		private double coordX;
		private double coordY;

		// constructor:
		public Punto (double x, double y) {
			coordX = x;
			coordY = y;
		}

		// propiedades de lectura y escritura:

		public double getX( ) {
			return coordX;
		}

		public void setX (double valor) {
			coordX = valor;
		}

		public double getY( ) {
			return coordY;
		}

		public void setY (double valor) {
			coordY = valor;
		}

		// métodos:

		public void trasladar (double deltaX, double deltaY) {
			coordX += deltaX;
			coordY += deltaY;
		}

		public double distancia (Punto otro) {
			return Math.sqrt
				( Math.pow((coordX-otro.coordX),2) +
					Math.pow((coordY-otro.coordY),2) );
		}
	
		public String toString( ) {
			return STR."\{new Double(getX()).toString()};\{new Double(getY()).toString()}";
		}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Punto punto = (Punto) o;
		return Double.compare(coordX, punto.coordX) == 0 && Double.compare(coordY, punto.coordY) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordX, coordY);
	}
}
