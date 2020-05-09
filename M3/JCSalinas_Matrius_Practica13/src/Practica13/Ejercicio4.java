package Practica13;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int[][] matriz = new int[3][3];
		boolean validacion = false;

		do {
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					System.out.print("Introduce un numero para la posicion[" + i + "][" + j + "]: ");
					if (lector.hasNextInt()) {
						matriz[i][j] = lector.nextInt();
						validacion = true;
					} else {
						lector.nextLine();
						j--;
					}
				}
			}
		} while (validacion != true);

		System.out.println("\nMatriz Filas");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("\nMatriz Columnas");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[j][i] + " ");
			}
			System.out.println();
		}
		lector.close();
	}
}
