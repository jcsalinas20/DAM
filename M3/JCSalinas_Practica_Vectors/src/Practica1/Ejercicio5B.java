package Practica1;

import java.util.*;

public class Ejercicio5B {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int[] tabla = new int[6];
		int cont = 0;
		int e = 0;
		for (int i = 0; i <= 5; i++) {
			tabla[cont] = (int) (Math.random() * 49 + 1);
			System.out.println(tabla[cont]);
			for (int j = 0; j < i; j++)
				if (tabla[cont] == tabla[e]) {
					System.out.println("hola");
				}
			e++;
			cont++;
		}
		System.out.println(tabla[0]);
		System.out.println(tabla[1]);
		System.out.println(tabla[2]);
		System.out.println(tabla[3]);
		System.out.println(tabla[4]);
		System.out.println(tabla[5]);
		x.close();
	}

}
