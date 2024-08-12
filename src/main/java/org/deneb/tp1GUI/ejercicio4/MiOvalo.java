package org.deneb.tp1GUI.ejercicio4;

import java.awt.*;

class MiOvalo {
    private int x, y, width, height;
    private Color color;
    private boolean relleno;

    public MiOvalo(int x, int y, int width, int height, Color color, boolean relleno) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.relleno = relleno;
    }

    public void dibujar(Graphics g) {
        g.setColor(color);
        if (relleno) {
            g.fillOval(x, y, width, height);
        } else {
            g.drawOval(x, y, width, height);
        }
    }
}
