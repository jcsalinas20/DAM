package ejercicio5;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

//¿Qué ocurre? Se elimina todo el texto que habia en el fichro. ¿Cómo lo solucionamos? Guardando todo lo que habia en el fichero anteriormente y ponero en el nuevo.

public class FrasesMatrix {

	public static void main(String[] args) throws IOException {
		File ruta = new File("frasesMatrix.txt");// Ruta del fichero.
		comprobacionSiExisteRuta(ruta);// Metodo para crear el fichero

		Scanner lector = new Scanner(ruta);// Scanner para leer el fichero.

		String textoDelFichero = "";// Variable para almacenar lo que hay en el fichero
		while (lector.hasNextLine()) {
			textoDelFichero += lector.nextLine() + "\n";// Guardar cada linea
		}

		lector.close();// Cierre del lector

		PrintStream escriptor = new PrintStream(ruta);// PrintStream para poder escribir en el fichero

		// Nuevo mensaje que se introduce en el fichero.
		escriptor.println("Yo solo puedo mostrarte la puerta, tu eres quien la tiene que atravesar.");
		escriptor.print(textoDelFichero);// Escribimos todos el texto que tenia el fichero anterirmente

		escriptor.close();// Cierre del escriptor

		System.out.println("Frase escrita correctamente en el fichero.");// Mensaje
	}

	private static void comprobacionSiExisteRuta(File ruta) throws IOException {
		if (!ruta.exists()) {// Si no existe se crea el fichero.
			ruta.createNewFile();
		}
	}

}
