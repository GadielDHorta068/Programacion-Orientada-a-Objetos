package org.deneb.tp1GUI.ejercicio1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LineasPanel extends JPanel {

    public LineasPanel() {
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;

        g.drawLine(0, centerY, width, centerY);  // Línea horizontal
        g.drawLine(centerX, 0, centerX, height); // Línea vertical
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Ejercicio1 GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LineasPanel panel = new LineasPanel();

        frame.add(panel);

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}