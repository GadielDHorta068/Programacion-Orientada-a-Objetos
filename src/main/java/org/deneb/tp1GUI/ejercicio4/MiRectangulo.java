package org.deneb.tp1GUI.ejercicio4;

import java.awt.*;

class MiRectangulo {
    private int x, y, width, height;
    private Color color;
    private boolean relleno;

    public MiRectangulo(int x, int y, int width, int height, Color color, boolean relleno) {
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
            g.fillRect(x, y, width, height);
        } else {
            g.drawRect(x, y, width, height);
        }
    }
}