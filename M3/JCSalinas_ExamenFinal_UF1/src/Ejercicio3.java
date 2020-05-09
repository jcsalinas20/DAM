public class Ejercicio3 {

	public static void main(String[] args) {
		int[][] matriz = new int[5][5];
		int auxiliar = 0;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				matriz[i][j] = (int) (Math.random() * 101);
			}
		}

		System.out.println("Array Desordenado");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				for (int k = 0; k < matriz.length - 1; k++) {
					if (matriz[k][i] < matriz[k + 1][i]) {
						auxiliar = matriz[k][i];
						matriz[k][i] = matriz[k + 1][i];
						matriz[k + 1][i] = auxiliar;
					}
				}
			}
		}

		System.out.println("\n\nArray Ordenado");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
