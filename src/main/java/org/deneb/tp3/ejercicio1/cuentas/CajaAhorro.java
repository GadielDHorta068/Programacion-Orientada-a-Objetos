package org.deneb.tp3.ejercicio1.cuentas;

public class CajaAhorro extends CuentaBancaria {
	
	private double interesesGanados;
	private static double comisionCA;

	public static double getComisionCA() {
		return comisionCA;
	}

	public static void setComisionCA(double comisionCA) {
		CajaAhorro.comisionCA = comisionCA;
	}

	public CajaAhorro (int numero, Cliente titular) {
		super (numero, titular);
		this.interesesGanados = 0;
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

	public double getInteresesGanados ( ) {
			return interesesGanados;
	}
	
	public void setInteresesGanados (double valor) {
			interesesGanados = valor;
		}

	public void pagarIntereses( ) {
		setSaldo ( getSaldo() + interesesGanados );
		interesesGanados = 0;
	}
}
