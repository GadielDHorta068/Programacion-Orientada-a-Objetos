package org.deneb.tp2GUI.ejercicio4;

import java.awt.*;

class MiOvalo extends MiFigura {
    private boolean relleno;

    public MiOvalo() {
        this(0, 0, 0, 0, Color.BLACK, false);
    }

    public MiOvalo(int x, int y, int width, int height, Color color, boolean relleno) {
        super(x, y, width, height, color);
        this.relleno = relleno;
    }

    public boolean isRelleno() { return relleno; }
    public void setRelleno(boolean relleno) { this.relleno = relleno; }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(getColor());
        if (relleno) {
            g.fillOval(getX1(), getY1(), getX2(), getY2());
        } else {
            g.drawOval(getX1(), getY1(), getX2(), getY2());
        }
    }
}