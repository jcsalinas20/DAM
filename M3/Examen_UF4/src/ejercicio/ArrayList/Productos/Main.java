package ejercicio.ArrayList.Productos;

import java.util.Scanner;

public class Main {
	static boolean fi = false;
	static Scanner lector = new Scanner(System.in);
	static ArrayProducte ap = new ArrayProducte();

	public static void main(String[] args) {
		while (!fi) {
			menu();

			System.out.print("Introduce una opcion: ");
			int opcion = lector.nextInt();

			opcionElegida(opcion);
		}

	}

	private static void opcionElegida(int opcion) {
		switch (opcion) {
		case 1:
			ap.agregar();
			break;
		case 2:
			ap.grandaria();
			break;
		case 3:
			ap.eliminar();
			break;
		case 4:
			ap.obtenir();
			break;
		case 5:
			fi = true;
			break;

		default:
			break;
		}

	}

	private static void menu() {
		System.out.println("1. Agregar producto\n" + "2. Aumentar precio de oficina\n"
				+ "3. Eliminar productos con stock en 0\n" + "4. Mostrar todos los productos\n" + "5. Salir\n");
	}

}
