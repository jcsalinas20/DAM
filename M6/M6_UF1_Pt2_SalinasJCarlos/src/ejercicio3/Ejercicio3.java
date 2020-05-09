package ejercicio3;

import java.io.File;
import java.io.IOException;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {

		File directorio = new File("myFiles");// Ruta del directorio.
		File fichero1 = new File(directorio + File.separator + "fichero1.txt");// Ruta del fichero1
		File fichero2 = new File(directorio + File.separator + "fichero2.txt");// Ruta del fichero2
		File ficheroRenombrado = new File(fichero2.getParent() + File.separator + "ficheroRenombrado.txt");// Ruta del
																											// ficheroRenombrado

		borrarTodo(directorio, fichero1, fichero2, ficheroRenombrado);// Borrar todos los Files

		creacionCarpeta(directorio);// Creacion del directorio principal.

		creacionFicheros(fichero1, fichero2);// Creacion de los 2 ficheros principales

		renombrarFichero2(fichero2, ficheroRenombrado);// Cambio de nombre al fichero2

		mostrarContenido(directorio);// Mostrar todo el contenido del directorio principal

		borrarFichero1(fichero1);// Borra el fichero1

		mostrarContenido(directorio);// Mostrar todo el contenido del directorio principal

	}

//	 Borra el fichero1
	private static void borrarFichero1(File fichero1) {
		System.out.println("\nSe ha borrado fichero1: " + fichero1.delete());
	}

//	 Mostrar todo el contenido del directorio principal
	private static void mostrarContenido(File directorio) {
		System.out.println("\nLista de ficheros y carpetas:");
		File[] lista = directorio.listFiles();

		for (int i = 0; i < lista.length; i++) {
			System.out.println(lista[i].getPath());
		}
	}

//	 Cambio de nombre al fichero2
	private static void renombrarFichero2(File fichero2, File ficheroRenombrado) {
		System.out
				.println("\nSe ha renombrado de fichero2 a ficheroRenombrado: " + fichero2.renameTo(ficheroRenombrado));
	}

//	 Creacion de los 2 ficheros principales
	private static void creacionFicheros(File fichero1, File fichero2) throws IOException {
		System.out.println("Se ha creado el fichero fichero1: " + fichero1.createNewFile());
		System.out.println("Se ha creado el fichero fichero2: " + fichero2.createNewFile());
	}

//	 Creacion del directorio principal.
	private static void creacionCarpeta(File directorio) {
		System.out.println("Se ha creado la carpeta myFiles: " + directorio.mkdir());
	}

//	 Borrar todos los Files
	private static void borrarTodo(File directorio, File fichero1, File fichero2, File ficheroRenombrado) {
		fichero1.delete();
		fichero2.delete();
		ficheroRenombrado.delete();
		directorio.delete();
	}

}
