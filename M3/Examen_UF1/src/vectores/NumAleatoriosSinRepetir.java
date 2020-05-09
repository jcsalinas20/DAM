package vectores;

import java.util.Arrays;

public class NumAleatoriosSinRepetir {

	public static void main(String[] args) {
		int[] array = new int[10];

		for (int i = 0; i < array.length; i++) {
			boolean repetido = false;
			int comprobacion = (int) (Math.random() * 10 + 1);
			for (int j = 0; j < i; j++) {
				if (array[j] == comprobacion) {
					repetido = true;
				}
			}
			if (!repetido) {
				array[i] = comprobacion;
			} else {
				i--;
			}
		}

		System.out.println(Arrays.toString(array));
	}

}
