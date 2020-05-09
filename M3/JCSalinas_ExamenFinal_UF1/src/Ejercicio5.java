import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		boolean seguir = true;
		boolean validacion = false;
		String seguir2 = "";

		while (seguir != false) {

			System.out.println("Introduce una frase: ");
			String frase = lector.nextLine();

			frase = frase.replaceAll(" *", "");

			String mitad = frase.substring(0, frase.length() / 2);
			frase = frase.substring(frase.length() / 2, frase.length());

			System.out.println(frase);
			System.out.println(mitad);

			System.out.println("El resultado es " + frase.equalsIgnoreCase(mitad));

			System.out.println("Quieres Salir? Si o No.");
			validacion = false;
			do {
				seguir2 = lector.next();
				if (seguir2.equalsIgnoreCase("No")) {
					validacion = true;
				} else if (seguir2.equalsIgnoreCase("Si")) {
					seguir = false;
					validacion = true;
				}
			} while (validacion != true);
			lector.close();
		}
	}
}
