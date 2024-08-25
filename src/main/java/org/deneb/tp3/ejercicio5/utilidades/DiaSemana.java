package org.deneb.tp3.ejercicio5.utilidades;

public class DiaSemana implements Numerable {
	
	private String nombreDia;
	private int numeroDia;
	private String[ ] numerosNombres =
		{"", "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
	
	public DiaSemana (int numeroDia) {
		if (numeroDia > 0 && numeroDia < 8) {
			this.numeroDia = numeroDia;
			this.nombreDia = numerosNombres[numeroDia];
		}
		else throw new IllegalArgumentException ( );
	}
	
	public int toInt( ) {
		return numeroDia;
	}

	@Override
	public String mostrar() {
		return STR."\{nombreDia}-->\{numeroDia}";
	}

	/**
	 * Retorna el nombre del dia;
	 *
	 * @return nombre dia
	 */
	@Override
	public String toString() {
		return numerosNombres[numeroDia];
	}
}
