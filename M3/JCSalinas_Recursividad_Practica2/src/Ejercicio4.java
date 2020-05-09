
public class Ejercicio4 {

	public static void main(String[] args) {
		int valor = 6;
		int resultado = 0;

		System.out.println(sumaPositiusParells(valor, resultado));

	}

	public static int sumaPositiusParells(int valor, int resultado) {
		if (valor == 2) {
			return resultado = resultado + valor;
		} else {
			if (valor % 2 == 0) {
				return sumaPositiusParells(valor - 1, resultado + valor);
			} else {
				return sumaPositiusParells(valor - 1, resultado);
			}
		}
	}

}
