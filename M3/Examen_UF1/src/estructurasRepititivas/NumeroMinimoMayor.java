package estructurasRepititivas;

import java.util.Scanner;

public class NumeroMinimoMayor {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int numMin = 100000, numMax = 0, mediana = 0;
		System.out.println("Introduce quantos numero vas a introducir: ");
		int numeros = lector.nextInt();

		int[] array = new int[numeros];
		System.out.println("Introduce " + numeros + " numeros: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = lector.nextInt();
			if (array[i] < numMin) {
				numMin = array[i];
			}
			if (array[i] > numMax) {
				numMax = array[i];
			}
		}
		for (int i = 0; i < array.length; i++) {
			mediana += array[i];
		}

		System.out.println("numMin: " + numMin);
		System.out.println("numMax: " + numMax);
		System.out.println("Mediana: " + mediana / array.length);

		lector.close();
	}

}
