// ConjuntoArreglo.java
package org.deneb.tp3.ejercicio4.algebra;

public class ConjuntoArreglo extends BaseConjunto {
	
	private boolean[ ] implementacion;
	private int base;
	
	public ConjuntoArreglo (int base) {
		if (base > 0 && base < 65)
			this.base = base;
		else base = 64;
		implementacion = new boolean[base];
	}

	public int getBase( ) {
		return base;
	}

	public boolean pertenece (int x) {
		if (x >= 0 && x < implementacion.length)
			return implementacion[x];
		else return false;
	}

	public boolean vacio( ) {
		boolean vacio = true;
		for (int x = 0; x < implementacion.length; x++)
			if (implementacion[x]) {
				vacio = false;
				break;
			}
		return vacio;
	}

	public void vaciar( ) {
		for (int x = 0; x < this.getBase( ); x++)
			implementacion[x] = false;
	}

	public void agregarElemento (int x) {
		if (x >= 0 && x < this.getBase( ))
			implementacion[x] = true;
	}

	public void sacarElemento (int x) {
		if (x >= 0 && x < this.getBase( ))
			implementacion[x] = false;
	}

	public int cardinalidad( ) {
		int cantidad = 0;
		for (int i = 0; i < implementacion.length; i++)
			if (implementacion[i])
				cantidad++;
		return cantidad;
	}

	@Override
	public Conjunto diferenciaSimetrica(Conjunto b) {
		Conjunto diferenciaAB = this.diferencia(b);
		Conjunto diferenciaBA = b.diferencia(this);
		return diferenciaAB.union(diferenciaBA);
	}
}
