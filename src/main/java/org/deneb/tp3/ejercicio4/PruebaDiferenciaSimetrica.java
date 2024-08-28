// PruebaConjuntos.java
package org.deneb.tp3.ejercicio4;

import junit.framework.TestCase;
import org.deneb.tp3.ejercicio4.algebra.*;

public class PruebaDiferenciaSimetrica extends TestCase {

	private final Conjunto a = new ConjuntoArreglo(5);
	private final Conjunto b = new ConjuntoArreglo(10);
	private Conjunto c;

	protected void setUp() throws Exception {
		a.agregarElemento(0);
		a.agregarElemento(2);
		a.agregarElemento(4);
		b.agregarElemento(4);
		b.agregarElemento(8);
	}

	public void testDiferenciaSimetrica_ab() {
		c = a.diferenciaSimetrica(b);
		assertEquals(3, c.cardinalidad());
		assertTrue(c.pertenece(0));
		assertTrue(c.pertenece(2));
		assertTrue(c.pertenece(8));
	}

	public void testDiferenciaSimetrica_ba() {
		c = a.diferenciaSimetrica(b);
		assertEquals(3, c.cardinalidad());
		assertTrue(c.pertenece(0));
		assertTrue(c.pertenece(2));
		assertTrue(c.pertenece(8));
	}

}
