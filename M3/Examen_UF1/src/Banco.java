import java.util.Scanner;

public class Banco {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		boolean fi = false;
		int saldo = 1000;

		System.out.println("Su saldo inicial es de 1000.\n");
		while (!fi) {
			boolean validacion = false;
			System.out.println("1. Ver saldo.\n" + "2. Ingresar dinero.\n" + "3. Retira dinero.\n" + "4. Salir.\n");
			System.out.print("Introduce una opcion: ");
			int opcion = 0;
			do {
				if (lector.hasNextInt()) {
					opcion = lector.nextInt();
					if (opcion > 0 && opcion < 5) {
						validacion = true;
					} else {
						lector.nextLine();
					}
				} else {
					lector.nextLine();
				}
			} while (validacion != true);

			switch (opcion) {
			case 1:
				System.out.println("Saldo actual: " + saldo);
				break;
			case 2:
				System.out.println("Saldo a ingresar: ");
				int valor = 0;
				validacion = false;
				do {
					if (lector.hasNextInt()) {
						valor = lector.nextInt();
						if (valor > 0) {
							validacion = true;
						} else {
							lector.nextLine();
						}
					} else {
						lector.nextLine();
					}
				} while (validacion != true);
				saldo += valor;
				System.out.println("Saldo actual: " + saldo);
				break;
			case 3:
				System.out.println("Saldo a retirar: ");
				valor = 0;
				validacion = false;
				do {
					if (lector.hasNextInt()) {
						valor = lector.nextInt();
						if (valor > 0) {
							validacion = true;
						} else {
							lector.nextLine();
						}
					} else {
						lector.nextLine();
					}
				} while (validacion != true);
				saldo -= valor;
				System.out.println("Saldo actual: " + saldo);
				break;
			case 4:
				fi = true;
				break;
			}
			System.out.println();
			System.out.println();
			System.out.println();
		}
		lector.close();
	}

}
