package org.deneb.parcial1.test;

import org.deneb.parcial1.modelo.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGasto {

    private Grupo viaje;
    private Persona juan, ana, pedro, lucia;
    public Gasto taxi, hostel, almuerzo, salida;
    private Pago pago1, pago2;

//BeforeEach me daba error al hacer el test, si cambio a before me anda
    @BeforeEach
    void setUp() throws Exception, PersonaRepetidaException {
        viaje = new Grupo("Viaje a Europa");
        juan = viaje.agregarIntegrante("Juan", "juan@gmail.com");
        ana = viaje.agregarIntegrante("Ana", "ana@gmail.com");
        pedro = viaje.agregarIntegrante("Pedro", "pedro@gmail.com");
        lucia = viaje.agregarIntegrante("Lucia", "lucia@gmail.com");

        taxi = viaje.agregarGasto(LocalDate.of(2024, 9, 4), "Taxi", juan);
        taxi.agregarDivision(juan, 2000);
        taxi.agregarDivision(ana, 2000);
        taxi.agregarDivision(pedro, 2000);
        taxi.agregarDivision(lucia, 2000);

        pago1 = viaje.agregarPago(LocalDate.of(2024, 9, 4), pedro, juan, 2000);

        hostel = viaje.agregarGasto(LocalDate.of(2024, 9, 4), "Hostel", ana);
        hostel.agregarDivision(juan, 10000);
        hostel.agregarDivision(ana, 10000);
        hostel.agregarDivision(pedro, 10000);
        hostel.agregarDivision(lucia, 10000);

        almuerzo = viaje.agregarGasto(LocalDate.of(2024, 9, 4), "Almuerzo", pedro);
        almuerzo.agregarDivision(juan, 5000);
        almuerzo.agregarDivision(ana, 3000);
        almuerzo.agregarDivision(pedro, 10000);

        salida = viaje.agregarGasto(LocalDate.of(2024, 9, 4), "Cerveza", pedro);
        salida.agregarDivision(juan, 4000);
        salida.agregarDivision(pedro, 8000);

        pago2 = viaje.agregarPago(LocalDate.of(2024, 9, 4), juan, pedro, 4000);
    }

    @Test
    public void testImportePagado() {
        System.out.println(almuerzo.toString());
        assertEquals(18000, almuerzo.importePagado(), 0.01);
        assertEquals(40000, hostel.importePagado(), 0.01);
        assertEquals(12000, salida.importePagado(), 0.01);
        assertEquals(8000, taxi.importePagado(), 0.01);
    }

    @Test
    public void testImporteGastado() {
        assertEquals(5000.0, almuerzo.importeGastado(juan));
        assertEquals(3000.0, almuerzo.importeGastado(ana));
        assertEquals(10000.0, hostel.importeGastado(juan));
        assertEquals(2000.0, taxi.importeGastado(pedro));
    }

    @Test
    public void testTotalPagado() {
        assertEquals(4000.0,viaje.totalPagado(juan));
        assertEquals(2000.0, viaje.totalPagado(pedro));
    }


    @Test
    public void testTotalGastado() {
        assertEquals(21000.0, viaje.totalGastado(juan));
        assertEquals(30000.0, viaje.totalGastado(pedro));
        assertEquals(15000.0, viaje.totalGastado(ana));
        assertEquals(12000.0, viaje.totalGastado(lucia));
    }

    @Test
    public void testDeudaEntrePersonas() {
        assertEquals(-5000.0, viaje.saldo(juan, pedro));
        assertEquals(-2000.0, viaje.saldo(pedro, juan));
    }

}