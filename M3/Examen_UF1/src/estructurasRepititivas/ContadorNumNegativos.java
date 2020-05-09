package estructurasRepititivas;

import java.util.Scanner;

public class ContadorNumNegativos {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int numMax = 5, contador = 0;

		System.out.println("Vas a introducir " + numMax + " numeros.\n");

		for (int i = 1; i <= numMax; i++) {
			System.out.print("Numero " + i + ": ");
			int numero = lector.nextInt();
			if (numero < 0) {
				contador++;
			}
		}
		System.out.println();
		System.out.println(contador + " numero negativos.");

		lector.close();
	}

}
