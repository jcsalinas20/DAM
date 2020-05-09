package P10;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int numVots = 0;
		int escVots = 0;
		int partits = 0;
		boolean validacion = false;

		do {
			System.out.print("Introduce el numero de partidos: ");
			if (x.hasNextInt()) {
				partits = x.nextInt();
				if (partits > 1) {
					validacion = true;
				} else {
					System.out.println("Tiene que haber mas de 1 partido.");
				}
			} else {
				x.next();
			}
		} while (validacion != true);

		// CREACION DE ARRAYS
		int[] vots = new int[partits];
		escVots = partits;
		int[] esc = new int[escVots];
		int[] restaVots = new int[escVots];

		validacion = false;
		for (int i = 0; i < vots.length; i++) {
			int e = 0;
			do {
				System.out.print("Numeros de votos de X: ");
				if (x.hasNextInt()) {
					numVots = x.nextInt();
					vots[i] = numVots;
					if (vots[i] < (vots[e] + 1)) {
						validacion = true;
					} else {
						System.out.println(
								"Error. El numero de votos es mayor que el partido anterior. \rVuelve a Introducir los Votos");
						i--;
						e--;
					}
				} else if (i == 0) {
					x.next();
				} else {
					x.next();
					i--;
					e--;
				}
			} while (validacion != true);
		}

		for (int i = 0; i <= 7; i++) {
			int mayor = 0;
			int k=0;
			int j=0;
			int m=0;
			System.out.println("Entro en el for");
			while(j < vots.length) {
				System.out.println("Entro en el while");
				if (vots[m]==vots[k]) {
					k++;
					System.out.println("Entro en el ==");
				}
				else if (vots[m]>vots[k]) {
					mayor=vots[m];
					k++;
					System.out.println("Entro en el j>k");
				}
				else if (vots[m]<vots[k]) {
					k=0;
					m++;
					System.out.println("Entro en el j<k");
				}
//				if(k>=vots.length) {
//					k--;
//					System.out.println("Entro en el k>=vots.length");
//				}
				System.out.println("vots= "+mayor);
				restaVots[m]=mayor/(esc[m]+2);
				System.out.println("restaVots= "+restaVots[m]);
				System.out.println("esc= "+esc[m]);
				j++;
			}
		}
		x.close();
	}

}
