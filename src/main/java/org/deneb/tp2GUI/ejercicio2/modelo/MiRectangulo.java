package org.deneb.tp2GUI.ejercicio2.modelo;

import java.awt.*;

public class MiRectangulo extends MiFiguraDelimitada {

    public MiRectangulo() {
        this(0, 0, 0, 0, Color.BLACK, false);
    }


    public MiRectangulo(int x, int y, int width, int height, Color color, boolean relleno) {
        super(x, y, width, height, color, relleno);
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor());
        if (isRelleno()) {
            g.fillRect(getX1(), getY1(), getX2(), getY2());
        } else {
            g.drawRect(getX1(), getY1(), getX2(), getY2());
        }
    }
}