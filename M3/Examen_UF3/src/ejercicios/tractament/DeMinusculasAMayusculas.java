package ejercicios.tractament;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class DeMinusculasAMayusculas {

	public static void main(String[] args) {
		try {
			File archivo = new File("MostrarTamano/1.txt");

			if (archivo.exists()) {
				String texto = "";
				Scanner lectorFichero = new Scanner(archivo);
				while (lectorFichero.hasNextLine()) {
					String palabra = lectorFichero.nextLine();
					String[] caracteres = palabra.split("");
					if (caracteres.length > 1) {
						for (int i = 0; i < caracteres.length; i++) {
							char letra = caracteres[i].charAt(0);
							if (letra >= 'a' && letra <= 'z') {
								letra -= 32;
								caracteres[i] = String.valueOf(letra);
							} else if (letra >= 'A' && letra <= 'Z') {
								letra += 32;
								caracteres[i] = String.valueOf(letra);
							}
							System.out.print(caracteres[i]);
						}

						System.out.println();
						String frase = "";
						for (int i = 0; i < caracteres.length; i++) {
							frase += caracteres[i];
						}
						texto += frase + "\r\n";
					}
				}
				lectorFichero.close();

				PrintStream escriptorFichero = new PrintStream(archivo);

				escriptorFichero.print(texto);

				escriptorFichero.close();
			}

		} catch (Exception e) {
//			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}

}
