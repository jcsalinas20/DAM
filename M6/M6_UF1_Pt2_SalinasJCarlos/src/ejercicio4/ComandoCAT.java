package ejercicio4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ComandoCAT {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner lector = new Scanner(System.in);// Variable scanner del sistema.

//		while infinito
		while (true) {
			System.out.println("Introduce la ruta del fichero:");// Mensaje
			String fichero = lector.nextLine();// Lectura del texto introducido.
			if (fichero.equals("fin")) {// Si en la ruta pones "fin" se termina el programa.
				System.out.println("El programa ha finalizado.");// Mensaje
				break;// Salida del bucle while
			}
			File ruta = new File(fichero);// Ruta del fichero
			if (ruta.exists()) {// Comprobacion si existe el fichero.
				if (ruta.isFile()) {// Comprobacion si es un fichero.
					Scanner lectorFichero = new Scanner(ruta);// Variable scanner del fichero.
					int contadorLineas = 1;// Contador de la linea actual.

					while (lectorFichero.hasNextLine()) {// Comprobacion si en la siguiente linea hay texto.
						System.out.println(contadorLineas + "\t" + lectorFichero.nextLine());// Mensaje con el texto del
																								// fichero.
						contadorLineas++;// Suma del contador de lineas.
					}

					lectorFichero.close();// Cierre de la varible scanner del fichero.
				} else {
					System.out.println("La ruta introducida no es un fichero, es un directorio.");// Mensaje
				}
			} else {
				System.out.println("La ruta introducida no existe.");// Mensaje
			}
			System.out.println();// Print para pasar de linea
		}

		lector.close();// Cierre de la varible scanner del sistema.

	}

}
