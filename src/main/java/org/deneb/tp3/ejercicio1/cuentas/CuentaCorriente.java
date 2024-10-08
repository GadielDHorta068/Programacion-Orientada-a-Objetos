package org.deneb.tp3.ejercicio1.cuentas;

public class CuentaCorriente extends CuentaBancaria {

	private double descubierto;
	private static double comisionCC;

	public static double getComisionCC() {
		return comisionCC;
	}

	public static void setComisionCC(double comisionCC) {
		CuentaCorriente.comisionCC = comisionCC;
	}

	public CuentaCorriente (int numero, Cliente titular, double descubierto) {
		super (numero, titular);
		this.descubierto = descubierto;
	}

	public CuentaCorriente (int numero, Cliente titular) {
		super (numero, titular);
		this.descubierto = 0;
	}

	@Override
	public boolean extraer( double monto) {
		if (monto > super.getSaldo())
			return false;
		else {
			super.setSaldo(getSaldo() -monto);
			return true;
		}
	}

	public double getDescubierto ( ) {
			return descubierto;
	}
	
	public void setDescubierto (double valor) {
			descubierto = valor;
	}
}
