package org.deneb.tp4.ejercicio5;

import org.deneb.stylusUI.StylusUI;
import org.deneb.tp4.ejercicio5.employee.SalariedEmployee;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

public class Form extends JFrame {
    private final JTextField nombre;
    private final JTextField apellido;
    private final JTextField documento;
    private final JTextField salario;
    private final JTextField fechaNacimiento;
    private final JLabel nombreError;
    private final JLabel apellidoError;
    private final JLabel documentoError;
    private final JLabel salarioError;
    private final JLabel nacimientoError;
    private final TablaWindow employeeTableWindow;

    public Form(List<SalariedEmployee> employees, TablaWindow tableWindow) {
        super("Gestionar Empleado Asalariado");
        this.employeeTableWindow = tableWindow;

        setUndecorated(true);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        StylusUI.aplicarEstiloPanel((JPanel) getContentPane());
        getContentPane().setBackground(StylusUI.COLOR_TERCIARIO);


        // Comienzo construcción grilla
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel nombreLabel = new JLabel("Nombre:");
        StylusUI.aplicarEstiloEtiqueta(nombreLabel);
        add(nombreLabel, gbc);
        nombre = new JTextField(15);
        StylusUI.aplicarEstiloCampoTexto(nombre);
        gbc.gridx = 1;
        add(nombre, gbc);

        nombreError = new JLabel();
        nombreError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(nombreError, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel apellidoLabel = new JLabel("Apellido:");
        StylusUI.aplicarEstiloEtiqueta(apellidoLabel);
        add(apellidoLabel, gbc);
        apellido = new JTextField(15);
        StylusUI.aplicarEstiloCampoTexto(apellido);
        gbc.gridx = 1;
        add(apellido, gbc);

        apellidoError = new JLabel();
        apellidoError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(apellidoError, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        JLabel documentoLabel = new JLabel("DNI:");
        StylusUI.aplicarEstiloEtiqueta(documentoLabel);
        add(documentoLabel, gbc);
        documento = new JTextField(15);
        StylusUI.aplicarEstiloCampoTexto(documento);
        gbc.gridx = 1;
        add(documento, gbc);

        documentoError = new JLabel();
        documentoError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(documentoError, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel salarioLabel = new JLabel("Salario Semanal:");
        StylusUI.aplicarEstiloEtiqueta(salarioLabel);
        add(salarioLabel, gbc);
        salario = new JTextField(15);
        StylusUI.aplicarEstiloCampoTexto(salario);
        gbc.gridx = 1;
        add(salario, gbc);

        salarioError = new JLabel();
        salarioError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(salarioError, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        JLabel fechaNacimientoLabel = new JLabel("Fecha (aaaa-mm-dd):");
        StylusUI.aplicarEstiloEtiqueta(fechaNacimientoLabel);
        add(fechaNacimientoLabel, gbc);
        fechaNacimiento = new JTextField(15);
        StylusUI.aplicarEstiloCampoTexto(fechaNacimiento);
        gbc.gridx = 1;
        add(fechaNacimiento, gbc);

        nacimientoError = new JLabel();
        nacimientoError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(nacimientoError, gbc);

        JButton addButton = new JButton("Agregar/Modificar");
        StylusUI.aplicarEstiloBoton(addButton, true);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(addButton, gbc);

        JButton cancelButton = new JButton("Cancelar");
        StylusUI.aplicarEstiloBoton(cancelButton,true);
        gbc.gridx = 1;
        add(cancelButton, gbc);

        addButton.addActionListener(e -> {
            boolean valid = validarAgregarOModificar(employees);
            if (valid) {
                setVisible(false);
                employeeTableWindow.actualizar(employees);
            }
            pack();
        });

        cancelButton.addActionListener(e -> setVisible(false));

        // Fin de armado de la grilla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setOpacity(0.9f);
        setBackground(getBackground().brighter());
        setVisible(true);
    }

    private boolean validarAgregarOModificar(List<SalariedEmployee> employees) {
        nombreError.setText("");
        apellidoError.setText("");
        documentoError.setText("");
        salarioError.setText("");
        nacimientoError.setText("");

        boolean isValid = true;
        String firstName = nombre.getText().trim();
        String lastName = apellido.getText().trim();
        String ssn = documento.getText().trim();
        String salary = salario.getText().trim();
        String date = fechaNacimiento.getText().trim();

        // Validar nombre
        if (!Pattern.matches("^[A-Z][a-zA-Z]*$", firstName)) {
            nombreError.setText("Nombre inválido");
            isValid = false;
        }

        // Validar apellido
        if (!Pattern.matches("^[A-Z][a-zA-Z]*$", lastName)) {
            apellidoError.setText("Apellido inválido");
            isValid = false;
        }

        // Validar DNI
        if (!Pattern.matches("^\\d{3}-\\d{2}-\\d{4}$", ssn)) {
            documentoError.setText("Documento inválido");
            isValid = false;
        }

        // Validar salario
        if (!Pattern.matches("^\\d+(\\.\\d{1,2})?$", salary)) {
            salarioError.setText("Salario inválido");
            isValid = false;
        }

        // Validar fecha
        if (!Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", date)) {
            nacimientoError.setText("Fecha inválida");
            isValid = false;
        }

        if (isValid) {
            double weeklySalary = Double.parseDouble(salary);
            LocalDate localDate = LocalDate.parse(date);
            SalariedEmployee existingEmployee = buscarEmpleadoPorDNI(ssn, employees);

            if (existingEmployee == null) {
                // Agregar empleado si no existe
                SalariedEmployee employee = new SalariedEmployee(firstName, lastName, ssn, weeklySalary, localDate);
                employees.add(employee);
                if (employeeTableWindow != null) {
                    employeeTableWindow.actualizar(employees);
                }
                JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente");
            } else {
                // Modificar empleado existente
                existingEmployee.setFirstName(firstName);
                existingEmployee.setLastName(lastName);
                existingEmployee.setWeeklySalary(weeklySalary);
                existingEmployee.setBirthDate(localDate);
                if (employeeTableWindow != null) {
                    employeeTableWindow.actualizar(employees);
                }
                JOptionPane.showMessageDialog(this, "Empleado modificado exitosamente");
            }
        }

        return isValid; // Retornar si es válido o no
    }

    private SalariedEmployee buscarEmpleadoPorDNI(String ssn, List<SalariedEmployee> employees) {
        for (SalariedEmployee employee : employees) {
            if (employee.getSSN().equals(ssn)) {
                return employee;
            }
        }
        return null;
    }
}
