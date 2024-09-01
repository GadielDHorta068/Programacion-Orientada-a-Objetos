package org.deneb.tp2.ejercicio5.cuentas;
import org.deneb.tp2.ejercicio5.cuentas.CuentaBancaria;

public abstract class CuentaBancaria {

	private int numero;
	private Cliente titular;
	private double saldo;

	public CuentaBancaria (int numero, Cliente titular) {

			this.numero = numero;
			this.titular = titular;
			this.saldo = 0;
			titular.agregarCuenta(this);
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

	public abstract void extraer(double monto) throws SaldoInsuficienteException;

	public abstract  double saldoDisponible();

}
