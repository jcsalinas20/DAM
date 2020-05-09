import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		boolean validacion = false;

		System.out.println("Introduce un numero binario: ");
		int valor = 0;

		do {
			if (lector.hasNextInt()) {
				valor = lector.nextInt();
				if (valor >= 0) {
					validacion = true;
				} else {
					System.out.println("El numero tiene que ser mas grande de 0.");
					lector.nextLine();
				}
			} else {
				System.out.println("No has introducido un numero.");
				lector.nextLine();
			}
		} while (validacion != true);

		String intAstring = String.valueOf(valor);
		String[] numBinario = intAstring.split("");
		int[] binario = new int[numBinario.length];

		for (int i = 0; i < binario.length; i++) {
			binario[i] = Integer.parseInt(numBinario[i]);
		}

		int valorFinal = 0;
		int contador = 0;
		for (int i = numBinario.length - 1; i >= 0; i--) {
			if (binario[i] == 1) {
				valorFinal += (int) Math.pow(2, contador);
			}
			contador++;
		}

		System.out.print("Numero en decimal: " + valorFinal);

		lector.close();
	}

}
