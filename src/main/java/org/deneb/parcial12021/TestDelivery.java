package test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.deneb.parcial12021.delivery.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDelivery {

	private static Delivery pedidosAhora;
	private static Negocio bomke;
	private static Producto bk1, bk2, bk3;
	private static Negocio bigDavid;
	private static Producto bd1, bd2;
	private static Cliente juan, ana;
	private static Repartidor pablo, maria;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pedidosAhora = new Delivery("PedidosAhora");
		bomke = pedidosAhora.agregarNegocio("Bomke", "280 445 3221", "Av. Roca", 540, "30-11222444-4", 200);
		bk1 = bomke.agregarProducto(1, "Helado 1/4 Kg", 530);
		bk2 = bomke.agregarProducto(2, "Helado 1/2 Kg", 760);
		bk3 = bomke.agregarProducto(3, "Helado 1 Kg", 1350);

		bigDavid = pedidosAhora.agregarNegocio("Big David", "280 445 6549","Brown", 5400,"30-33222555-5", 0);
		bd1 = bigDavid.agregarProducto(1, "Hamburguesa XL completa", 550);
		bd2 = bigDavid.agregarProducto(1, "Sandwich de Lomo", 600);

		juan = pedidosAhora.agregarCliente("Juan", "280 432 1234", "Gales", 251);
		ana = pedidosAhora.agregarCliente("Ana", "280 442 1332", "Moreno", 1435);
		
		Repartidor.setValorViaje(200);		
		
		pablo = pedidosAhora.agregarRepartidor("Pablo", "280 423 4444");
		maria = pedidosAhora.agregarRepartidor("María", "280 423 3333");
				
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCobroCliente1() {
		Pedido pedido = pedidosAhora.agregarPedido(bigDavid, juan, LocalDateTime.now(), "Dpto. 3");
		pedido.agregarItem(bd2, 2);
		assertEquals(600.0 * 2, pedido.calcularPago(), 0.01);
	}
	
}
