package org.deneb.tp2.ejercicio5.cuentas;
import org.deneb.tp2.ejercicio5.cuentas.Cliente;
public class CajaAhorro extends CuentaBancaria {
	
	private double interesesGanados;

	public CajaAhorro (int numero, Cliente titular) {
		super (numero, titular);
		this.interesesGanados = 0;
	}

	@Override
	public void extraer(double monto) throws  SaldoInsuficienteException{
		if (monto > super.getSaldo()) {
			throw new SaldoInsuficienteException(monto);
		} else {
			super.setSaldo(getSaldo() - monto);
		}
	}

	@Override
	public double saldoDisponible() {
		return getSaldo();
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
