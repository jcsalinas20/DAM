package Practica1;

import java.util.*;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int multiple = 44;
		int resultado = 0;
		while (multiple>=0) {
			System.out.println("Introduce un numero para saber si es multiple de 10: ");
				multiple = x.nextInt();
				if (multiple % 10 == 0) {
					System.out.println(multiple +" Es multiple de 10");
				}
				else {
					resultado=multiple*100;
					System.out.println( resultado +" "+ multiple +" per 10 elevat a 2");
				}
		}
		x.close();
	}
}
