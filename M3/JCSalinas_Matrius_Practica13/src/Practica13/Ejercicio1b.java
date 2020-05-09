package Practica13;

public class Ejercicio1b {

	public static void main(String[] args) {
		int[][] matrius = { { 3, 4, 5 }, { 6, 7, 8 }, { 9, 10, 11 } };
		for (int i = 0; i < matrius.length; i++) {
			for (int j = 0; j < matrius.length; j++) {
				System.out.print(matrius[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
