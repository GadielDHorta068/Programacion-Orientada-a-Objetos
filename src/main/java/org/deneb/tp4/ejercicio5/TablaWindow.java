package org.deneb.tp4.ejercicio5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import org.deneb.tp4.ejercicio5.employee.SalariedEmployee;

public class TablaWindow extends JFrame {
    private final DefaultTableModel tableModel;
    private final JTable employeeTable;

    public TablaWindow(List<SalariedEmployee> employees) {
        super("Lista de Empleados");
        setLayout(new BorderLayout());

        // Colores para el modo oscuro
        Color backgroundColor = new Color(30, 30, 35); // Color de fondo más oscuro
        Color foregroundColor = new Color(200, 200, 200); // Color de texto claro
        Color tableBackgroundColor = new Color(40, 30, 40); // Color de fondo de la tabla
        Color selectionBackgroundColor = new Color(70, 130, 180); // Color de selección azul
        Color buttonBackgroundColor = new Color(50, 50, 50); // Color de fondo de los botones

        String[] columnNames = {"Nombre", "Apellido", "DNI", "Salario Semanal", "Fecha"};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        actualizarTabla(employees);

        // Estilos para la tabla
        employeeTable.setBackground(tableBackgroundColor);
        employeeTable.setForeground(foregroundColor);
        employeeTable.setSelectionBackground(selectionBackgroundColor);
        employeeTable.setSelectionForeground(foregroundColor);
        employeeTable.setGridColor(new Color(80, 80, 80)); // Color de rejilla más oscuro
        employeeTable.setRowHeight(25);

        // Estilos para el header de la tabla
        employeeTable.getTableHeader().setBackground(backgroundColor);
        employeeTable.getTableHeader().setForeground(foregroundColor);
        employeeTable.getTableHeader().setFont(employeeTable.getTableHeader().getFont().deriveFont(Font.BOLD));

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.getViewport().setBackground(tableBackgroundColor);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(backgroundColor);

        // Botón para eliminar empleado
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(e -> eliminarEmpleado(employees));
        deleteButton.setBackground(buttonBackgroundColor);
        deleteButton.setForeground(foregroundColor);
        buttonPanel.add(deleteButton);

        // Botón para agregar empleado
        JButton addButton = new JButton("Agregar");
        addButton.addActionListener(e -> new GUI(this));
        addButton.setBackground(buttonBackgroundColor);
        addButton.setForeground(foregroundColor);
        buttonPanel.add(addButton);

        add(buttonPanel, BorderLayout.SOUTH); // Añadir el panel de botones al sur

        // Colores de fondo del frame
        getContentPane().setBackground(backgroundColor);

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
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar");
        }
    }

    public void actualizar(List<SalariedEmployee> employees) {
        actualizarTabla(employees);
    }

    public static void main(String[] args) {
        // Configuración de UIManager para mantener los colores oscuros en los diálogos
        UIManager.put("OptionPane.background", new Color(30, 30, 30));
        UIManager.put("Panel.background", new Color(30, 30, 30));
        UIManager.put("OptionPane.messageForeground", new Color(200, 200, 200));
        UIManager.put("Button.background", new Color(50, 50, 50));
        UIManager.put("Button.foreground", new Color(200, 200, 200));

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<SalariedEmployee> employees = new ArrayList<>();
        new TablaWindow(employees);
    }
}
