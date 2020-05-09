import java.io.*;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		try {
			File path = new File("Ejercicio2.txt");
			Scanner lector = new Scanner(System.in);
			PrintStream escriptorFichero = new PrintStream(path);
			Scanner lectorFichero = new Scanner(path);
			boolean fi = false;

			while (!fi) {
				System.out.println("1. Crear Fichero\n2. Mostra Fichero\n3. Salir\n");
				System.out.println("Introduce una opcion");
				int opcion = lector.nextInt();
				switch (opcion) {
				case 1:
					System.out.println("Se han escrito los datos.");
					escriptorFichero.println("Juan Carlos");
					escriptorFichero.println("Salinas Navarrete");
					escriptorFichero.println("19");
					break;
				case 2:
					System.out.println("Fichero " + path.getName());
					while (lectorFichero.hasNextLine()) {
						System.out.println(lectorFichero.nextLine());
					}
					break;
				case 3:
					fi = true;
					System.out.println("Has salido del programa.");
					break;

				default:
					break;
				}
				System.out.println("\n");
			}

			lectorFichero.close();
			escriptorFichero.close();
			lector.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
