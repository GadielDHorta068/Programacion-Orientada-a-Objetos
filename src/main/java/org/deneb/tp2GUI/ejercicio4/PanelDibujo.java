package org.deneb.tp2GUI.ejercicio4;

import org.deneb.tp2GUI.ejercicio4.geometria.Figura;
import org.deneb.tp2GUI.ejercicio4.geometria.Poligono;
import org.deneb.tp2GUI.ejercicio4.geometria.Punto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelDibujo extends JPanel {
    private final List<Figura> figuras;
    private int figuraSeleccionada = -1;
    private int paso = 10;

    public PanelDibujo(List<Figura> figuras){
        this.figuras = figuras;
        setLayout(new BorderLayout());
        JPanel botonesPanel = new JPanel();

        JTextField figuraField = new JTextField(5);
        botonesPanel.add(new JLabel("Figura:"));
        botonesPanel.add(figuraField);

        JButton colorButton = new JButton("Color");
        botonesPanel.add(colorButton);

        JTextField pasoField = new JTextField(String.valueOf(paso), 5);
        botonesPanel.add(new JLabel("Paso:"));
        botonesPanel.add(pasoField);

        JButton izquierdaButton = new JButton("Izquierda");
        JButton arribaButton = new JButton("Arriba");
        JButton abajoButton = new JButton("Abajo");
        JButton derechaButton = new JButton("Derecha");

        botonesPanel.add(izquierdaButton);
        botonesPanel.add(arribaButton);
        botonesPanel.add(abajoButton);
        botonesPanel.add(derechaButton);

        add(botonesPanel, BorderLayout.SOUTH);


        figuraField.addActionListener(e -> {
            try {
                int numFigura = Integer.parseInt(figuraField.getText());
                if (numFigura >= 0 && numFigura <= figuras.size()) {
                    figuraSeleccionada = numFigura - 1;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            }
        });

        colorButton.addActionListener(e -> {
            Color nuevoColor = JColorChooser.showDialog(this, "Seleccionar color", Color.BLUE);
            if (nuevoColor != null) {
                cambiarColor(nuevoColor);
                repaint();
            }
        });

        pasoField.addActionListener(e -> {
            try {
                paso = Integer.parseInt(pasoField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            }
        });

        izquierdaButton.addActionListener(e -> moverFigura(-paso, 0));
        derechaButton.addActionListener(e -> moverFigura(paso, 0));
        arribaButton.addActionListener(e -> moverFigura(0, -paso));
        abajoButton.addActionListener(e -> moverFigura(0, paso));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figura f : figuras) {
            f.dibujar(g);
        }
    }

    private void cambiarColor(Color color) {
        if (figuraSeleccionada == -1) {
            for (Figura f : figuras) {
                f.setColor(color);
            }
        } else {
            figuras.get(figuraSeleccionada).setColor(color);
        }
    }

    private void moverFigura(int deltaX, int deltaY) {
        if (figuraSeleccionada == -1) {
            for (Figura f : figuras) {
                f.trasladar(deltaX, deltaY);
            }
        } else {
            figuras.get(figuraSeleccionada).trasladar(deltaX, deltaY);
        }
        repaint();
    }

    public static void main() {
        JFrame frame = new JFrame("Figuras Random");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 600);

        List<Figura> figu = new ArrayList<>();
        Punto[] contornoTriangulo = {
                new Punto(50, 50),
                new Punto(100, 150),
                new Punto(150, 50)
        };
        Poligono triangulo = new Poligono(contornoTriangulo);
        triangulo.setColor(Color.RED);
        triangulo.setRelleno(true);

        Punto[] contornoCuadrado = {
                new Punto(200, 200),
                new Punto(300, 200),
                new Punto(300, 300),
                new Punto(200, 300)
        };
        Poligono cuadrado = new Poligono(contornoCuadrado);
        cuadrado.setColor(Color.BLUE);
        cuadrado.setRelleno(true);

        figu.add(cuadrado);
        figu.add(triangulo);

        PanelDibujo panel = new PanelDibujo(figu);
        frame.add(panel);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
