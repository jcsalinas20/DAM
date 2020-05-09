import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		// VARIABLES
		Scanner lector = new Scanner(System.in);
		int eleccion = 0;
		float num1 = 0f;
		float num2 = 0f;
		float total = 0f;
		boolean seguir = true;
		String seguir2 = "";
		boolean validacion = false;

		while (seguir != false) {
			System.out.println("CALCULADORA" + "\n1 - Sumar" + "\n2 - Restar" + "\n3 - Multiplicar" + "\n4 - Dividir");
				
			do {
				System.out.print("Introduce un numero de la operacion: ");
				if (lector.hasNextInt()) {
					eleccion = lector.nextInt();
					if (eleccion >= 0 && eleccion <= 4) {
						validacion = true;
					} else {
						System.out.println("El numero tiene que ser mas grande que 0 y mas pequeno que 5.");
					}
				} else {
					lector.nextLine();
				}
			} while (validacion != true);

			validacion = false;
			do {
				System.out.println("\nIntroduce el Primer numero: ");
				if (lector.hasNextFloat()) {
					num1 = lector.nextFloat();
					validacion = true;

				} else {
					lector.nextLine();
				}
			} while (validacion != true);

			validacion = false;
			do {
				System.out.println("\nIntroduce el Segundo numero: ");
				if (lector.hasNextFloat()) {
					num2 = lector.nextFloat();
					validacion = true;
				} else {
					lector.nextLine();
				}
			} while (validacion != true);

			switch (eleccion) {
			case 1:
				total = num1 + num2;
				break;

			case 2:
				total = num1 - num2;
				break;

			case 3:
				total = num1 * num2;
				break;

			case 4:
				total = num1 / num2;
				break;
			}

			System.out.printf("Resultado Final: %.3f", total);

			System.out.println("\n\nOperacion Terminada" + "\nQuieres volver a hacer otra Operacion? Si o No.");

			validacion = false;
			do {
				seguir2 = lector.next();
				if (seguir2.equalsIgnoreCase("No")) {
					System.out.println("Has salido de la CALCULADORA.");
					seguir = false;
					validacion = true;
				} else if (seguir2.equalsIgnoreCase("Si")) {
					System.out.println("Sigues con la CALCULADORA.");
					validacion = true;
				}
			} while (validacion != true);
		}
		lector.close();
	}
}
