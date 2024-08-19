package org.deneb.tp2GUI.ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FigurasRandom extends JPanel {

    private final MiFigura[] figuras;

    public FigurasRandom(int numLineas, int numOvalos, int numRectangulos) {
        Random random = new Random();
        figuras = new MiFigura[numLineas + numOvalos + numRectangulos];

        int index = 0;
        for (int i = 0; i < numLineas; i++) {
            int x1 = random.nextInt(500);
            int y1 = random.nextInt(500);
            int x2 = random.nextInt(500);
            int y2 = random.nextInt(500);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            figuras[index++] = new MiLinea(x1, y1, x2, y2, color);
        }

        for (int i = 0; i < numOvalos; i++) {
            int x = random.nextInt(500);
            int y = random.nextInt(500);
            int width = random.nextInt(250);
            int height = random.nextInt(250);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            boolean relleno = random.nextBoolean();
            figuras[index++] = new MiOvalo(x, y, width, height, color, relleno);
        }

        for (int i = 0; i < numRectangulos; i++) {
            int x = random.nextInt(500);
            int y = random.nextInt(500);
            int width = random.nextInt(250);
            int height = random.nextInt(250);
            Color color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            boolean relleno = random.nextBoolean();
            figuras[index++] = new MiRectangulo(x, y, width, height, color, relleno);
        }

        JLabel statusBar = new JLabel(STR."Líneas: \{numLineas}, Óvalos: \{numOvalos}, Rectángulos: \{numRectangulos}");
        setLayout(new BorderLayout());
        add(statusBar, BorderLayout.SOUTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (MiFigura figura : figuras) {
            figura.dibujar(g);
        }
    }

    public static void main() {
        JFrame frame = new JFrame("Figuras Random");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int numLineas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de lineas:"));
        int numOvalos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de ovalos:"));
        int numRectangulos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de rectangulos:"));

        frame.setSize(600, 600);

        FigurasRandom panel = new FigurasRandom(numLineas,numOvalos, numRectangulos);
        frame.add(panel);

        frame.setVisible(true);
    }
}