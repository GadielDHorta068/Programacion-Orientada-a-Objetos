package org.deneb.tp4.ejercicio5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import org.deneb.tp4.ejercicio5.employee.SalariedEmployee;

public class TablaWindow extends JFrame {
    private final DefaultTableModel tableModel;
    private final JTable employeeTable;

    public TablaWindow(List<SalariedEmployee> employees) {
        super("Lista de Empleados");
        setLayout(new BorderLayout());


        String[] columnNames = {"Nombre", "Apellido", "DNI", "Salario Semanal", "Fecha"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        actualizarTabla(employees);

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        // Botón para eliminar empleado
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> eliminarEmpleado(employees));
        add(deleteButton, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
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
                JOptionPane.showMessageDialog(this, "Empleado eliminado exitosamente");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar");
        }
    }

    public void actualizar(List<SalariedEmployee> employees) {
        actualizarTabla(employees);
    }
}