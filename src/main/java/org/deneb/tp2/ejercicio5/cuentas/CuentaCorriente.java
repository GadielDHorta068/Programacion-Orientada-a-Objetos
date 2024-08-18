package org.deneb.tp2.ejercicio5.cuentas;

import org.deneb.tp2.ejercicio5.cuentas.CuentaBancaria;
import carlosfontela.cuentas.Cliente;

public class CuentaCorriente extends CuentaBancaria {

	private double descubierto;
	
	public CuentaCorriente (int numero, Cliente titular, double descubierto) {
		super (numero, titular);
		this.descubierto = descubierto;
	}

	public CuentaCorriente (int numero, Cliente titular) {
		super (numero, titular);
		this.descubierto = 0;
	}

	public boolean extraer (double monto) {
		if (monto > getSaldo() + descubierto)
			return false;
		else {
			setSaldo ( getSaldo() - monto );
			return true;
		}
	}

	@Override
	public void extraer() {

	}

	public double getDescubierto ( ) {
			return descubierto;
	}
	
	public void setDescubierto (double valor) {
			descubierto = valor;
	}
}
