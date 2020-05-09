
public class Ejercicio5 {

	public static void main(String[] args) {
		int a = 12, b = 18, contador = 1, resultado = 0;

		System.out.println(MCD(a, b, contador, resultado));
	}

	public static int MCD(int a, int b, int contador, int resultado) {
		if (a == contador || b == contador) {
			return resultado;
		} else {
			if (a % contador == 0 && b % contador == 0) {
				return MCD(a, b, contador + 1, resultado = contador);
			} else {
				return MCD(a, b, contador + 1, resultado);
			}
		}
	}

}
