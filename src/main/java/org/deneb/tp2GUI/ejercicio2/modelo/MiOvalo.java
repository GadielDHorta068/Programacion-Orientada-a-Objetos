package org.deneb.tp2GUI.ejercicio2.modelo;

import java.awt.*;

public class MiOvalo extends MiFiguraDelimitada {

    public MiOvalo() {
        this(0, 0, 0, 0, Color.BLACK, false);
    }

    public MiOvalo(int x, int y, int width, int height, Color color, boolean relleno) {
        super(x, y, width, height, color, relleno);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor());
        if (isRelleno()) {
            g.fillOval(getX1(), getY1(), getX2(), getY2());
        } else {
            g.drawOval(getX1(), getY1(), getX2(), getY2());
        }
    }
}