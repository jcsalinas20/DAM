package main;

public class Validaciones {

	private static boolean validacion = false;

	public static int validarAtaque() {
		validacion = false;
		int ataque = 0;
		do {
			if (Main.lector.hasNextInt()) {
				ataque = Main.lector.nextInt();
				if (ataque > 0) {
					validacion = true;
				} else {
					System.out.print("El numero tiene que ser positivo y mayor de 0\n-> ");
					Main.lector.nextLine();
				}
			} else {
				System.out.print("Debes introducir un numero.\n-> ");
				Main.lector.nextLine();
			}
		} while (!validacion);
		return ataque;
	}

	public static int comprobarOpcion() {
		validacion = false;
		int opcion = 0;
		do {
			if (Main.lector.hasNextInt()) {
				opcion = Main.lector.nextInt();
				if (opcion > 0 && opcion < 7) {
					validacion = true;
				} else {
					System.out.print("Introduce un numero del 1 al 6.\n-> ");
					Main.lector.nextLine();
				}
			} else {
				System.out.print("Debes introducir un numero.\n-> ");
				Main.lector.nextLine();
			}
		} while (!validacion);
		return opcion;
	}

	public static int validarID() {
		validacion = false;
		int id = 0;
		do {
			if (Main.lector.hasNextInt()) {
				id = Main.lector.nextInt();
				validacion = true;
			} else {
				System.out.print("Debes introducir un numero.\n-> ");
				Main.lector.nextLine();
			}
		} while (!validacion);
		return id;
	}

}
