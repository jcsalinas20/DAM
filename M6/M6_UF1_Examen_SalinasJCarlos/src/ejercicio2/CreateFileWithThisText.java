package ejercicio2;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CreateFileWithThisText {

	public static void main(String[] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		System.out.print("Introduce el nombre del fichero:");
		File ruta = new File(lector.nextLine());
		System.out.println("Introduce el contenido del fichero (-1 para terminar):");

		String texto = "";
		while (true) {
			String frase = lector.nextLine();
			if (frase.equals("-1")) {
				break;
			} else {
				texto += frase + "\n";
			}
		}

		if (!ruta.exists()) {
			ruta.createNewFile();
			System.out.println("\nEl fichero se ha creado correctamente.");
		}else {
			System.out.println("\nEl fichero ya existia se ha reemplazado todo el texto por el nuevo.");
		}

		PrintStream escriptor = new PrintStream(ruta);

		escriptor.print(texto);

		escriptor.close();
		lector.close();
		System.out.println("\n\nEcho");
	}

}
