package org.deneb.tp2.ejercicio2;

import org.deneb.tp2.ejercicio2.inmobiliarias.Campo;
import org.deneb.tp2.ejercicio2.inmobiliarias.Inmobiliaria;
import org.deneb.tp2.ejercicio2.inmobiliarias.Inmueble;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class InmobiliariaTest {
    // Returns the initial value of cantidadInmuebles when no properties are added
    @Test
    public void test_initial_value_no_properties() {
        Inmobiliaria inmobiliaria = new Inmobiliaria("Test", 1.0, 1.0);
        assertEquals(0, inmobiliaria.getCantidadInmuebles());
    }

    // Adding an Inmueble increases the cantidadInmuebles by 1
    @Test
    public void test_adding_inmueble_increases_cantidadInmuebles() {
        Inmobiliaria inmobiliaria = new Inmobiliaria("Test", 5.0, 5.0);
        Inmueble campo = new Campo("Chacra B&G", 100, 3 , 50000, "Madryn", 25);
        Inmueble inmueble = new Inmueble("Test Address", 100.0, 3, 100000) ;
        inmobiliaria.agregarInmueble(inmueble);
        inmobiliaria.agregarInmueble(campo);
        campo.imprimirDatos();
        assertEquals(2, inmobiliaria.getCantidadInmuebles());
    }

    // Remove an existing inmueble from the list
    @Test
    public void remove_existing_inmueble() {
        Inmobiliaria inmobiliaria = new Inmobiliaria("Test", 5.0, 5.0);
        Inmueble inmueble = new Inmueble("123 Street", 100.0, 3, 200000);
        inmobiliaria.agregarInmueble(inmueble);
        inmobiliaria.quitarInmueble(inmueble);
        assertEquals(0, inmobiliaria.getCantidadInmuebles());
    }

    // imprimirDatos prints the name of the inmobiliaria
    @Test
    public void test_imprimirDatos_prints_name() {
        Inmobiliaria inmobiliaria = new Inmobiliaria("Test Inmobiliaria", 5.0, 5.0);
        inmobiliaria.imprimirDatos();
    }

    // Returns the correct commission value when initialized with a positive value
    @Test
    public void returns_correct_commission_value_when_initialized_with_positive_value() {
        Inmobiliaria inmobiliaria = new Inmobiliaria("Test", 5.0, 3.0);
        assertEquals(5.0, inmobiliaria.getComisionClienteCompra(),5);
    }
}
