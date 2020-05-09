package ejercicio7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ComandoCP {

	public static void main(String[] args) throws IOException {
		Scanner lector = new Scanner(System.in);// Scanner del sistema
		File rutaOrigen = introducirRutaOrigen(lector);// Metodo para conseguir la ruta de origen

		System.out.println();// Salto de linea

		File rutaDestino = introducirRutaDestino(lector, rutaOrigen);// Metodo para conseguir la ruta de destino
		lector.close();// Cierre del Scanner

		String textoOrigen = lecturaDeOrigen(rutaOrigen);// Metodo para leer lo que habia en el fichero origen

		escrituraDeDestino(textoOrigen, rutaDestino);// Metodo para escribir lo que habia en el fichero origen al
														// destino

		System.out.println("Se copio correctamente el archivo.");// Mensaje
	}

//	 Metodo para conseguir la ruta de destino
	private static File introducirRutaDestino(Scanner lector, File rutaOrigen) throws IOException {
		File rutaDestino = new File("");// Declaracion de la varible ruta destino

		System.out.println("Introduce la ruta de destino:");// Mensaje para que introduzca la ruta destino
		String destino = lector.nextLine();// Guardar en una varible lo que se haya escrito
		rutaDestino = new File(destino);// Meter en la varible ruta la variable string
		rutaDestino = comprobarSiEsUnaCarpeta(rutaDestino, destino, rutaOrigen);// Metodo para comprobar si es una
																				// carpeta
		comprobarSiExiste(rutaDestino);// Metodo para comprobar si existe.

		return rutaDestino;// Devolver la ruta
	}

//	 Metodo para comprobar si existe la rutaDestino
	private static void comprobarSiExiste(File rutaDestino) throws IOException {
		if (!rutaDestino.exists()) {
			rutaDestino.createNewFile();
		}
	}

//	 Metodo para comprobar si es una carpeta
	private static File comprobarSiEsUnaCarpeta(File rutaDestino, String destino, File rutaOrigen) {
//		Si es un directorio coge el nombre del fichero de la ruta origen y se lo pone en la ruta destino
		if (rutaDestino.isDirectory()) {
			rutaDestino = new File(destino + File.separator + rutaOrigen.getName());
		}
		return rutaDestino;// Devolver la ruta destino
	}

//	 Metodo para conseguir la ruta de origen
	private static File introducirRutaOrigen(Scanner lector) {
		File rutaOrigen = new File("");// Declaracion de la varible ruta origen
		do {
			System.out.println("Introduce la ruta de origen:");// Mensaje para que introduzca la ruta origen
			String origen = lector.nextLine();// Guardar en una varible lo que se haya escrito
			rutaOrigen = new File(origen);// Meter en la varible ruta la variable string
		} while (!rutaOrigen.isFile());// Comprobacion si la ruta es un fichero, si no lo es se repite el proceso

		return rutaOrigen;// Devolver ruta
	}

//	 Metodo para escribir lo que habia en el fichero origen al destino
	private static void escrituraDeDestino(String textoOrigen, File rutaDestino) throws FileNotFoundException {
		PrintStream escriptor = new PrintStream(rutaDestino);// PrintStream para escribir en la ruta destino
		escriptor.print(textoOrigen);// Print para escribir lo que tenia el fichero origen
		escriptor.close();// Cierre de escriptor
	}

//	 Metodo para leer lo que habia en el fichero origen
	private static String lecturaDeOrigen(File rutaOrigen) throws FileNotFoundException {
		Scanner lectorFichero = new Scanner(rutaOrigen);// Scanner de la ruta origen
		String textoOrigen = "";// String para guardar el texto del fichero
		while (lectorFichero.hasNextLine()) {
			textoOrigen += lectorFichero.nextLine() + "\n";// Guardar en el String cada linea
		}
		lectorFichero.close();// Cierre del Scanner

		return textoOrigen;// Devolver el texo del fichero origen
	}

}
