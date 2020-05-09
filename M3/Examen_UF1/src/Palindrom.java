import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		boolean fi = false;

		while (!fi) {
			String parteIzquierda = "";
			String parteDerecha = "";
			System.out.println("Introduce una frase: ");
			String frase = lector.nextLine();
			if (!frase.equalsIgnoreCase("sortir")) {
				frase = frase.replaceAll(" *", "");
				String[] fraseEntera = frase.split("");
				for (int i = 0; i <= fraseEntera.length / 2; i++) {
					parteIzquierda += fraseEntera[i];
				}
				for (int i = fraseEntera.length / 2; i < fraseEntera.length; i++) {
					parteDerecha = fraseEntera[i] + parteDerecha;
				}

				System.out.println(parteIzquierda);
				System.out.println(parteDerecha);
				System.out.println("El resultado es " + parteIzquierda.equalsIgnoreCase(parteDerecha));
			} else {
				fi = true;
			}
		}

		lector.close();

	}

}
