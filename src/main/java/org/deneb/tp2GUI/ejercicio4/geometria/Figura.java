// Figura.java
package org.deneb.tp2GUI.ejercicio4.geometria;

import java.awt.*;

public abstract class Figura {
	protected Color color = Color.BLACK;
	protected boolean relleno = false;
	public abstract double area ( );
	public abstract double perimetro ( );
	public abstract String tipo( );
	public abstract void trasladar (double deltaX, double deltaY);
	public abstract void dibujar(Graphics g);
	public abstract void setColor(Color color);
}
