import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Comienza el Programa.");
		int contador=0;
		int[] numeros = new int[5];

		System.out.println("Introduce 5 numeros: ");
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = lector.nextInt();
		}

		System.out.println("Resultado suma de Array: " + sumaVector(numeros, contador));
		
		System.out.println("El Programa ha acabado.");
		lector.close();
	}

	public static int sumaVector(int[] numeros, int contador) {
		if (contador < numeros.length) {
			return sumaVector(numeros, contador + 1) + numeros [contador];
		} else {
			return 0;
		}

	}
	
}
