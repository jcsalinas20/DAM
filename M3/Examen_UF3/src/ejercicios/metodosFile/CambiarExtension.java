package ejercicios.metodosFile;

import java.io.File;
import java.util.Scanner;

public class CambiarExtension {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String extensionOrigen = null;
		String extensionDestino = null;
		boolean requisitosOrigen = false;
		boolean requisitosDestino = false;
		String[] documentosConExtensionOrigen = null;

		System.out.println("Introduce la extension a buscar y a la que cambiar.");
		String cadenaExtensiones = lector.nextLine();
		String[] extensionesSeparadas = cadenaExtensiones.split(" ");
		for (int i = 0; i < extensionesSeparadas.length; i++) {
			String[] extension = extensionesSeparadas[i].split("");
			if (i == 0 && extension.length == 3) {
				extensionOrigen = extensionesSeparadas[i];
				requisitosOrigen = true;
			}
			if (i == 1 && extension.length == 3) {
				extensionDestino = extensionesSeparadas[i];
				requisitosDestino = true;
			}
		}
		if (requisitosDestino && requisitosOrigen) {
			System.out.println("Origen: " + extensionOrigen);
			System.out.println("Destino: " + extensionDestino);
			String dirTreball = System.getProperty("user.dir");
			File origen = new File(System.setProperty("user.dir", dirTreball) + "\\CambiarExtension");

			tree(origen, documentosConExtensionOrigen, extensionOrigen, extensionDestino);

		} else {
			System.out.println("No se cumplen los requisitos necesarios para continuar.");
		}
		lector.close();
	}

	// MOSTRAR CARPETAS Y SUB CARPETAS DE ORIGEN
	public static void tree(File origen, String[] documentos, String extensionOrigen, String extensionDestino) {
		if (origen.exists() == true) {
			File lista[] = origen.listFiles();
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].isDirectory()) {
					tree(lista[i], documentos, extensionOrigen, extensionDestino);
				} else {
					String archivo = lista[i].getAbsolutePath();
					String[] comprobarExtension = archivo.split("\\.");
					if (comprobarExtension[comprobarExtension.length - 1].equals(extensionOrigen)) {
						comprobarExtension[comprobarExtension.length - 1] = extensionDestino;
						String nombreDestino = "";
						for (int j = 0; j < comprobarExtension.length; j++) {
							if (j == comprobarExtension.length - 1) {
								nombreDestino += comprobarExtension[j];
							} else {
								nombreDestino += comprobarExtension[j] + ".";
							}
						}
						cambiarNombre(nombreDestino, lista[i]);
					}
				}
			}
		} else {
			System.out.println("La ruta introducida no existe.");
		}
	}

	private static void cambiarNombre(String nombreDestino, File origen) {
		File destino = new File(nombreDestino);
		System.out.println(destino.getAbsolutePath() + ": " + origen.renameTo(destino));
	}
}
