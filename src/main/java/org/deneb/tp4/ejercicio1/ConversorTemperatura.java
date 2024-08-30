package org.deneb.tp4.ejercicio1;

import javax.swing.*;
import java.awt.*;

public class ConversorTemperatura extends JFrame {
    private final JTextField campoFahrenheit;
    private final JLabel etiquetaResultado;

    public ConversorTemperatura() {
        super("Conversión de Temperatura");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));


        JLabel etiquetaFahrenheit = new JLabel("Fahrenheit:");
        campoFahrenheit = new JTextField();
        JButton botonCalcular = new JButton("Calcular");
        etiquetaResultado = new JLabel("Celsius: ");


        add(etiquetaFahrenheit);
        add(campoFahrenheit);
        add(etiquetaResultado);
        add(botonCalcular);

        botonCalcular.addActionListener(e -> calcularCelsius());


        setVisible(true);
    }

    private void calcularCelsius() {
        try {
            String textoFahrenheit = campoFahrenheit.getText();
            double fahrenheit = Double.parseDouble(textoFahrenheit);
            double celsius = Conversion.fahrenheitACelsius(fahrenheit);
            etiquetaResultado.setText(STR."Celsius: \{String.format("%.2f", celsius)}");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new ConversorTemperatura();
    }
}