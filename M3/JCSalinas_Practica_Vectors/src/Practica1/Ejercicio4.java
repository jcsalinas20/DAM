package Practica1;

import java.util.*;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int[] tabla = new int[10];
		int cont = 0;
		int sumaTotal = 0;
		int e = 0;
		for (int i = 0; i <= 9; i++) {
			tabla[cont] = (int) (Math.random() * 21);
			cont++;
			System.out.print(tabla[e] + " ");
			e++;
		}
		System.out.println("");
		cont = 0;
		for (int i = 0; i <= 9; i++) {
			if ( tabla[cont]%3==0) {
				sumaTotal=sumaTotal+tabla[cont];
			}
			cont++;
		}
		System.out.print("La suma total de los multipols es: "+sumaTotal);
		x.close();
	}

}
