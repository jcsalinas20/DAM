package Practica13;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int[][] matriz = new int[3][3];
		int auxiliar = 0;
		int numMayor = matriz[0][0];
		int numMenor = matriz[0][0];
		boolean validacion = false;

		do {
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					System.out.print("Introduce un numero para la posicion [" + i + "][" + j + "]: ");
					if (lector.hasNextInt()) {
						matriz[i][j] = lector.nextInt();
						if (matriz[i][j] >= 0) {
							validacion = true;
						} else {
							System.out.println("El numero tiene que ser mayor o igual que 0.");
							j--;
						}
					} else {
						lector.nextLine();
						j--;
					}
				}
				System.out.println();
			}
		} while (validacion != true);

		for (int i = 0; i < matriz.length; i++) {
			System.out.print(Arrays.toString(matriz[i]) + "\n");
		}

		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < matriz.length; j++) {
				auxiliar = matriz[i][j];
				matriz[i][j] = matriz[2][j];
				matriz[2][j] = auxiliar;
			}
		}

		System.out.println();
		for (int i = 0; i < matriz.length; i++) {
			System.out.print(Arrays.toString(matriz[i]) + "\n");
		}

		// NUMERO MAYOR
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] > numMayor) {
					numMayor = matriz[i][j];
				}
			}
		}
		// NUMERO MENOR
		numMenor = numMayor;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] < numMenor) {
					numMenor = matriz[i][j];
				}
			}
		}

		System.out.println("\nEl numero mayor es: " + numMayor);
		System.out.println("El numero menor es: " + numMenor);

		lector.close();
	}

}
