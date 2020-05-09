package Practica13;

public class Ejercicio1a {

	public static void main(String[] args) {
		int[][] matrius = { { 3, 4, 5 }, { 6, 7, 8 }, { 9, 10, 11 } };
		for (int i = 0; i < matrius.length; i++) {
			for (int j = 0; j < matrius.length; j++) {
				if (j==2 && i==0) {
					System.out.print("[ , ,"+matrius[i][j]+"]");
				}
				if (j==1 && i==1) {
					System.out.print("\n[ ,"+matrius[i][j]+", ]");
				}
				if (j==0 && i==2) {
					System.out.print("\n["+matrius[i][j]+", , ]");
				}
			}
		}
	}
}
