package org.deneb.tp2GUI.ejercicio3;

import org.deneb.tp2GUI.ejercicio3.geometria.Figura;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelDibujo extends JPanel {
    List<Figura> figuras;

    public PanelDibujo(List<Figura> figuras){
        
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


        PanelDibujo panel = new PanelDibujo(figuras);
        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
