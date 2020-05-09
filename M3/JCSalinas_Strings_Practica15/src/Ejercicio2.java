import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String frase = new String();

		System.out.println("Introduce una frase:");
		frase = lector.nextLine();

		System.out.println("Orden Inverso");
		for (int i = frase.length() - 1; i >= 0; i--) {
			System.out.print(frase.charAt(i));
		}

		lector.close();
	}

}
