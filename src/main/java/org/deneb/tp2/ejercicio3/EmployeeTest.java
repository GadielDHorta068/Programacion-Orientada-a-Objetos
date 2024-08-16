package org.deneb.tp2.ejercicio3;

import org.deneb.tp2.ejercicio3.employee.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;

public class EmployeeTest {
    public static void main(String[] args) {

    }
    @Test
    public void testSalariedEmployeeSalaryOnBirthday() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, LocalDate.of(2000, 11, 1));
        Employee.additional = 100.00F;
        double expectedSalary = 900.00;
        double actualSalary = salariedEmployee.salary(LocalDate.of(2024, 11, 1));
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    public void testSalariedEmployeeSalaryNotOnBirthday() {
        SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00, LocalDate.of(2000, 11, 1));
        Employee.additional = 100.00F;
        double expectedSalary = 900.00;
        double actualSalary = salariedEmployee.salary(LocalDate.of(2024, 11, 15));
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    public void testHourlyEmployeeSalaryOnBirthday() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, LocalDate.of(2000, 11, 1));
        Employee.additional = 100.00F;
        double expectedSalary = 770.00;
        double actualSalary = hourlyEmployee.salary(LocalDate.of(2024, 11, 1));
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    public void testHourlyEmployeeSalaryNotOnBirthday() {
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40, LocalDate.of(2000, 11, 1));
        Employee.additional = 100.00F;
        double expectedSalary = 770.00;
        double actualSalary = hourlyEmployee.salary(LocalDate.of(2024, 11, 15));
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    public void testCommissionEmployeeSalaryOnBirthday() {
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.06, LocalDate.of(2000, 11, 1));
        Employee.additional = 100.00F;
        double expectedSalary = 700.00;
        double actualSalary = commissionEmployee.salary(LocalDate.of(2024, 11, 1));
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    public void testCommissionEmployeeSalaryNotOnBirthday() {
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.06, LocalDate.of(2000, 11, 1));
        Employee.additional = 100.00F;
        double expectedSalary = 700.00;
        double actualSalary = commissionEmployee.salary(LocalDate.of(2024, 11, 15));
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    public void testBasePlusCommissionEmployeeSalaryOnBirthday() {
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, 0.04, 300, LocalDate.of(2000, 11, 1));
        Employee.additional = 100.00F;
        double expectedSalary = 600;
        double actualSalary = basePlusCommissionEmployee.salary(LocalDate.of(2024, 11, 1));
        assertEquals(expectedSalary, actualSalary, 0.01);
    }

    @Test
    public void testBasePlusCommissionEmployeeSalaryNotOnBirthday() {
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, 0.04, 300, LocalDate.of(2000, 11, 1));
        Employee.additional = 100.00F;
        double expectedSalary = 600.00;
        double actualSalary = basePlusCommissionEmployee.salary(LocalDate.of(2024, 11, 15));
        assertEquals(expectedSalary, actualSalary, 0.01);
    }
}