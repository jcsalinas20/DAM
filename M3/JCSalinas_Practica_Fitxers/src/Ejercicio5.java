import java.io.File;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		File path = new File("/Programacio");
		Scanner lector = new Scanner(System.in);
		boolean fi = false;

		while (!fi) {
			System.out.print(path.getAbsolutePath() + "> ");
			String comanda = lector.nextLine();
			String[] cd = comanda.split(" ");

			if (cd[0].equals("cd")) {
				path = cd(path, cd);
			} else if (comanda.equals("dir")) {
				dir(path);
			} else if (comanda.equalsIgnoreCase("fi")) {
				System.out.println("Fin del programa.");
				fi = true;
			} else {
				System.out.println("Las comandas son: " + "\ncd .. ; cd nombreCarpeta ; dir ; fi");
			}
		}

	}

	public static File cd(File path, String[] comandaCD) {
		if (comandaCD[1].equals("..")) {
			if (path.getName().equals("Programacio")) {
				System.out.println("No se puede retroceder mas.");
			} else {
				path = path.getParentFile();
			}
		} else {
			String[] lista = path.list();
			boolean rutaCorrecta = false;
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].equals(comandaCD[1])) {
					path = new File(path + path.separator + comandaCD[1]);
					rutaCorrecta = true;
				}
			}
			if (rutaCorrecta == false) {
				System.out.println("Este directorio no existe.");
			}
		}
		return path;
	}

	public static void dir(File path) {
		File dir[] = path.listFiles();

		for (int i = 0; i < dir.length; i++) {
			if (dir[i].isDirectory()) {
				System.out.print("[DIR] ");
			} else {
				System.out.print("[FILE] ");
			}
			System.out.println(dir[i].getName());
		}
		System.out.println();
	}

}
