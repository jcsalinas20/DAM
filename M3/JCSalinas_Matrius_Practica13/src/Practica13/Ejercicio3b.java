package Practica13;

import java.util.Scanner;

public class Ejercicio3b {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int[][] matriz1 = new int[4][2];
		int[][] matriz2 = new int[4][2];
		int[][] matrizTotal = new int[4][2];
		boolean validacion = false;

		do {
			System.out.println("Introduce 8 numeros para el Array1: ");
			for (int i = 0; i < matriz1.length; i++) {
				for (int j = 0; j < matriz1[i].length; j++) {
					if (lector.hasNextInt()) {
						matriz1[i][j] = lector.nextInt();
						validacion = true;
					} else {
						lector.nextLine();
						j--;
					}
				}
			}
		} while (validacion != true);

		validacion = false;
		do {
			System.out.println("Introduce 8 numeros para el Array2: ");
			for (int i = 0; i < matriz2.length; i++) {
				for (int j = 0; j < matriz2[i].length; j++) {
					if (lector.hasNextInt()) {
						matriz2[i][j] = lector.nextInt();
						validacion = true;
					} else {
						lector.nextLine();
						j--;
					}
				}
			}
		} while (validacion != true);

		for (int i = 0; i < matrizTotal.length; i++) {
			for (int j = 0; j < matrizTotal[i].length; j++) {
				matrizTotal[i][j] = matriz1[i][j] + matriz2[i][j];
			}
		}

		System.out.println(" Array1\t Array2\t ArrayTotal: ");
		for (int i = 0; i < matrizTotal.length; i++) {
			System.out.print("|  ");
			for (int j = 0; j < matriz1[i].length; j++) {
				System.out.print(matriz1[i][j] + " ");
			}
			System.out.print("\t|  ");
			for (int j = 0; j < matriz2[i].length; j++) {
				System.out.print(matriz2[i][j] + " ");
			}
			System.out.print("\t|   ");
			for (int j = 0; j < matrizTotal[i].length; j++) {
				System.out.print(matrizTotal[i][j] + " ");
			}
			System.out.println("\t|");
		}
		lector.close();
	}

}
