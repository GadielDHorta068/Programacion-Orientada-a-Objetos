package org.deneb.tp2.ejercicio5.cuentas;


public abstract class Cliente {
	
	private Domicilio direccion;
	private String email;
	private static int maximoCuentas = 10;
	private CuentaBancaria[ ] cuentas;
	
	private int cantidadCuentas;

	public Cliente (String calle, int numero, String entre1, String entre2,
							String codigoPostal, String telefono, String email) {
		this.direccion = new Domicilio (calle, numero, entre1, entre2, codigoPostal, telefono);
		this.email = email;
		this.cuentas = new CuentaBancaria [maximoCuentas];
		this.cantidadCuentas = 0;
	}

	public Domicilio getDireccion ( ) {
			return direccion;
	}
	
	public void	setDireccion (Domicilio valor) {
			direccion = valor;
	}

	public String getEmail ( ) {
			return email;
	}
	
	public void setEmail (String valor) {
			email = valor;
	}
	
	public CuentaBancaria[ ] getCuentas ( ) {
			return cuentas;
	}

	public void agregarCuenta (CuentaBancaria cuenta) {
		if (cantidadCuentas == maximoCuentas) {
			throw new ClienteMaxCuentasException("maximo cuentas");
		}
		cuentas [cantidadCuentas] = cuenta;
		cantidadCuentas++;
	}
	
	public int getCantidadCuentas ( ) {
			return cantidadCuentas;
	}
	public double saldoTotal() {
		double saldoTotal = 0;
		for (CuentaBancaria cuenta : getCuentas()) {
			if (cuenta != null) {
				saldoTotal += cuenta.getSaldo();
			}
		}
		return saldoTotal;
	}

	public double saldoDisponibleTotal(){
		double i= 0;
		for(CuentaBancaria cuenta : getCuentas()){
			i += cuenta.getSaldo();
		}
		return i;
	}

	public void pagarTarjetaCredito(double importe) throws ClienteMaxCuentasException {
		if(importe > saldoDisponibleTotal()){
            throw new ClienteMaxCuentasException("Saldo insuficiente");
		}
		//for para cajas ahorro
		//instance of
		//for cuenta corriente
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
