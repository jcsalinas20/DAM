package ejercicio6;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class EscribeLineas {

	public static void main(String[] args) throws IOException {
		Scanner lector = new Scanner(System.in);// Scanner del sistema
		File ruta = new File("escribeLineas.txt");// Ruta del fichero
		comprobacionSiExisteRuta(ruta);// Metodo para crear el fichero

		PrintStream escriptor = new PrintStream(ruta);// PrintStream para escribir en el fichero

		System.out.println("Escribe 10 lineas para terminar el programa.");// Mensaje
		int contadorLineas = 1;// Contador de lineas

//		Bucle hasta llegar a 11 lineas
		while (contadorLineas < 11) {
			System.out.println("Linea " + contadorLineas + ": ");// Mensaje con el numero de linea por el que va.
			if (lector.hasNextLine()) {
				contadorLineas++;// Suma 1 cada vez que salte de linea
			}
			escriptor.println(lector.nextLine());// Escribirlo en el fichero
		}

		escriptor.close();// Cierre del PrintStream
		lector.close();// Cierre del Scanner
	}

//	 Metodo para crear el fichero
	private static void comprobacionSiExisteRuta(File ruta) throws IOException {
		if (!ruta.exists()) {
			ruta.createNewFile();
		}
	}
}
