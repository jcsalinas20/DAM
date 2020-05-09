package Practica2;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner x=new Scanner(System.in);
		int[] tabla= new int[20];
		int e=0;
		int i=0;
		
		while (i < tabla.length) {
			if (!x.hasNextInt()) {
				x.next();
			} else {
				tabla[i] = x.nextInt();
				i++;
			}
		}
		
		for (int j=0; j<tabla.length; j++) {
			System.out.print("El valor de la posicion "+e+" es ");
			System.out.println(tabla[j]);
			e++;
		}
		x.close();
	}

}
