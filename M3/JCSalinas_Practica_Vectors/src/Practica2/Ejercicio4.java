package Practica2;

public class Ejercicio4 {

	public static void main(String[] args) {
		int[] tablaImpar = { 1, 3, 5, 7, 9, 11, 13, 15 };
		int[] tablaPar = { 2, 4, 6, 8, 10, 12, 14, 16 };

		int[] tabla = new int[tablaImpar.length + tablaPar.length];
		int cont = 0;
		int contImpar = 0;
		int contPar = 1;

		for (int j = 0; j < tablaImpar.length; j++) {
			tabla[contImpar] = tablaImpar[j];
			contImpar = contImpar + 2;
		}
		for (int k = 0; k < tablaPar.length; k++) {
			tabla[contPar] = tablaPar[k];
			contPar = contPar + 2;
		}

		for (int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[cont]);
			cont++;

		}
	}

}
