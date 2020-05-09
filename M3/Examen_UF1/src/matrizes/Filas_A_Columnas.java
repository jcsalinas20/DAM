package matrizes;

import java.util.Arrays;

public class Filas_A_Columnas {

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arrayDestino = new int[array.length][array[0].length];

		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		System.out.println();
		for (int i = 0; i < arrayDestino.length; i++) {
			for (int j = 0; j < arrayDestino.length; j++) {
				arrayDestino[j][i] = array[i][j];
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(arrayDestino[i]));
		}
	}

}
