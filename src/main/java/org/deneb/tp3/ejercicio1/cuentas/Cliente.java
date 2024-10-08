package org.deneb.tp3.ejercicio1.cuentas;

public abstract class Cliente implements OperacionBanco{
	
	private Domicilio direccion;
	private String email;
	private static int maximoCuentas = 10;
	private CuentaBancaria[ ] cuentas;
	
	private int cantidadCuentas;

	public Cliente (String calle, int numero, String entre1, String entre2,
							String codigoPostal, String telefono, String email) {
		this.direccion = new Domicilio (calle, numero, entre1, entre2, codigoPostal, telefono);
		this.email = email;
		this.cuentas = new CuentaBancaria[maximoCuentas];
		this.cantidadCuentas = 0;
	}
	
	public CuentaBancaria[ ] getCuentas ( ) {
			return cuentas;
	}

	public boolean agregarCuenta (CuentaBancaria cuenta) {
		if (cantidadCuentas < maximoCuentas) {
			cuentas [cantidadCuentas] = cuenta;
			cantidadCuentas++;
			return true;
		}
		else return false;
	}
	
	public int getCantidadCuentas ( ) {
			return cantidadCuentas;
	}

	@Override
	public double obtenerSaldoDisponible() {
		double i = 0;
		for (CuentaBancaria c : cuentas){
			i += c.getSaldo();
		}
		return i;
	}

	@Override
	public double obtenerComision() {
		return 0;
	}

	private class Domicilio {
		String calle;
		int numero;
		String entre1;
		String entre2;
		String codigoPostal;
		String telefono;
		
		private Domicilio (String calle, int numero, String entre1, String entre2,
 							String codigoPostal, String telefono) {
			this.calle = calle;
			this.numero = numero;
			this.entre1 = entre1;
			this.entre2 = entre2;
			this.codigoPostal = codigoPostal;
			this.telefono = telefono;
		}

		public String getTelefono ( ) {
				return telefono;
		}
		
		public void setTelefono (String valor) {
				telefono = valor;
		}

		public String getCalle ( ) {
				return calle;
		}

		public String getCodigoPostal ( ) {
				return codigoPostal;
		}

		public String [ ] getEntreCalles ( ) {
			String [ ] entre = new String [2];
			entre [0] = entre1;
			entre [1] = entre2;
			return entre;
		}

		public int getNumero ( ) {
				return numero;
		}
	}

	public static void setMaximoCuentas(int maximo){
		maximoCuentas = maximo;
	}
}
