package org.deneb.tp2GUI.ejercicio3;

import org.deneb.tp2GUI.ejercicio3.geometria.Figura;
import org.deneb.tp2GUI.ejercicio3.geometria.Poligono;
import org.deneb.tp2GUI.ejercicio3.geometria.Punto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PanelDibujo extends JPanel {
    private List<Figura> figuras;

    public PanelDibujo(List<Figura> figuras){
        this.figuras = figuras;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figura f : figuras) {
            f.dibujar(g);
        }
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

        // Segunda instancia de Poligono: un cuadrado
        Punto[] contornoCuadrado = {
                new Punto(200, 200),
                new Punto(300, 200),
                new Punto(300, 300),
                new Punto(200, 300)
        };
        Poligono cuadrado = new Poligono(contornoCuadrado);
        cuadrado.setColor(Color.BLUE);
        cuadrado.setRelleno(false);

        figu.add(cuadrado);
        figu.add(triangulo);

        PanelDibujo panel = new PanelDibujo(figu);
        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
