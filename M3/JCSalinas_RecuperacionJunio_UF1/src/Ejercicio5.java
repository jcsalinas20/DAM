import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String cadena = "";
		char[] arrayCadena;
		char caracter;

		System.out.println("Introduce una frase: ");
		cadena = lector.nextLine();
		arrayCadena = cadena.toCharArray();

		char[] caracteres = new char[cadena.length()];
		int[] contador = new int[cadena.length()];

		for (int i = 0; i < arrayCadena.length; i++) {
			caracter = arrayCadena[i];
			caracteres[i] = caracter;

			for (int j = i; j < arrayCadena.length; j++) {
				if (arrayCadena[j] == caracter) {
					contador[i]++;
					arrayCadena[j] = ' ';
				}
			}

		}

		char auxiliar = '#';
		for (int i = 0; i < contador.length; i++) {
			for (int j = 0; j < contador.length - 1; j++) {
				if (caracteres[j] > caracteres[j + 1]) {
					auxiliar = caracteres[j];
					caracteres[j] = caracteres[j + 1];
					caracteres[j + 1] = auxiliar;
					auxiliar = (char) contador[j];
					contador[j] = contador[j + 1];
					contador[j + 1] = auxiliar;
				}
			}
		}

		System.out.println();
		for (int i = 0; i < contador.length; i++) {
			if (caracteres[i] != 32) {
				System.out.println("Letra \"" + caracteres[i] + "\" repetida " + contador[i] + " veces");
			}
		}

		lector.close();
	}

}
