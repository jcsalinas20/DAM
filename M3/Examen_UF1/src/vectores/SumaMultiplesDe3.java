package vectores;

import java.util.Arrays;

public class SumaMultiplesDe3 {

	public static void main(String[] args) {
		int[] array = new int[10];
		int suma = 0;

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1);
		}

		System.out.println(Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {
			if (i % 3 == 0 && i > 0) {
				suma += array[i];
				System.out.println(i);
			}
		}
		System.out.println("Suma total: " + suma);

	}

}
