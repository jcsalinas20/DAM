import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		File path = new File("/Programacio/M4M5M6/Fonts/Unitat_6");
		Scanner lector = new Scanner(System.in);
		boolean fi = false;

		while (!fi) {
			System.out.print(path.getAbsolutePath() + "> ");
			String comanda = lector.nextLine();
			String[] cdDELprop = comanda.split(" ");

			if (cdDELprop[0].equals("cd")) {
				path = cd(path, cdDELprop);
			} else if (cdDELprop[0].equals("del")) {
				path = del(path, cdDELprop);
			} else if (cdDELprop[0].equals("prop")) {
				path = prop(path, cdDELprop);
			} else if (comanda.equals("dir")) {
				dir(path);
			} else if (comanda.equalsIgnoreCase("fi")) {
				System.out.println("Fin del programa.");
				fi = true;
			} else {
				System.out.println("Las comandas son: " + "\ncd .. ; cd nombreCarpeta ; del nombreArchivo ; prop nombreArchivo ; dir ; fi");
			}
		}

	}

	public static File del(File path, String[] comandaDEL) {
		String[] lista = path.list();
		File comprobacionFichero = new File(path.getAbsolutePath() + path.separator + comandaDEL[1]);
		boolean rutaCorrecta = false;
		if (comprobacionFichero.isFile() == true) {
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].equals(comandaDEL[1])) {
					comprobacionFichero.delete();
					System.out.println("El fichero se ha borrado.");
					rutaCorrecta = true;
				}
			}
			if (rutaCorrecta == false) {
				System.out.println("Este fichero no existe.");
			}
		} else {
			System.out.println("Has introducido el nombre de un directorio");
		}
		return path;
	}

	public static File prop(File path, String[] comandaPROP) {
		String[] lista = path.list();
		File comprobacionFichero = new File(path.getAbsolutePath() + path.separator + comandaPROP[1]);
		boolean rutaCorrecta = false;
		if (comprobacionFichero.isFile() == true) {
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].equals(comandaPROP[1])) {
					long milisegundos = comprobacionFichero.lastModified();
					Date data = new Date(milisegundos);
					System.out.println("Tamano: " + comprobacionFichero.length());
					System.out.println("Modificacion: " + data);
					rutaCorrecta = true;
				}
			}
			if (rutaCorrecta == false) {
				System.out.println("Este fichero no existe.");
			}
		} else {
			System.out.println("Has introducido el nombre de un directorio.");
		}
		return path;
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
