import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		int eleccion = 0;
		int num1 = 0;
		int saldo = 1000;
		boolean seguir = true;
		String seguir2 = "";
		boolean validacion = false;

		while (seguir != false) {
			System.out.println("CAIXER SANTANDER" + "\n1 - Retirar Efectivo" + "\n2 - Ingresar"
					+ "\n3 - Consultar el Saldo" + "\n4 - Salir");

			eleccion = 0;
			do {
				System.out.print("Indique la operacion: ");
				if (lector.hasNextInt()) {
					eleccion = lector.nextInt();
					if (eleccion >= 1 && eleccion <= 4) {
						validacion = true;
					} else {
						System.out.println("El numero tiene que ser entre 1 y 4.");
					}
				} else {
					lector.nextLine();
				}
			} while (validacion != true);

			validacion = false;

			switch (eleccion) {
			case 1:
				System.out.println("\nCuanto deseas Retirar? tu saldo es de " + saldo + ".");
				do {
					if (lector.hasNextInt()) {
						num1 = lector.nextInt();
						if (num1 >= 0 && num1<=saldo) {
							validacion = true;
						} else {
							System.out.println("Introduce un numero positivo o menor que tu saldo.");
						}
					} else {
						lector.nextLine();
					}
				} while (validacion != true);
				saldo = saldo - num1;
				System.out.println("Tu saldo ahora mismo es de " + saldo + ".");
				break;

			case 2:
				System.out.println("\nCuanto deseas Ingresar? tu saldo es de " + saldo + ".");
				do {
					if (lector.hasNextInt()) {
						num1 = lector.nextInt();
						if (num1 >= 0) {
							validacion = true;
						} else  {
							System.out.println("Introduce un numero positivo.");
						}
					} else {
						lector.nextLine();
					}
				} while (validacion != true);
				saldo = saldo + num1;
				System.out.println("Tu saldo ahora mismo es de " + saldo + ".");
				break;

			case 3:
				System.out.println("Tu saldo ahora mismo es de " + saldo + ".");
				break;

			case 4:
				seguir = false;
				break;
			}

			if (seguir == true) {
				System.out.println("Quieres Salir? Si o No.");
				validacion = false;
				do {
					seguir2 = lector.next();
					if (seguir2.equalsIgnoreCase("No")) {
						validacion = true;
					} else if (seguir2.equalsIgnoreCase("Si")) {
						seguir = false;
						validacion = true;
					}
				} while (validacion != true);
			}
		}
		lector.close();
	}

}
