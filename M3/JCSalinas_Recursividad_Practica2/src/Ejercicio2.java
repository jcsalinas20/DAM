import java.util.Scanner;

public class Ejercicio2 {

	static Scanner lector = new Scanner(System.in);
	static boolean validacion = false;

	public static int sumaDigitos(int valor) {
		if (valor == 0) {
			return valor;
		} else {
			return sumaDigitos(valor / 10) + valor % 10;
		}
	}

	public static void main(String[] args) {
		int numero = 0;

		do {
			numero = validacionNumero(numero);
		} while (validacion != true);

		System.out.println(sumaDigitos(numero));

		lector.close();
	}

	public static int validacionNumero(int valor) {
		System.out.print("Introduce un numero: ");
		if (lector.hasNextInt()) {
			valor = lector.nextInt();
			validacion = true;
			return valor;
		} else {
			lector.nextLine();
			return valor;
		}
	}

}
