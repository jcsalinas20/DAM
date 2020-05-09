package ejercicios.metodosFile;

import java.io.File;
import java.util.Scanner;

public class BuscarDocumento {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		File path = new File(File.separator);

		System.out.println("Introduce el nombre del fichero que buscar");
		String nombre = lector.next();
		lector.nextLine();
		System.out.println(
				"Introduce la ruta de la carpeta (C:\\Users\\jcsal\\OneDrive\\Documentos\\Mis Programas\\Examen_UF3\\CambiarExtension)");
		String ruta = lector.nextLine();
		path = new File(ruta);

		tree(path, nombre);

		lector.close();
	}

	// MOSTRAR CARPETAS Y SUB CARPETAS DE ORIGEN
	public static void tree(File path, String nombre) {
		if (path.exists() == true) {
			File lista[] = path.listFiles();
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].isDirectory()) {
					tree(lista[i], nombre);
				} else {
					if (lista[i].getName().equals(nombre)) {
						System.out.println(lista[i]);
					}
				}
			}
		} else {
			System.out.println("La ruta introducida no existe.");
		}
	}

}
