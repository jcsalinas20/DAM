import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		try {
			File archivo = new File("Ejercicio3.txt");

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			if (archivo.exists()) {
				Scanner lector = new Scanner(System.in);
				PrintStream escriptorFichero = new PrintStream(archivo);
				Scanner lectorFichero = new Scanner(archivo);

				System.out.println("Introduce el texto: ");
				String texto = lector.nextLine();

				String[] caracteres = texto.split("");
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
					texto = frase;
				}

				escriptorFichero.print(texto);
				lectorFichero.close();
				escriptorFichero.close();
				lector.close();
			}
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
