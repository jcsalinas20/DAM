package P10;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		boolean validacion = false;
		int dni = 0;
		int letra = 0;
		String[] tabla = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V",
				"H", "L", "C", "K", "E" };

		do {
			System.out.print("Introduce tu DNI: ");
			if (x.hasNextInt()) {
				dni = x.nextInt();
				if (dni >= 0) {
					validacion = true;
				}
			} else {
				x.next();
			}
		} while (validacion != true);

		letra = dni % 23;
		System.out.println("Tu letra es la " + tabla[letra]);
		System.out.println(dni + tabla[letra]);
		x.close();
	}

}
