package org.deneb.tp4.ejercicio6;

import org.deneb.tp4.ejercicio5.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {

    public App() {
        super("Empresa");

        JMenuBar menuBar = new JMenuBar();

        JMenu menuEmpleados = new JMenu("Empleados");
        JMenu empresa = new JMenu("Empresa");

        JMenuItem menuItemSalariedEmployee = new JMenuItem("Empleado Asalariado");
        menuEmpleados.add(menuItemSalariedEmployee);

        menuBar.add(empresa);
        menuBar.add(menuEmpleados);
        setJMenuBar(menuBar);


        JPanel mainPanel = new JPanel(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);


        menuItemSalariedEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(new GUI().getContentPane(), BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new App();
    }
}