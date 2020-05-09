import java.util.Scanner;

public class Num_A_Binario {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.print("Introduiex un numero: ");
		int valor = lector.nextInt();

		int contador = 0;
		double binario = 0;
		while (valor != 0) {
			int num = valor % 2;
			binario = binario + num * Math.pow(10, contador);
			valor = valor / 2;
			contador++;
		}

		System.out.print("Resultado: " + (int) binario);

		lector.close();
	}

}
