package org.deneb.tp2.ejercicio5.cuentas;
import org.deneb.tp2.ejercicio5.cuentas.CuentaBancaria;

public abstract class CuentaBancaria {

	private int numero;
	private Cliente titular;
	private double saldo;

	public CuentaBancaria (int numero, Cliente titular) {
		boolean ok = titular.agregarCuenta(this);
		if (ok) {
			this.numero = numero;
			this.titular = titular;
			this.saldo = 0;
		}
		// veremos el significado de lo que sigue en un capítulo posterior:
		else throw new IllegalArgumentException( );
	}

	public int getNumero ( ) {
			return numero;
	}

	public Cliente getTitular ( ){
			return titular;
	}

	public double getSaldo ( ) {
			return saldo;
	}

	protected void setSaldo (double saldo) {
		this.saldo = saldo;
	}

	public void depositar (double monto) {
		saldo += monto;
	}

	public abstract boolean extraer(double monto);

}
