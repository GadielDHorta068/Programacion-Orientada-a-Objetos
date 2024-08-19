// Elipse.java
package org.deneb.tp2GUI.ejercicio3.geometria;

import java.awt.*;

public class Elipse extends Figura {

	private double radioMayor;
	private double radioMenor;
	private Punto centro;
	private double anguloRadioMayor;
	private Color color;

	public Elipse(double radioMayor, double radioMenor, Punto centro, double anguloRadioMayor) {
		this.radioMayor = radioMayor;
		this.radioMenor = radioMenor;
		this.centro = centro;
		this.anguloRadioMayor = anguloRadioMayor;
	}

	public Elipse(double radioMayor, double radioMenor) {
		this.radioMayor = radioMayor;
		this.radioMenor = radioMenor;
		this.centro = new Punto(0, 0);
		this.anguloRadioMayor = 0;
	}

	public double getRadioMayor() {
		return radioMayor;
	}

	public double getRadioMenor() {
		return radioMenor;
	}

	public Punto getCentro() {
		return centro;
	}

	public double getAnguloRadioMayor() {
		return anguloRadioMayor;
	}

	@Override
	public double area() {
		return Math.PI * getRadioMayor() * getRadioMenor();
	}

	@Override
	public double perimetro() {
		if (getRadioMayor() == getRadioMenor()) {
			return Math.PI * 2 * getRadioMayor();
		}
		double k = Math.sqrt(Math.pow(getRadioMayor(), 2) - Math.pow(getRadioMenor(), 2)) / Math.pow(getRadioMayor(), 2);
		return 4 * getRadioMayor() * E1(k);
	}

	private static double E1(double k) {
		return 0; // TODO: Tabla de integral el�ptica
	}

	@Override
	public String tipo() {
		if (getRadioMayor() == getRadioMenor())
			return "c�rculo";
		else
			return "elipse";
	}

	@Override
	public void trasladar(double deltaX, double deltaY) {
		centro.trasladar(deltaX, deltaY);
	}

	@Override
	public void dibujar(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(color);
		int x = (int) (centro.getX() - radioMayor);
		int y = (int) (centro.getY() - radioMenor);
		int width = (int) (2 * radioMayor);
		int height = (int) (2 * radioMenor);

		if (relleno) {
			g2d.fillOval(x, y, width, height);
		} else {
			g2d.drawOval(x, y, width, height);
		}
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
}
