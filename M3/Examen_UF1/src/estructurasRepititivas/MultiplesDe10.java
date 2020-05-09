package estructurasRepititivas;

import java.util.Scanner;

public class MultiplesDe10 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int contador = 0;
		String numeroPricipal = "";

		boolean valido = false;
		int numero = 1;
		do {
			System.out.print("Introduce un numero multiple de 10: ");
			if (lector.hasNextInt()) {
				numero = lector.nextInt();
				if (numero % 10 == 0) {
					valido = true;
				} else {
					lector.nextLine();
				}
			} else {
				lector.nextLine();
			}
		} while (valido != true);

		String valor = String.valueOf(numero);
		String[] separador = valor.split("");
		for (int i = 0; i < separador.length; i++) {
			if (separador[i].equals("0")) {
				contador++;
			} else {
				numeroPricipal += separador[i];
			}
		}

		System.out.println(numero + " " + numeroPricipal + " per 10 elevat a " + contador);

		lector.close();
	}

}
