package Practica1;

import java.util.*;

public class Ejercicio5A {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int[] arrayRandom = new int[6];
		int e = 0;
		for (int i = 0; i <= 5; i++) {
			arrayRandom[e] = (int) (Math.random() * 49 + 1);
			System.out.println("Del numero 1 al 49 a tocado el "+arrayRandom[e]);
			e++;
		}
		x.close();
	}

}
