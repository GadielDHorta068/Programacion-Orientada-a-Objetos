package org.deneb.tp4.ejercicio3;
import org.deneb.stylusUI.StylusUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConversorTemperatura extends JFrame {
    private JTextField campoTemperatura1;
    private JTextField campoTemperatura2;
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;

    private static final String[] TEMPERATURAS = {"Grado Celsius", "Grado Fahrenheit", "Kelvin"};

    public ConversorTemperatura() {
        super("Conversión de Temperatura");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        campoTemperatura1 = new JTextField();
        campoTemperatura2 = new JTextField();
        comboBox1 = new JComboBox<>(TEMPERATURAS);
        comboBox2 = new JComboBox<>(TEMPERATURAS);

        comboBox1.setSelectedIndex(0);
        comboBox2.setSelectedIndex(1);

        campoTemperatura1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                convertirTemperatura(true);
            }
        });

        campoTemperatura2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                convertirTemperatura(false);
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirTemperatura(true);
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirTemperatura(false);
            }
        });

        // Agregar componentes al JFrame
        add(campoTemperatura1);
        add(campoTemperatura2);
        add(comboBox1);
        add(comboBox2);

        StylusUI.aplicarEstiloComboBox(comboBox1);
        StylusUI.aplicarEstiloComboBox(comboBox2);
        StylusUI.aplicarEstiloCampoTexto(campoTemperatura1);
        StylusUI.aplicarEstiloCampoTexto(campoTemperatura2);
        // Mostrar la ventana
        setVisible(true);
        pack();
    }

    private void convertirTemperatura(boolean esPrimero) {
        try {
            String tipo1 = (String) comboBox1.getSelectedItem();
            String tipo2 = (String) comboBox2.getSelectedItem();

            if (tipo1.equals(tipo2)) {
                if (esPrimero) {
                    campoTemperatura2.setText("");
                } else {
                    campoTemperatura1.setText("");
                }
                return;
            }

            if (esPrimero) {
                String textoTemperatura1 = campoTemperatura1.getText();
                if (!textoTemperatura1.isEmpty()) {
                    double temp1 = Double.parseDouble(textoTemperatura1);
                    double temp2 = Conversion.convertirTemperatura(temp1, tipo1, tipo2);
                    campoTemperatura2.setText(String.format("%.2f", temp2));
                } else {
                    campoTemperatura2.setText("");
                }
            } else {
                String textoTemperatura2 = campoTemperatura2.getText();
                if (!textoTemperatura2.isEmpty()) {
                    double temp2 = Double.parseDouble(textoTemperatura2);
                    double temp1 = Conversion.convertirTemperatura(temp2, tipo2, tipo1);
                    campoTemperatura1.setText(String.format("%.2f", temp1));
                } else {
                    campoTemperatura1.setText("");
                }
            }
        } catch (NumberFormatException ex) {
            if (esPrimero) {
                campoTemperatura2.setText("");
            } else {
                campoTemperatura1.setText("");
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(ConversorTemperatura::new);
    }
}