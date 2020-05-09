package Practica2;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int tabla[] = { 1, 12, 4, 5, 7, 3, 2, 9, 6, 7 };
		//int tabla[] = { 1, 13, 4, 5, 7, 3, 2, 8, 5, 7 };
		int cont = 0;
		int num = 0;
		while ( (cont < tabla.length) && (num <=1)) {
			if (tabla[cont] % 3 == 0) {
				num++;
				if (num == 2) {
					System.out.println("El segundo multiplo de 3 es: " + tabla[cont]);
				}
			}
			cont++;
		}
		if (num <= 1) {
			System.out.println("No hay suficientes multiplos de 3");
		}
		x.close();
	}

}
