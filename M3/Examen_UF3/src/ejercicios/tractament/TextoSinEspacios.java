package ejercicios.tractament;

import java.io.File;
import java.util.Scanner;

public class TextoSinEspacios {

	public static void main(String[] args) {
		try {
			File archivo = new File("MostrarTamano/1.txt");
			Scanner lectorFichero = new Scanner(archivo);

			if (archivo.exists()) {
				while (lectorFichero.hasNextLine()) {
					String frase = lectorFichero.nextLine();
					String[] palabras = frase.split(" ");
					for (int i = 0; i < palabras.length; i++) {
						System.out.print(palabras[i]);
					}
					System.out.println();
				}
			}

			lectorFichero.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
