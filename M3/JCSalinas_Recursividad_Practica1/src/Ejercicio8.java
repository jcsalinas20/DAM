import java.util.Scanner;

public class Ejercicio8 {

	public static int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		} else {
			int resultado = fibonacci(n - 1) + fibonacci(n - 2);
			return resultado;
		}

	}

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.print("Introduce un numero: ");
		int num = lector.nextInt();

		System.out.println("Resultado: " + fibonacci(num));

		lector.close();
	}

}
