import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String cadena = "";
		int inicio = 0;
		int fin = 0;
		boolean veEncontrado = false;

		while (veEncontrado != true) {
			System.out.println("Introduce una frase:");
			cadena = lector.nextLine();
			
			inicio = cadena.indexOf("ve");
			fin = cadena.lastIndexOf("ve");
			
			if (inicio == -1) {
				System.out.println("No se ha encontrado ninguna coincidencia con los caracteres \"ve\"");
			} else if (inicio == fin) {
				System.out.println("Solo se ha encontrado una coincidencia con los caracteres \"ve\"");
				veEncontrado = true;
			} else {
				System.out.println("Varios \"ve\" encontrados");
				System.out.println(cadena.substring(inicio, fin + 2));
				veEncontrado = true;
			}
		}

		lector.close();
	}

}
