// Poligono.java
package org.deneb.tp2GUI.ejercicio3.geometria;

import java.awt.*;

public class Poligono extends Figura {

	private final Punto[ ] contorno;
	private boolean isRelleno;
	private Color relleno;

	public Poligono (Punto[ ] contorno) {
		if (contorno.length < 3)
			// veremos el significado de lo que sigue en un cap�tulo posterior:
			throw new IllegalArgumentException( );
		this.contorno = contorno;
		isRelleno = false;
		relleno = Color.black;
	}

	static protected double areaTrapecio (Punto p1, Punto p2) {
		return (p1.getY( ) + p2.getY( )) * (p2.getX( ) - p1.getX( )) / 2;
	}

	public int numeroLados( ) {
		return contorno.length;
	}

	public double area ( ) {
		double superficie =
			areaTrapecio (contorno [numeroLados( )-1], contorno[0]);
		for (int i = 0; i < numeroLados( )-1; i++)
			superficie += areaTrapecio (contorno[i], contorno[i+1]);
		return superficie;
	}

	public double perimetro ( ) {
		double longitud = contorno[numeroLados( )-1].distancia (contorno[0]);
		for (int i=0; i<numeroLados( )-1; i++)
			longitud += contorno[i].distancia (contorno[i+1]);
		return longitud;
	}

	private Segmento lado (int i) {
		if (i < numeroLados( )-1)
			return new Segmento(contorno[i], contorno[i+1]);
		else return new Segmento(contorno[i], contorno[0]);
	}

	// verifica si es un pol�gono con todos sus lados iguales
	public boolean regular( ) {
		for (int i = 0; i < contorno.length-1; i++) {
			if (lado(i).getLongitud( ) != lado(i+1).getLongitud( ))
				return false;
		}
		return true;
	}

	public String tipo( ) {
		if (numeroLados( ) == 3 && regular( ))
			return "tri�ngulo equil�tero";
		if (numeroLados( ) == 4 && regular( ))
			return "cuadrado";
		String nombre = null;
		switch (numeroLados( )) {
			case 3 : nombre = "tri�ngulo"; break;
			case 4 : nombre = "cuadril�tero"; break;
			case 5 : nombre = "pent�gono"; break;
			case 6 : nombre = "hex�gono"; break;
			case 7 : nombre = "hept�gono"; break;
			case 8 : nombre = "oct�gono"; break;
			case 9 : nombre = "non�gono"; break;
			case 10 : nombre = "dec�gono"; break;
			case 12 : nombre = "dodec�gono"; break;
			case 20 : nombre = "icos�gono"; break;
			default : nombre = "sin nombre";
		}
		if (regular( ))
			nombre += " regular";
		return nombre;
	}

	public void trasladar (double deltaX, double deltaY) {
		for (int i = 0; i < contorno.length; i++)
			contorno[i].trasladar (deltaX, deltaY);
	}

	@Override
	public void setColor(Color color) {
		relleno = color;
	}

	public boolean isRelleno() {
		return isRelleno;
	}

	public void setRelleno(boolean relleno) {
		isRelleno = relleno;
	}

	public Color getRelleno() {
		return relleno;
	}

	public void setRelleno(Color relleno) {
		this.relleno = relleno;
	}

	@Override
	public void dibujar(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);

		int[] xPoints = new int[contorno.length];
		int[] yPoints = new int[contorno.length];

		for (int i = 0; i < contorno.length; i++) {
			xPoints[i] = (int) contorno[i].getX();
			yPoints[i] = (int) contorno[i].getY();
		}

		Polygon polygon = new Polygon(xPoints, yPoints, contorno.length);

		if (isRelleno) {
			g2d.fillPolygon(polygon);
		} else {
			g2d.drawPolygon(polygon);
		}
	}
}
