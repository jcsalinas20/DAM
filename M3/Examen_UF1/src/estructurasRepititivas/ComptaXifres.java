package estructurasRepititivas;

import java.util.Scanner;

public class ComptaXifres {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int contador = 0;

		System.out.println("Introduce un numero: ");
		int num = lector.nextInt();

		if (num == 0) {
			System.out.println("Tiene 1 cifras.");
		} else {
			while (num >= 1) {
				num /= 10;
				contador++;
			}

			System.out.println("Tiene " + contador + " cifras.");
		}
		lector.close();
	}

}
