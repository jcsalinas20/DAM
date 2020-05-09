package P12;

public class Ejercicio4 {

	public static void main(String[] args) {
		int[] array1 = new int[10];
		int[] array2 = new int[10];
		int[] arrayTotal = new int[20];
		int a = arrayTotal.length / 2;
		int b=0;

		for (int i = 0; i < array1.length; i++) {
			array1[i] = (int) (Math.random() * 21);
		}
		for (int i = 0; i < array2.length; i++) {
			array2[i] = (int) (Math.random() * 21);
		}
		
		System.out.println("Array1");
		for (int j = 0; j < array2.length; j++) {
			System.out.print(array1[j] + "  ");
		}
		System.out.println("\nArray2");
		for (int j = 0; j < array2.length; j++) {
			System.out.print(array2[j] + "  ");
		}
		
		for (int i = 0; i < array1.length; i++) {
			arrayTotal[i] = array1[i];
		}
		for (int i = 0; i < array2.length; i++) {
			arrayTotal[a] = array2[i];
			a++;
		} 
		
		System.out.println("\n\n\nArrayTotal Desordenado");
		for (int j = 0; j < arrayTotal.length; j++) {
			System.out.print(arrayTotal[j] + "  ");
		}
		
		while (b<arrayTotal.length) {
			int c=0;
			int d=1;
			int intercambio=0;
			while(c<arrayTotal.length) {
				if (d==arrayTotal.length) {
					d--;
					intercambio=arrayTotal[d];
					arrayTotal[d]=arrayTotal[c];
					arrayTotal[c]=intercambio;
				}else if (arrayTotal[c]>arrayTotal[d]) {
					intercambio=arrayTotal[d];
					arrayTotal[d]=arrayTotal[c];
					arrayTotal[c]=intercambio;
				}
				c++;
				d++;
			}
			b++;
		}
		

		System.out.println("\nArrayTotal Ordenado");
		for (int j = 0; j < arrayTotal.length; j++) {
			System.out.print(arrayTotal[j] + "  ");
		}

	}

}
