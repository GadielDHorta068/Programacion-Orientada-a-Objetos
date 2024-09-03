// FiguraCompuesta.java
package org.deneb.tp2GUI.ejercicio4.geometria;

import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class FiguraCompuesta extends Figura {

	private Figura[ ] componentes;
	
	public FiguraCompuesta (Figura[ ] componentes) {
		this.componentes = componentes;
	}

	public double area( ) {
		// TODO: hacer bien este método
		// esta es una simplificación que supone que no hay superposición entre componentes
		double superficie = 0;
		for (int i = 0; i < componentes.length; i++)
			superficie += componentes[i].area( );
		return superficie;
	}

	public double perimetro( ) {
		// TODO: hacer bien este método
		// esta es una simplificación que supone que no hay superposición entre componentes
		double perimetro = 0;
		for (int i = 0; i < componentes.length; i++)
			perimetro += componentes[i].perimetro( );
		return perimetro;
	}

	public String tipo( ) {
		return "figura compuesta";
	}

	public void trasladar (double deltaX, double deltaY) {
		for (int i = 0; i < componentes.length; i++)
			componentes[i].trasladar (deltaX, deltaY);
	}

	@Override
	public void dibujar(Graphics g) {

	}

	@Override
	public void setColor(Color color) {
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		for (Figura figura : componentes){
			string.append(figura.toString());
		}
		return string.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FiguraCompuesta that = (FiguraCompuesta) o;
		return Objects.deepEquals(componentes, that.componentes);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(componentes);
	}
}
