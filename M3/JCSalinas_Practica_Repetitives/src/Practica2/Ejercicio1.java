package Practica2;
public class Ejercicio1 {
	public static final int VALOR = 25;

	public static void main(String[] args) {
		int n = 0;
		for (int i = 1; i < VALOR; i++) {
			System.out.println(i);
			if (i%10 == 0) {
				n++;
			}
		}
		System.out.println("El resultat és " + n + ".");
	}

}
