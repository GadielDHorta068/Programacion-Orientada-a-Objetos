package org.deneb.tp2GUI.ejercicio4;

import java.awt.*;

class MiRectangulo extends MiFigura {
    private boolean relleno;

    public MiRectangulo() {
        this(0, 0, 0, 0, Color.BLACK, false);
    }


    public MiRectangulo(int x, int y, int width, int height, Color color, boolean relleno) {
        super(x, y, width, height, color);
        this.relleno = relleno;
    }

    public boolean isRelleno() { return relleno; }
    public void setRelleno(boolean relleno) { this.relleno = relleno; }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor());
        if (relleno) {
            g.fillRect(getX1(), getY1(), getX2(), getY2());
        } else {
            g.drawRect(getX1(), getY1(), getX2(), getY2());
        }
    }
}