package org.deneb.tp2.ejercicio5.cuentas;
import org.deneb.tp2.ejercicio5.cuentas.Cliente;
public class CajaAhorro extends CuentaBancaria {
	
	private double interesesGanados;

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
