package Practica1;

import java.util.*;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int cont = 0;
		int num = 0;
		int menor = 0;
		int igual = 0;
		int mayor = 0;
		int[] tabla = new int[10];
		System.out.print("Introduce un numero del 0-9: ");
		num = x.nextInt();
		if (num >= 0 && num <= 9) {
			for (int i = 0; i <= 9; i++) {
				tabla[cont] = (int) (Math.random() * 21);
				cont++;
			}
		} else {
			System.out.println("Error");
		}
		cont = 0;
		for (int i = 0; i <= 9; i++) {
			if (tabla[cont] < num) {
				menor++;
			} else if (tabla[cont] == num) {
				igual++;
			} else if (tabla[cont] > num) {
				mayor++;
			}
			cont++;
		}
		System.out.println("\rHay " + menor + " numeros menores que " + num);
		System.out.println("Hay " + igual + " numeros iguales que " + num);
		System.out.println("Hay " + mayor + " numeros mayores que " + num);
		x.close();
	}

}
