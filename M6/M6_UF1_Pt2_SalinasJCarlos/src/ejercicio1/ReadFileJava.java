package ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileJava {

	public static void main(String[] args) throws FileNotFoundException {
		File fichero = new File("src" + File.separator + "ejercicio1" + File.separator + "ReadFileJava.java");// Ruta relativa del mismo fichero.
		
//		Comprobacion que existe el fichero.
		if (fichero.exists()) {
			Scanner lectorFichero = new Scanner(fichero);// Variable scanner del fichero de la ruta.

			while (lectorFichero.hasNext()) {// While hasta que no ecuentre ninguna letra mas.
				System.out.println(lectorFichero.next());// Mostrar cada palabra del fichero.
			}

			lectorFichero.close();// Cierre de la varible scanner del fichero.
		}
	}

}