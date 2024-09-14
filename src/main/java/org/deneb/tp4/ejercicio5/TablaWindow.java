package org.deneb.tp4.ejercicio5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        employees = new ArrayList<>();

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
        StylusUI.aplicarEstiloBoton(deleteButton);
        deleteButton.addActionListener(e -> eliminarEmpleado(employees));
        buttonPanel.add(deleteButton);

        // Botón para agregar empleado
        JButton addButton = new JButton("Agregar");
        StylusUI.aplicarEstiloBoton(addButton);
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
               JOptionPane.showMessageDialog(this, "Empleado eliminado exitosamente");
            }
        } else {
        ///    JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar");
            SlidingDialog dialog = new SlidingDialog(this, "Mensaje", "sdsds");
            dialog.setVisible(true);
        }
    }

    public void actualizar(List<SalariedEmployee> employees) {
        actualizarTabla(employees);
    }

    public static void main(String[] args) {
        StylusUI.aplicarEstiloJOptionPane();
        List<SalariedEmployee> employees = new ArrayList<>();
        new TablaWindow();
    }

    public List<SalariedEmployee> getEmployees() {
        return employees;
    }
}
