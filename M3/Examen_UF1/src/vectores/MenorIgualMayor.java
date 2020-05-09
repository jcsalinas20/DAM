package vectores;

import java.util.Arrays;

public class MenorIgualMayor {

	public static void main(String[] args) {
		int[] array = new int[10];
		int menor = 0, mayor = 0, igual = 0;

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10 + 1);
		}

		System.out.println(Arrays.toString(array));

		for (int i = 0; i < array.length; i++) {
			if (array[i] < 5) {
				menor++;
			} else if (array[i] > 5) {
				mayor++;
			} else {
				igual++;
			}
		}

		System.out.println(menor+" numeros menores que 5.");
		System.out.println(igual+" numeros iguales que 5.");
		System.out.println(mayor+" numeros mayores que 5.");

	}

}
