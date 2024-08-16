package org.deneb.tp1GUI.ejercicio3;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FigurasRandom extends JPanel {

    private Random random;

    public FigurasRandom() {
        random = new Random();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Obtener el tamaño del panel
        int width = getWidth();
        int height = getHeight();


        for (int i = 0; i < 1000; i++) {
            boolean drawRectangle = random.nextBoolean();

            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            Color randomColor = new Color(red, green, blue);

            g2d.setColor(randomColor);

            int shapeWidth = random.nextInt(width / 2);
            int shapeHeight = random.nextInt(height / 2);
            int x = random.nextInt(width - shapeWidth);
            int y = random.nextInt(height - shapeHeight);

            if (drawRectangle) {
                g2d.fillRect(x, y, shapeWidth, shapeHeight);
            } else {
                g2d.fillOval(x, y, shapeWidth, shapeHeight);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ejercicio3 figuras random");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FigurasRandom panel = new FigurasRandom();

        frame.add(panel);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}