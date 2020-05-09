package Practica1;

import java.util.Arrays;

public class Ejercicio2 {

	public static void main(String[] args) {
		Ejercicio2 dados = new Ejercicio2();
		dados.Dados();
	}

	//CODIGO GENERAL
	public void Dados() {
		int[] dado1 = new int[11];
		int[] dado2 = new int[11];
		int[] sumaTotal = new int[11];
		
		numRandom(dado1, dado2, sumaTotal);
		
		print(dado1, dado2);

		for (int i = 0; i < sumaTotal.length; i++) {
			System.out.print((i + 2) + ": ");
			for (int j = 0; j < sumaTotal[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		mayor(sumaTotal);
	}

	//GENERACION DE NUMEROS RANDOMS
	public void numRandom(int[] dado1, int[] dado2, int[] sumaTotal) {
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < dado1.length; j++) {
				dado1[j] = (int) (Math.random() * 6 + 1);
			}
			for (int j = 0; j < dado2.length; j++) {
				dado2[j] = (int) (Math.random() * 6 + 1);
			}
			for (int j = 0; j < sumaTotal.length; j++) {
				sumaTotal[j] = dado1[j] + dado2[j];
			}
		}
	}
	
	//MOSTRAR POR PANTALLA
	public void print(int[] dado1, int[] dado2) {
		System.out.println("Datos del Dado1: " + Arrays.toString(dado1));
		System.out.println("Datos del Dado2: " + Arrays.toString(dado2));
		System.out.println();
	}
	
	//BUSQUEDA DEL NUMERO MAYOR
	public void mayor(int[] sumaTotal) {
		int numMayor = 0;

		for (int i = 1; i < sumaTotal.length; i++) {
			if (sumaTotal[i] > numMayor) {
				numMayor = sumaTotal[i];
			}
		}
		System.out.println("\nEl numero maximo es " + numMayor);
	}

}
