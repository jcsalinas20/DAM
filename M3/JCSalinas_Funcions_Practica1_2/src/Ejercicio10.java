public class Ejercicio10 {

	public static void main(String[] args) {
		int posiciones = 0;
		int[] array = { 1, 2, 3, 4, 6, 5 };
		int num1 = 6;

		System.out.println("Posicion: " + funcionA(posiciones, array, num1));
	}

	public static int funcionA(int posiciones, int[] array, int num1) {
		int resultado = 0;
		if (posiciones >= array.length) {
			resultado = -1;
			return 0;
		}
		if (array[posiciones] == num1) {
			resultado = posiciones;
			return resultado;
		} else {
			resultado = funcionA(posiciones + 1, array, num1);
			return resultado;
		}
	}

}
