import java.util.Scanner;

public class CambioBaseX {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.print("Introduiex un numero: ");
		int valor = lector.nextInt();

		System.out.print("Introduiex a la base a la que vols cambiar: ");
		int base = lector.nextInt();

		int contador = 0;
		double binario = 0;
		while (valor != 0) {
			int num = valor % base;
			binario = binario + num * Math.pow(10, contador);
			valor = valor / base;
			contador++;
		}

		System.out.print("Resultado: " + (int) binario);

		lector.close();
	}

}
