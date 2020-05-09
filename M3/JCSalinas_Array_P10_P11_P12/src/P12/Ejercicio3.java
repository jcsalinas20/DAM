package P12;

public class Ejercicio3 {

	public static void main(String[] args) {
		int[] num = new int[20];
		int[] array1 = new int[10];
		int[] array2 = new int[10];
		int j = num.length / 2;
		int a=0;
		int b=0;
		int intercambio=0;

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 21);
		}

		for (int i = 0; i < array1.length; i++) {
			array1[i] = num[i];
		}

		for (int i = 0; i < array2.length; i++) {
			array2[i] = num[j];
			j++;
		}

		System.out.println("Array1 Desordenado");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + "  ");
		}
		
		System.out.println("\n\nArray2 Desordenado");
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + "  ");
		}		
		
		while (a < array1.length) {
			int z=0;
			int k=1;
			while (z<array1.length) {
				if (k==array1.length) {
					k--;
					intercambio=array1[k];
					array1[k]=array1[z];
					array1[z]=intercambio;
				}else if (array1[z]>array1[k]) {
					intercambio=array1[k];
					array1[k]=array1[z];
					array1[z]=intercambio;
				}
				z++;
				k++;
			}
			a++;
		}
		
		while (b < array2.length) {
			int z=0;
			int k=1;
			while (z<array2.length) {
				if (k==array2.length) {
					k--;
					intercambio=array2[k];
					array2[k]=array2[z];
					array2[z]=intercambio;
				}else if (array2[z]>array2[k]) {
					intercambio=array2[k];
					array2[k]=array2[z];
					array2[z]=intercambio;
				}
				z++;
				k++;
			}
			b++;
		}
		
		
		System.out.println("\n\n\nArray1 Ordenado");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + "  ");
		}
		
		System.out.println("\n\nArray2 Ordenado");
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + "  ");
		}

	}

}
