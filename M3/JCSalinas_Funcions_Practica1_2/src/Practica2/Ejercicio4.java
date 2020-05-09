package Practica2;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Ejercicio4 programa = new Ejercicio4();
		programa.inici();
	}

	public void inici() {
		int[] numeros = new int[10];
		introducirNumerosArray(numeros);
		ordenacionDescendente(numeros);
		mediana(numeros);
	}

	public void introducirNumerosArray(int[] numeros) {
		Scanner lector = new Scanner(System.in);
		boolean validacion = false;
		System.out.println("Escriu deu enters separats per espais: ");
		do {
			for (int i = 0; i < numeros.length; i++) {
				if (lector.hasNextInt()) {
					numeros[i] = lector.nextInt();
					if (numeros[i] >= 0) {
						validacion = true;
					} else {
						i--;
						System.out.println("Introduce un numero positivo.");
						lector.nextLine();
					}
				} else {
					i--;
					System.out.println("Introduce un numero entero.");
					lector.nextLine();
				}
			}
		} while (validacion != true);
	}

	public void ordenacionDescendente(int[] numeros) {
		int auxiliar = 0;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = i; j < numeros.length; j++) {
				if (numeros[i] < numeros[j]) {
					auxiliar = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = auxiliar;
				}
			}
		}
	}

	public void mediana(int[] numeros) {
		float mediana = 0;
		for (int i = 0; i < 3; i++) {
			mediana=mediana+numeros[i];
		}
		System.out.println("\nLa mitjana dels tres valors mes grans es "+mediana/3);
	}

}
