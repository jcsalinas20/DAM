import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int[] contador = new int[10];
		boolean fi = false;

		System.out.println("Introduce un numero negativo para parar el programa.");
		while (!fi) {
			boolean validacion = false;
			System.out.println("Introduce un numero: ");
			int valor = 0;

			do {
				if (lector.hasNextInt()) {
					valor = lector.nextInt();
					if (valor >= 0 && valor <= 9) {
						validacion = true;
					} else if (valor < 0) {
						System.out.println("Has salido el programa.");
						fi = true;
						validacion = true;
					} else {
						System.out.println("El numero tiene que ser entre 0  y 9.");
						lector.nextLine();
					}
				} else {
					System.out.println("No has introducido un numero.");
					lector.nextLine();
				}
			} while (validacion != true);

			if (valor == 0) {
				contador[valor]++;
			} else if (valor == 1) {
				contador[valor]++;
			} else if (valor == 2) {
				contador[valor]++;
			} else if (valor == 3) {
				contador[valor]++;
			} else if (valor == 4) {
				contador[valor]++;
			} else if (valor == 5) {
				contador[valor]++;
			} else if (valor == 6) {
				contador[valor]++;
			} else if (valor == 7) {
				contador[valor]++;
			} else if (valor == 8) {
				contador[valor]++;
			} else if (valor == 9) {
				contador[valor]++;
			}

		}

		for (int i = 0; i < contador.length; i++) {
			System.out.println("El numero " + i + " a aparecido " + contador[i] + " vegades.");
		}

		lector.close();
	}

}
