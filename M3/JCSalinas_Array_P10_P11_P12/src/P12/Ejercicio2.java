package P12;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int a = 0;
		int intercambio = 0;
		boolean validacion = false;
		int[] tabla = new int[10];

		for (int i = 0; i < tabla.length; i++) {
			do {
				System.out.println("Introduce un numero para la posicion "+i+": ");
				if (x.hasNextInt()) {
					tabla[i] = x.nextInt();
					if (tabla[i] >= 0) {
						validacion = true;
					}
				} else if (i==0) {
					x.next();
				} else {
					x.next();
					i--;
				}
			} while (validacion != true);
		}
		

		System.out.println("Desordenados");
		for (int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[i]);
		}

		while (a < tabla.length) {
			int b = 0;
			int c = 1;
			int z = 0;
			while (z < tabla.length) {
				if (c == tabla.length) {
					c = c - 1;
					intercambio = tabla[b];
					tabla[b] = tabla[c];
					tabla[c] = intercambio;
				} else if (tabla[b] > tabla[c]) {
					intercambio = tabla[b];
					tabla[b] = tabla[c];
					tabla[c] = intercambio;
				}
				z++;
				b++;
				c++;
			}
			a++;
		}

		System.out.println("\rOrdenados");
		for (int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[i]);
		}
		x.close();
	}

}
