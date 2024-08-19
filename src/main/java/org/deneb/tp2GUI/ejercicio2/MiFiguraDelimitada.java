package org.deneb.tp2GUI.ejercicio2;

import java.awt.*;

public class MiFiguraDelimitada extends MiFigura{

    private int x1, y1, x2, y2;
    private Color color;
    private Boolean relleno;

    public MiFiguraDelimitada() {
        this(0, 0, 0, 0, Color.BLACK, true);
    }

    public MiFiguraDelimitada(int x1, int y1, int x2, int y2, Color color, boolean isRellena) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.relleno = isRellena;
    }

    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public Color getColor() { return color; }
    public Boolean getRelleno() {return relleno;}

    public void setX1(int x1) { this.x1 = x1; }
    public void setY1(int y1) { this.y1 = y1; }
    public void setX2(int x2) { this.x2 = x2; }
    public void setY2(int y2) { this.y2 = y2; }
    public void setColor(Color color) { this.color = color; }
    public void setIsRelleno(Boolean b){this.relleno = b;}
    @Override
    public void dibujar(Graphics g) {

    }
}
