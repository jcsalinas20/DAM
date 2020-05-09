import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int contador = 0;
		int[] array = new int[3];

		for (int i = 0; i < array.length; i++) {
			array[i] = lector.nextInt();
		}

		System.out.println(multiplicarArray(array, contador));
		
		lector.close();
	}

	public static int multiplicarArray(int[] array, int contador) {
		int resultado = 1;
		if (contador < array.length) {
			return resultado = multiplicarArray(array, contador + 1) * array[contador];
		} else {
			return resultado;
		}
	}

}
