package org.deneb.tp2.ejercicio1;

import org.deneb.tp2.ejercicio3.employee.BasePlusCommissionEmployee;
import org.deneb.tp2.ejercicio3.employee.CommissionEmployee;
import org.deneb.tp2.ejercicio3.employee.HourlyEmployee;
import org.deneb.tp2.ejercicio3.employee.SalariedEmployee;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


public class TestEmployee {

    @Test
    public void testSalariedEmployee() {
        SalariedEmployee employee = new SalariedEmployee("Gordo", "Dan", "111-11-1111", 800.00, LocalDate.of(2000, 11, 1));
        assertEquals(800.00, employee.earnings(), 0.01);
    }

    @Test
    public void testHourlyEmployee() {
        HourlyEmployee employee = new HourlyEmployee("Emperador", "Alex", "222-22-2222", 16.75, 40, LocalDate.of(2000, 11, 1));
        assertEquals(670.00, employee.earnings(), 0.01);
    }

    @Test
    public void testCommissionEmployee() {
        CommissionEmployee employee = new CommissionEmployee("Susana", "horia", "333-33-3333", 10000, .06, LocalDate.of(2000, 11, 1));
        assertEquals(600.00, employee.earnings(), 0.01);
    }

    @Test
    public void testBasePlusCommissionEmployee() {
        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300, LocalDate.of(2000, 11, 1));
        assertEquals(500.00 + 300.00, employee.earnings(), 0.01);

        employee.setBaseSalary(330);
        assertEquals(500.00 + 330.00, employee.earnings(), 0.01);
    }
}