import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String texto = "";
		String anterior = "";
		boolean fiEncontrado = false;

		System.out.println("Introduce texto hasta utiliza la palabra \"fi\"");
		while (fiEncontrado != true) {
			texto = lector.next();
			if (texto.equalsIgnoreCase("fi")) {
				fiEncontrado = true;
			} else {
				anterior = texto;
			}

		}
		System.out.println("La anterior palabra es: " + anterior);

		lector.close();
	}

}
