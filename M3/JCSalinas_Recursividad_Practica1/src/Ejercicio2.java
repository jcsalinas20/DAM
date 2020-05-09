import java.util.Scanner;

public class Ejercicio2 {

	public static int sumaDigits(int numEntero) {
		if (numEntero > 0) {
			return sumaDigits(numEntero / 10) + (numEntero % 10);
		} else {
			return numEntero;
		}
	}

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Comienza el Programa.");
		System.out.print("Introduce un numero: ");
		int numEntero = lector.nextInt();

		System.out.println("Resulado de la suma: "+sumaDigits(numEntero));

		System.out.println("El Programa ha acabado.");
		lector.close();
	}

}
