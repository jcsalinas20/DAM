import java.io.File;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce la ruta:");
		String nombreRuta = lector.next();
		File ruta = new File(nombreRuta);

		System.out.print("Escribe el nombre del documento: ");
		String documento = lector.next();

		tree(ruta, documento);

		lector.close();
	}

	public static void tree(File ruta, String documento) {

		File lista[] = ruta.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				tree(lista[i], documento);
			} else if (documento.equals(lista[i].getName())) {
				System.out.println(lista[i].getPath());
			}
		}
	}

}
