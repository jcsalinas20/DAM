package estructurasRepititivas;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		boolean fi = false;
		System.out.println("CALCULADORA");
		System.out.println("Menu Principal\n");

		while (!fi) {
			boolean validacion = false;
			System.out
					.println("1. Suma\r\n" + "2. Resta\r\n" + "3. Multiplicar\r\n" + "4. Dividir\r\n" + "0. Salir\r\n");

			System.out.print("Introduce una opcion: ");
			int opcion = 0;
			do {
				if (lector.hasNextInt()) {
					opcion = lector.nextInt();
					validacion = true;
				} else {
					lector.nextLine();
				}
			} while (validacion != true);

			switch (opcion) {
			case 1:
				System.out.print("\nIntroduce el primer numero: ");
				int num1 = lector.nextInt();
				System.out.print("Introduce el segundo numero: ");
				int num2 = lector.nextInt();
				System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
				break;
			case 2:
				System.out.print("\nIntroduce el primer numero: ");
				num1 = lector.nextInt();
				System.out.print("Introduce el segundo numero: ");
				num2 = lector.nextInt();
				System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
				break;
			case 3:
				System.out.print("\nIntroduce el primer numero: ");
				num1 = lector.nextInt();
				System.out.print("Introduce el segundo numero: ");
				num2 = lector.nextInt();
				System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
				break;
			case 4:
				System.out.print("\nIntroduce el primer numero: ");
				num1 = lector.nextInt();
				System.out.print("Introduce el segundo numero: ");
				num2 = lector.nextInt();
				if (num2 != 0) {
					System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
				} else {
					System.out.println("Error. No se puede dividir entre 0.");
				}
				break;
			case 0:
				fi = true;
				break;

			default:
				break;
			}
			System.out.println("\n");
		}
		lector.close();
	}

}
