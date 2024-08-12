package org.deneb.tp1GUI.ejercicio2;
import javax.swing.*;
import java.awt.*;

public class Circulos extends JPanel {

    private int numberOfCircles;
    private int initialDiameter;
    private JCheckBox checkBox1;

    public Circulos(int numberOfCircles, int initialDiameter) {
        this.numberOfCircles = numberOfCircles;
        this.initialDiameter = initialDiameter;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int centerY = height / 2;

        // Dibujar los círculos concéntricos
        for (int i = 1; i <= numberOfCircles; i++) {
            int diameter = initialDiameter * i;
            int radius = diameter / 2;
            int x = centerX - radius;
            int y = centerY - radius;
            g.drawOval(x, y, diameter, diameter);
        }
    }

    public static void main(String[] args) {
        String numberOfCirclesStr = JOptionPane.showInputDialog("Ingrese la cantidad de círculos:");
        String initialDiameterStr = JOptionPane.showInputDialog("Ingrese el diámetro del primer círculo en píxeles:");

        int numberOfCircles = Integer.parseInt(numberOfCirclesStr);
        int initialDiameter = Integer.parseInt(initialDiameterStr);

        JFrame frame = new JFrame("Circulos Concentricos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Circulos panel = new Circulos(numberOfCircles, initialDiameter);

        frame.add(panel);

        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}