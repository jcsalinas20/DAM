package ejercicios.metodosFile;

import java.io.File;

public class MostrarPorTamaño {

	public static void main(String[] args) {
		File path = new File("MostrarTamano");
		tree(path);
	}

	// MOSTRAR CARPETAS Y SUB CARPETAS DE ORIGEN
	public static void tree(File path) {
		if (path.exists() == true) {
			File lista[] = path.listFiles();
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].isFile()) {
					if (lista[i].length() > 512000) {//512000 = 500KB
						System.out.println(lista[i]);
					}
				}
			}
		} else {
			System.out.println("La ruta introducida no existe.");
		}
	}

}
