import java.io.File;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);

		System.out.println("Introduce la ruta:");
		String nombreRuta = lector.next();
		File ruta = new File(nombreRuta);

		tree(ruta);

		lector.close();
	}

	public static void tree(File ruta) {

		if (ruta.exists() == true) {
			File lista[] = ruta.listFiles();
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].isDirectory()) {
					tree(lista[i]);
				} else if (lista[i].length() >= 500) {
					System.out.println(lista[i].getPath() + " (" + lista[i].length() + " Kb)");
				}
			}
		} else {
			System.out.println("La ruta introducida no es valida.");
		}
	}

}
