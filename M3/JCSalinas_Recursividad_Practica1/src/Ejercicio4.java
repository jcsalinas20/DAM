import java.util.Scanner;

public class Ejercicio4 {

	public static float wallis(int n, float pi, float numerador) {
		float resultado = 2f;
		if (n == 0) {
			return pi * 2;
		} else if (n > 0) {
			resultado = (resultado / (numerador - 1)) * (numerador / (numerador + 1));
			return wallis(n - 1, (pi + resultado), numerador = numerador + 2);
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		float numerador = 2f;
		float pi = 0f;

		System.out.print("Introduce un numero: ");
		int n = lector.nextInt();

		System.out.println("Resultado TT: " + wallis(n, pi, numerador));

		System.out.println("El Programa ha acabado.");
		lector.close();
	}

}
