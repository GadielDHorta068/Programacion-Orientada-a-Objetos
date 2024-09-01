package org.deneb.tp4.ejercicio5;

import org.deneb.tp4.ejercicio5.employee.SalariedEmployee;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GUI extends JFrame {
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
    private final List<SalariedEmployee> employees;
    private TablaWindow employeeTableWindow;

    public GUI() {
        super("Gestionar Empleado Asalariado");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        employees = new ArrayList<>();

        // Comienzo construccion grilla
        gbc.gridx = 0; gbc.gridy = 0;

        add(new JLabel("Nombre:"), gbc);
        nombre = new JTextField(15);
        gbc.gridx = 1;
        add(nombre, gbc);

        nombreError = new JLabel();
        nombreError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(nombreError, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Apellido:"), gbc);
        apellido = new JTextField(15);
        gbc.gridx = 1;
        add(apellido, gbc);

        apellidoError = new JLabel();
        apellidoError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(apellidoError, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("DNI:"), gbc);
        documento = new JTextField(15);
        gbc.gridx = 1;
        add(documento, gbc);

        documentoError = new JLabel();
        documentoError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(documentoError, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Salario Semanal:"), gbc);
        salario = new JTextField(15);
        gbc.gridx = 1;
        add(salario, gbc);

        salarioError = new JLabel();
        salarioError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(salarioError, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Fecha (aaaa-mm-dd):"), gbc);
        fechaNacimiento = new JTextField(15);
        gbc.gridx = 1;
        add(fechaNacimiento, gbc);

        nacimientoError = new JLabel();
        nacimientoError.setForeground(Color.RED);
        gbc.gridx = 2;
        add(nacimientoError, gbc);

        JButton addButton = new JButton("Agregar/Modificar");
        gbc.gridx = 1; gbc.gridy = 5;
        add(addButton, gbc);

        addButton.addActionListener(e -> {
            validarAgregarOModificar();
            pack();
        });

        // Botón para abrir la ventana de la tabla de empleados
        JButton showTableButton = new JButton("Mostrar Empleados");
        gbc.gridx = 1; gbc.gridy = 6;
        add(showTableButton, gbc);

        showTableButton.addActionListener(e -> mostrarTabla());

        // Fin de armado de la grilla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void mostrarTabla() {
        if (employeeTableWindow == null || !employeeTableWindow.isVisible()) {
            employeeTableWindow = new TablaWindow(employees);
            employeeTableWindow.setVisible(true);
        } else {
            employeeTableWindow.actualizar(employees);
            employeeTableWindow.toFront();
        }
    }

    private void validarAgregarOModificar() {
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

        if (!Pattern.matches("^[A-Z][a-zA-Z]*$", firstName)) {
            nombreError.setText("Nombre inválido");
            isValid = false;
        }

        if (!Pattern.matches("^[A-Z][a-zA-Z]*$", lastName)) {
            apellidoError.setText("Apellido inválido");
            isValid = false;
        }

        if (!Pattern.matches("^\\d{3}-\\d{2}-\\d{4}$", ssn)) {
            documentoError.setText("Documento inválido");
            isValid = false;
        }

        if (!Pattern.matches("^\\d+(\\.\\d{1,2})?$", salary)) {
            salarioError.setText("Salario inválido");
            isValid = false;
        }

        if (!Pattern.matches("^\\d{4}-\\d{2}-\\d{2}$", date)) {
            nacimientoError.setText("Fecha inválida");
            isValid = false;
        }

        if (isValid) {
            double weeklySalary = Double.parseDouble(salary);
            LocalDate localDate = LocalDate.parse(date);
            SalariedEmployee existingEmployee = buscarEmpleadoPorDNI(ssn);

            if (existingEmployee == null) {
                SalariedEmployee employee = new SalariedEmployee(firstName, lastName, ssn, weeklySalary, localDate);
                employees.add(employee);
                if (employeeTableWindow != null) {
                    employeeTableWindow.actualizar(employees);
                }
                JOptionPane.showMessageDialog(this, "Empleado agregado exitosamente");
            } else {
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
    }

    private SalariedEmployee buscarEmpleadoPorDNI(String ssn) {
        for (SalariedEmployee employee : employees) {
            if (employee.getSSN().equals(ssn)) {
                return employee;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        new GUI();
    }
}