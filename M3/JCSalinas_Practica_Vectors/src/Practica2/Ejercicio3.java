package Practica2;

public class Ejercicio3 {

	public static final int[] array = { 1, 6, 4, 8, 3, 7, 3, 6, 9, 4, 2, 9, 6 };

	public static void main(String[] args) {
		int i = 1;
		int resultat = 0;
		while (array[i] != 9) {
			if (array[i - 1] < array[i]) {
				resultat++;
			}
			i++;
		}
		System.out.println("El resultat és " + resultat + ".");
	}

	/*public static final int[] array = { 1, 6, 4, 8, 3, 7, 3, 6, 9, 4, 2, 9, 6 };

	public static void main(String[] args) {
		int i = array.length - 1;
		int resultat = 0;
		while (i > (array.length / 2)) {
			if (array[i] == 4) {
				resultat--;
			} else {
				resultat++;
			}
		}
		System.out.println("El resultat és " + resultat + ".");
	}*/

}
