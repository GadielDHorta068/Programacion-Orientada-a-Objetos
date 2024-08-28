// BaseConjunto.java
package org.deneb.tp3.ejercicio4.algebra;

public abstract class BaseConjunto implements Conjunto {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		boolean primero = true;
		for (int i = 0; i < this.getBase(); i++) {
			if (this.pertenece(i)) {
				if (!primero) {
					sb.append(", ");
				}
				sb.append(i);
				primero = false;
			}
		}
		sb.append("}");
		return sb.toString();
	}

	public Conjunto union (Conjunto b) {
		int baseNuevo = Math.max (this.getBase( ), b.getBase( ));
		Conjunto c = new ConjuntoArreglo (baseNuevo);
		if (this.getBase( ) > b.getBase( )) {
			int x = 0;
			// recorremos ambos conjuntos hasta que termine el más corto (b)
			while (x < b.getBase( )) {
				if (this.pertenece(x) || b.pertenece(x)) 
					c.agregarElemento(x);
				x++;
			}
			// recorremos el más largo (a) hasta que termine
			while (x < this.getBase( )) {
				if (this.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
		}
		else {	// el b es más largo que el a
			int x = 0;
			// recorremos ambos conjuntos hasta que termine el más corto (a)
			while (x < this.getBase( )) {
				if (this.pertenece(x) || b.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
			// recorremos el más largo (b) hasta que termine
			while (x < b.getBase( )) {
				if (b.pertenece(x))
					c.agregarElemento(x);
				x++;
			}
		}
		return c;
	}

	public Conjunto interseccion (Conjunto b) {
		int baseNuevo = Math.max (this.getBase( ), b.getBase( ));
		Conjunto c = new ConjuntoArreglo (baseNuevo);
		int x = 0;
		// recorremos ambos conjuntos hasta que termine el más corto
		while (x < Math.min(this.getBase( ),b.getBase( ))) {
			if (this.pertenece(x) && b.pertenece(x)) 
				c.agregarElemento(x);
			x++;
		}
		return c;
	}

	public Conjunto diferencia(Conjunto b) {
		int baseNuevo = Math.max(this.getBase(), b.getBase());
		Conjunto c = new ConjuntoArreglo(baseNuevo);

		for (int x = 0; x < this.getBase(); x++) {
			if (this.pertenece(x) && !b.pertenece(x)) {
				c.agregarElemento(x);
			}
		}

		return c;
	}

	public boolean incluido (Conjunto b) {
		boolean incluido = true;
		for (int x = 0; x < this.getBase( ); x++)
			if (this.pertenece(x) && !b.pertenece(x))
				incluido = false;
		return incluido;
	}

	public boolean igual(Conjunto b) {
		int maxBase = Math.max(this.getBase(), b.getBase());

		for (int x = 0; x < maxBase; x++) {
			if (this.pertenece(x) != b.pertenece(x)) {
				return false;
			}
		}
		return true;
	}
}
