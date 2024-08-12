package org.deneb.tp1GUI.ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FigurasRandom extends JPanel {

    private MiLinea[] lineas;
    private MiOvalo[] ovalos;
    private MiRectangulo[] rectangulos;
    private JLabel statusBar;

    public FigurasRandom() {
        Random random = new Random();

        int numLineas = 5 + random.nextInt(6); // Entre 5 y 10
        int numOvalos = 5 + random.nextInt(6);
        int numRectangulos = 5 + random.nextInt(6);

        lineas = new MiLinea[numLineas];
        ovalos = new MiOvalo[numOvalos];
        rectangulos = new MiRectangulo[numRectangulos];

        for (int i = 0; i < numLineas; i++) {
            int x1 = random.nextInt(500);
            int y1 = random.nextInt(500);
            int x2 = random.nextInt(500);
            int y2 = random.nextInt(500);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            lineas[i] = new MiLinea(x1, y1, x2, y2, color);
        }

        for (int i = 0; i < numOvalos; i++) {
            int x = random.nextInt(500);
            int y = random.nextInt(500);
            int width = random.nextInt(250);
            int height = random.nextInt(250);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            boolean relleno = random.nextBoolean();
            ovalos[i] = new MiOvalo(x, y, width, height, color, relleno);
        }

        for (int i = 0; i < numRectangulos; i++) {
            int x = random.nextInt(500);
            int y = random.nextInt(500);
            int width = random.nextInt(250);
            int height = random.nextInt(250);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            boolean relleno = random.nextBoolean();
            rectangulos[i] = new MiRectangulo(x, y, width, height, color, relleno);
        }

        statusBar = new JLabel("Líneas: " + numLineas + ", Óvalos: " + numOvalos + ", Rectángulos: " + numRectangulos);
        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MiLinea linea : lineas) {
            linea.dibujar(g);
        }

        for (MiOvalo ovalo : ovalos) {
            ovalo.dibujar(g);
        }

        for (MiRectangulo rectangulo : rectangulos) {
            rectangulo.dibujar(g);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Figuras Random");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        FigurasRandom panel = new FigurasRandom();
        frame.add(panel);

        frame.setVisible(true);
    }
}