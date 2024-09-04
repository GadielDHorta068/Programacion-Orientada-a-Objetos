package org.deneb.parcial12021;

import org.deneb.parcial12021.delivery.Delivery;
import org.deneb.parcial12021.delivery.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PruebaDelivery {

	private static Delivery pedidosAhora;
	private static Negocio bomke;
	private static Producto bk1, bk2, bk3;
	private static Negocio bigDavid;
	private static Producto bd1, bd2;
	private static Cliente juan, ana;
	private static Repartidor pablo, maria;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		pedidosAhora = new Delivery("PedidosAhora");
		bomke = pedidosAhora.agregarNegocio("Bomke", "280 445 3221", "Av. Roca", 540, "30-11222444-4", 200);
		bk1 = bomke.agregarProducto(1, "Helado 1/4 Kg", 530);
		bk2 = bomke.agregarProducto(2, "Helado 1/2 Kg", 760);
		bk3 = bomke.agregarProducto(3, "Helado 1 Kg", 1350);

		bigDavid = pedidosAhora.agregarNegocio("Big David", "280 445 6549", "Brown", 5400, "30-33222555-5", 0);
		bd1 = bigDavid.agregarProducto(1, "Hamburguesa XL completa", 550);
		bd2 = bigDavid.agregarProducto(1, "Sandwich de Lomo", 600);

		juan = pedidosAhora.agregarCliente("Juan", "280 432 1234", "Gales", 251);
		ana = pedidosAhora.agregarCliente("Ana", "280 442 1332", "Moreno", 1435);

		Repartidor.setValorViaje(200);

		pablo = pedidosAhora.agregarRepartidor("Pablo", "280 423 4444");
		maria = pedidosAhora.agregarRepartidor("María", "280 423 3333");

		Pedido pedido1 = pedidosAhora.agregarPedido(bigDavid, juan, LocalDateTime.now(), "Dpto. 3");
		pedido1.agregarItem(bd2, 2);

		Pedido pedido2 = pedidosAhora.agregarPedido(bomke, ana, LocalDateTime.now(), "");
		pedido2.agregarItem(bk3, 1);

		pablo.agregarPedido(pedido1);
		pablo.agregarPedido(pedido2);

		Pedido pedido3 = pedidosAhora.agregarPedido(bomke, juan, LocalDateTime.now(), "");
		pedido3.agregarItem(bk2, 1);

		maria.agregarPedido(pedido3);

		List<PorPagar> pagos = new ArrayList<PorPagar>();
		pagos.add(pedido1);
		pagos.add(pedido2);
		pagos.add(pablo);
		pagos.add(pedido3);
		pagos.add(maria);

		for (PorPagar p : pagos)
			System.out.println("Pagos: " + p.calcularPago());

	}

}
