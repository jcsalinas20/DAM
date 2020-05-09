import java.util.Arrays;

public class BurbujaEn2Sentidos {

	public static void main(String[] args) {
//		NO ESTA ACABADO
		int[] array = { 4, 5, 8, 9, 7, 1, 6, 4, 2, 6 };
//						1, 4, 5, 6, 8, 9, 7, 6, 4, 2

		int auxiliar = 0;
		for (int i = 0; i < array.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < array.length - 1; j++) {
					if (array[j] > array[j + 1]) {
						auxiliar = array[j];
						array[j] = array[j + 1];
						array[j + 1] = auxiliar;
					}
				}
			} else {
				for (int j = array.length - 1; j > 0; j--) {
					if (array[j] > array[j - 1]) {
						auxiliar = array[j];
						array[j] = array[j - 1];
						array[j - 1] = auxiliar;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(array));
	}

}
