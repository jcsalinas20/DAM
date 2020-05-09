

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			File archivo = new File("MostrarTamano/1.txt");
			Scanner lectorFichero = new Scanner(archivo);
			PrintStream escriptorFichero = new PrintStream(archivo);

			if (archivo.exists()) {

			}

			escriptorFichero.close();
			lectorFichero.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
