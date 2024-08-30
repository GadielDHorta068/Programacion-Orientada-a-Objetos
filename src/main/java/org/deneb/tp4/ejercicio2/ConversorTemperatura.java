package org.deneb.tp4.ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConversorTemperatura extends JFrame {
    private JTextField campoFahrenheit;
    private JTextField campoCelsius;

    public ConversorTemperatura() {
        super("Conversión de Temperatura");

        // Configurar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLayout(new GridLayout(2, 2));

        // Crear componentes
        JLabel etiquetaFahrenheit = new JLabel("Fahrenheit:");
        campoFahrenheit = new JTextField();
        JLabel etiquetaCelsius = new JLabel("Celsius:");
        campoCelsius = new JTextField();

        // Agregar componentes al JFrame
        add(etiquetaFahrenheit);
        add(campoFahrenheit);
        add(etiquetaCelsius);
        add(campoCelsius);

        // Añadir listeners para actualizar los campos en tiempo real
        campoFahrenheit.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                actualizarCelsius();
            }
        });

        campoCelsius.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                actualizarFahrenheit();
            }
        });

        // Mostrar la ventana
        setVisible(true);
    }

    private void actualizarCelsius() {
        String textoFahrenheit = campoFahrenheit.getText();
        try {
            if (!textoFahrenheit.isEmpty()) {
                double fahrenheit = Double.parseDouble(textoFahrenheit);
                double celsius = Conversion.fahrenheitACelsius(fahrenheit);
                campoCelsius.setText(String.format("%.2f", celsius));
            } else {
                campoCelsius.setText("");
            }
        } catch (NumberFormatException ex) {
            campoCelsius.setText("");
        }
    }

    private void actualizarFahrenheit() {
        String textoCelsius = campoCelsius.getText();
        try {
            if (!textoCelsius.isEmpty()) {
                double celsius = Double.parseDouble(textoCelsius);
                double fahrenheit = Conversion.celsiusAFahrenheit(celsius);
                campoFahrenheit.setText(String.format("%.2f", fahrenheit));
            } else {
                campoFahrenheit.setText("");
            }
        } catch (NumberFormatException ex) {
            campoFahrenheit.setText("");
        }
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new ConversorTemperatura());
    }
}