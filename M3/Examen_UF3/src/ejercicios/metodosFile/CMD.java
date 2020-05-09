package ejercicios.metodosFile;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class CMD {
	static File path = new File("MostrarTamano");

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		boolean fi = false;
		if (path.exists()) {
			while (!fi) {
				System.out.println(path.getAbsolutePath() + "> ");
				String comando = lector.nextLine();
				String[] revisionComando = comando.split(" ");
				String opcion = revisionComando[0];

				fi = acciones(opcion, comando, fi);
				System.out.println();
			}
		} else {
			System.out.println("Revisa la ruta.");
		}
		lector.close();
	}

	private static boolean acciones(String opcion, String comando, boolean fi) {
		switch (opcion) {
		case "cd":
			cd(comando);
			break;
		case "dir":
			dir();
			break;
		case "del":
			del(comando);
			break;
		case "prop":
			prop(comando);
			break;
		case "fi":
			System.out.println("Fi del programa!");
			return fi = true;
		default:
			System.out.println("Comanda incorrecta!");
			break;
		}
		return fi = false;
	}

	private static void prop(String comando) {
		String[] comandoDividido = comando.split(" ");
		String nombre = comandoDividido[1];
		File prop = new File(path.getAbsolutePath() + File.separator + nombre);
		if (prop.isFile()) {
			Date data = new Date(prop.lastModified());
			System.out.println("Mida: " + (prop.length() / 1024) + "KB");
			System.out.println("Modificacio: " + data);
		} else {
			System.out.println("No se pueden mostrar las propiedades de una carpeta.");
		}
	}

	private static void del(String comando) {
		String[] comandoDividido = comando.split(" ");
		String nombre = comandoDividido[1];
		File eliminar = new File(path.getAbsolutePath() + File.separator + nombre);
		if (eliminar.isFile()) {
			System.out.println("Eliminado " + eliminar.getName() + ": " + eliminar.delete());
		} else {
			System.out.println("No se puede elminar una carpeta.");
		}
	}

	private static void dir() {
		if (path.exists()) {
			File lista[] = path.listFiles();
			for (int i = 0; i < lista.length; i++) {
				if (lista[i].isFile()) {
					System.out.println("[FILE] " + lista[i].getName());
				} else {
					System.out.println("[DIR] " + lista[i].getName());
				}
			}
		} else {
			System.out.println("La ruta introducida no existe.");
		}
	}

	private static void cd(String comando) {
		String[] comandoDividido = comando.split(" ");
		if (comandoDividido[1].equals("..")) {
			String[] ruta = path.getAbsolutePath().split("\\\\");
			String rutaPadre = "";
			for (int i = 0; i < ruta.length - 1; i++) {
				rutaPadre += ruta[i] + File.separator;
			}
			if (path.getAbsolutePath()
					.equals("C:\\Users\\jcsal\\OneDrive\\Documentos\\Mis Programas\\Examen_UF3\\MostrarTamano")) {
				System.out.println("No se puede retroceder mas.");
			} else {
				path = new File(rutaPadre);
			}
		} else {
			File rutaHijo = new File(path.getAbsolutePath() + File.separator + comandoDividido[1]);
			if (rutaHijo.exists()) {
				if (rutaHijo.isDirectory()) {
					path = new File(rutaHijo.getAbsolutePath());
				} else {
					System.out.println("Has introducido un fichero.");
				}
			} else {
				System.out.println("La carpeta introducida no existe.");
			}
		}
	}

}
