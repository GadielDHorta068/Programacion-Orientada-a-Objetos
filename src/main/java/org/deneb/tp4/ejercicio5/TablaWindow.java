package org.deneb.tp4.ejercicio5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.deneb.stylusUI.MacOSWindowButtons;
import org.deneb.stylusUI.SlidingDialog;
import org.deneb.stylusUI.StylusUI;
import org.deneb.tp4.ejercicio5.employee.SalariedEmployee;

public class TablaWindow extends JFrame {
    private final DefaultTableModel tableModel;
    private final JTable employeeTable;
    public List<SalariedEmployee> employees;

    public TablaWindow() {
        super("Lista de Empleados");
        setLayout(new BorderLayout());
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);  // Elimina la decoración del sistema
        setUndecorated(true);
        MacOSWindowButtons macButtons = new MacOSWindowButtons(this);
        add(macButtons, BorderLayout.NORTH);
        employees = new ArrayList<>();

        employees.add(new SalariedEmployee("Carlos", "Fernández", "321-54-9876", 520.0, LocalDate.of(1985, 5, 15)));
        employees.add(new SalariedEmployee("Lucía", "Gómez", "654-32-1987", 580.0, LocalDate.of(1992, 3, 18)));
        employees.add(new SalariedEmployee("Juan", "Martínez", "789-01-2345", 610.0, LocalDate.of(1989, 7, 9)));
        employees.add(new SalariedEmployee("Elena", "Díaz", "234-56-7890", 540.0, LocalDate.of(1991, 12, 12)));
        employees.add(new SalariedEmployee("Javier", "Ruiz", "543-21-8765", 595.0, LocalDate.of(1987, 4, 25)));
        employees.add(new SalariedEmployee("Marta", "Sánchez", "876-54-3210", 560.0, LocalDate.of(1993, 9, 10)));
        employees.add(new SalariedEmployee("Pedro", "Hernández", "098-76-5432", 630.0, LocalDate.of(1986, 6, 20)));
        employees.add(new SalariedEmployee("Laura", "Lopez", "112-23-3445", 570.0, LocalDate.of(1994, 2, 2)));
        employees.add(new SalariedEmployee("David", "Ortiz", "223-34-4556", 620.0, LocalDate.of(1990, 11, 1)));
        employees.add(new SalariedEmployee("Sofía", "Moreno", "334-45-5667", 590.0, LocalDate.of(1988, 1, 15)));

        String[] columnNames = {"Nombre", "Apellido", "DNI", "Salario Semanal", "Fecha"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        StylusUI.aplicarEstiloTabla(employeeTable, true);
        actualizarTabla(employees);

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        StylusUI.aplicarEstiloPanel(buttonPanel);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Botón para eliminar empleado
        JButton deleteButton = new JButton("Eliminar");
        StylusUI.aplicarEstiloBoton(deleteButton, false);
        deleteButton.addActionListener(e -> eliminarEmpleado(employees));
        buttonPanel.add(deleteButton);

        // Botón para agregar empleado
        JButton addButton = new JButton("Agregar");
        StylusUI.aplicarEstiloBoton(addButton, false);
        addButton.addActionListener(e -> {
            Form form = new Form(getEmployees(), this);
            form.setVisible(true);
        });
        buttonPanel.add(addButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarTabla(List<SalariedEmployee> employees) {
        tableModel.setRowCount(0);
        for (SalariedEmployee employee : employees) {
            tableModel.addRow(new Object[]{
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSSN(),
                    employee.getWeeklySalary(),
                    employee.getBirthDate()
            });
        }
    }

    private void eliminarEmpleado(List<SalariedEmployee> employees) {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow >= 0) {
            String ssn = (String) tableModel.getValueAt(selectedRow, 2);
            SalariedEmployee employee = employees.stream()
                    .filter(e -> e.getSSN().equals(ssn))
                    .findFirst()
                    .orElse(null);

            if (employee != null) {
                employees.remove(employee);
                tableModel.removeRow(selectedRow);
                SlidingDialog dialog = new SlidingDialog(this, "Mensaje", "Empleado eliminado");
                dialog.setVisible(true);
            }
        } else {
            SlidingDialog dialog = new SlidingDialog(this, "Mensaje", "Seleccione un empleado para eliminar");
            dialog.setVisible(true);
        }
    }

    public void actualizar(List<SalariedEmployee> employees) {
        actualizarTabla(employees);
    }

    public static void main(String[] args) {
        List<SalariedEmployee> employees = new ArrayList<>();
        StylusUI.inicializar(true);
        new TablaWindow();
    }

    public List<SalariedEmployee> getEmployees() {
        return employees;
    }
}
