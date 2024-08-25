package org.deneb.tp3.ejercicio5.utilidades;

public class UtilidadesNumerables {

	public static int suma (Numerable n1, Numerable n2) {
		return n1.toInt( ) + n2.toInt( );
	}

	// se pueden agregar todas las operaciones aritm�ticas

	public static boolean mayor (Numerable n1, Numerable n2) {
		return n1.toInt( ) > n2.toInt( );
	}

	// se pueden agregar todas las comparaciones

	// ordena un vector de Numerables por selecci�n:
	public static void ordenar (Numerable[ ] vector) {
		for (int i = 0; i < vector.length-1; i++)
			for (int j = i+1; j < vector.length; j++)
				if (vector[i].toInt( ) > vector[j].toInt( )) {
					Numerable temp = vector[i];
					vector[i] = vector[j];
					vector[j] = temp;
			    }
	}

	/**
	 * c) Agregar a la clase UtilidadesNumerable el m�todo public static boolean ordenardo (Numerable[ ] vector) que
	 * retorna true si el vector est� ordenado o false si no lo est�. Probar en la clase PruebaNumerable el m�todo
	 * implementado.
	 * @param vector
	 * @return
	 */
	public static boolean ordenardo (Numerable[ ] vector){
		for (int i = 0; i < vector.length - 1; i++) {
			if (vector[i].toInt() > vector[i + 1].toInt()) {
				return false;
			}
		}
		return true;
	}

	// se pueden agregar b�squedas y otros ordenamientos

}
