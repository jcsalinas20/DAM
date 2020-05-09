import java.util.Scanner;

public class Binario_A_Num {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.print("Introduiex un numero: ");
		int valor = lector.nextInt();

		String intAstring = String.valueOf(valor);
		String[] numBinario = intAstring.split("");

		int valorFinal = 0;
		int contador = 0;
		for (int i = numBinario.length - 1; i >= 0; i--) {
			if (numBinario[i].equals("1")) {
				valorFinal += (int) Math.pow(2, contador);
			}
			contador++;
		}

		System.out.print(valorFinal);

		lector.close();
	}

}
