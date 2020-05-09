package Practica2;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int i = 0;
		int cont = 0;
		int suma = 0;
		boolean validacion = false;
		System.out.print("Indroduce un numero: ");
		while (validacion==x.hasNextInt()) {
			System.out.println("Vuelve a Introducir");
			if (!x.hasNextInt()) {
				x.next();
			}
		}
		i=x.nextInt();
			
		int[] tabla = new int[i];
		for (int e = 0; e < tabla.length; e++) {
			tabla[cont] = tabla[cont] + suma;
			suma = suma + 2;
			cont++;
		}

		for (int e = 0; e < tabla.length; e++) {
			System.out.println(tabla[e]);
		}
		x.close();
	}

}
