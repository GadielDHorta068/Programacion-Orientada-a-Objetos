package org.deneb.tp2.ejercicio5.cuentas;

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

	@Override
	public void extraer(double monto) throws SaldoInsuficienteException {
		if (monto > saldoDisponible()) {
			throw new SaldoInsuficienteException(monto);
		} else {
			super.setSaldo(getSaldo() - monto);
		}
	}

	@Override
	public double saldoDisponible() {
		return getSaldo() + descubierto;
	}

	public double getDescubierto ( ) {
			return descubierto;
	}
	
	public void setDescubierto (double valor) {
			descubierto = valor;
	}
}
