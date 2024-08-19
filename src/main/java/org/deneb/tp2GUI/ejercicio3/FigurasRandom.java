package org.deneb.tp2GUI.ejercicio3;

import org.deneb.tp2GUI.ejercicio3.geometria.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FigurasRandom extends JPanel {


    public FigurasRandom() {
        List<Figura> figuras = new ArrayList<>();
        
        Graphics g = null;
        new PanelDibujo(figuras, g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public static void main() {
        JFrame frame = new JFrame("Figuras Random");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 600);


        FigurasRandom panel = new FigurasRandom();
        frame.add(panel);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}