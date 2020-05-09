package ejercicio.POObasico.Cajero;

import java.util.Scanner;

public class Main {
	static boolean fi = false;

	public static void main(String[] args) {
		Banco cliente = new Banco(012516, "Carlos", 5000, 3080);
		Scanner lector = new Scanner(System.in);
		while (!fi) {
			System.out.println("1. Mostrar todos los datos\r\n" + "2. Mostrar saldo\r\n" + "3. Ingresar dinero\r\n"
					+ "4. Retirar dinero\r\n" + "5. Salir\r\n");
			System.out.print("Elige una opcion: ");
			int opcion = lector.nextInt();

			switch (opcion) {
			case 1:
				System.out.println(cliente.toString());
				break;
			case 2:
				System.out.println("Saldo: " + cliente.getSaldo());
				break;
			case 3:
				System.out.print("Introduce un numero:");
				int valor =lector.nextInt();
				cliente.setSaldo(valor, opcion);
				break;
			case 4:
				System.out.print("Introduce un numero:");
				valor =lector.nextInt();
				cliente.setSaldo(valor, opcion);
				break;
			case 5:
				System.out.println("Has salido del programa.");
				fi = true;
				break;
			}
		}
		lector.close();
	}

}
