package org.deneb.tp2GUI.ejercicio2.modelo;

import java.awt.*;
import java.util.Objects;

public abstract class MiFigura {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;

    public MiFigura() {
        this(0, 0, 0, 0, Color.BLACK);
    }

    public MiFigura(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public int getX1() { return x1; }
    public int getY1() { return y1; }
    public int getX2() { return x2; }
    public int getY2() { return y2; }
    public Color getColor() { return color; }

    public void setX1(int x1) { this.x1 = x1; }
    public void setY1(int y1) { this.y1 = y1; }
    public void setX2(int x2) { this.x2 = x2; }
    public void setY2(int y2) { this.y2 = y2; }
    public void setColor(Color color) { this.color = color; }

    public abstract void dibujar(Graphics g);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MiFigura miFigura = (MiFigura) o;
        return x1 == miFigura.x1 && y1 == miFigura.y1 && x2 == miFigura.x2 && y2 == miFigura.y2 && Objects.equals(color, miFigura.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, y1, x2, y2, color);
    }

    @Override
    public String toString() {
        return STR."MiFigura x1: \{x1} x2: \{x2} y1: \{y1} y2: \{y2}";
    }
}