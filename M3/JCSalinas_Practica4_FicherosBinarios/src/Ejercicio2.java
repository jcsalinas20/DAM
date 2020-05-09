import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		try {
			Scanner lector = new Scanner(System.in);
			File path = new File("");
			boolean fi = false;
			String texto = "";
			boolean creacionArchivo = false;
			while (!creacionArchivo) {
				System.out.println("Introduce el nombre del archivo: ");
				String fichero = lector.next();
				path = new File(fichero);
				if (path.exists() == true) {
					System.out.println("Este archivo ya esta creado.\nIntroduce otro nombre.");
				} else {
					path.createNewFile();
					System.out.println("El archivo ha sido creado.");
					creacionArchivo = true;
				}
			}
			PrintStream escriptor = new PrintStream(path);
			System.out.println("Introduce text para el fichero (\".\" para parar).");
			while (!fi) {
				texto = lector.nextLine();
				if (lector.hasNext(".")) {
					escriptor.println(texto);
					fi = true;
				} else {
					escriptor.println(texto);
				}
			}
			escriptor.close();
			lector.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
