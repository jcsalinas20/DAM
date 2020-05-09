package ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner lector = new Scanner(System.in);
		System.out.println(
				"Introduce la \"ruta del fichero\" \"caracter a eliminar\" (necesario ponerlo entre \"\")");
		String[] parametros = lector.nextLine().split("\"");
		for (int i = 0; i < parametros.length; i++) {
			if (i % 2 == 1) {
				if (!new File(parametros[1]).exists()) {
					System.out.println("No se ha encontrado el fichero.");
					return;
				}
				if (parametros[i].isEmpty() || parametros.length != 4) {
					System.out.println("No se han introducido bien los parametros.");
					return;
				}
				if (parametros[3].length() > 1) {
					System.out.println("Solo se permite 1 caracter.");
					return;
				}
			}
		}

		ArrayList<String> texto = new ArrayList<String>();
		Scanner lectorFichero = new Scanner(new File(parametros[1]));
		while (lectorFichero.hasNext()) {
			texto.add(lectorFichero.nextLine());
		}
		lectorFichero.close();

		String[] textoCambiado = new String[texto.size()];
		for (int i = 0; i < texto.size(); i++) {
			textoCambiado[i] = texto.get(i).replaceAll(parametros[3], "");
		}

		PrintStream escriptor = new PrintStream(new File(parametros[1]));
		for (int i = 0; i < textoCambiado.length; i++) {
			escriptor.println(textoCambiado[i]);
		}
		escriptor.close();
		lector.close();
		
		System.out.println("\nEcho");
	}

}
