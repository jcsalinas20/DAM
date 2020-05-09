import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		Scanner lector = new Scanner(System.in);
		String[] extensiones = new String[2];
		File cambioExtensiones = new File("C:/Temp/Documento/");

		System.out.print("Introduce el nombre del archivo: ");
		String nombreArchivo = lector.nextLine();

		System.out.print("Introduce 2 tipos de extensiones: ");
		for (int i = 0; i < extensiones.length; i++) {
			extensiones[i] = lector.next();
		}

		String nombre = nombreArchivo + "." + extensiones[0];
		File extensionOrigen = new File(cambioExtensiones + "/" + nombre);
		boolean resultado = extensionOrigen.createNewFile();
		System.out.println("Se ha creado el archivo " + extensionOrigen.getName() + "? " + resultado);

		if (resultado == true) {
			System.out.println("Se ha realizado el cambio de extension.");
			nombre = nombreArchivo + "." + extensiones[1];
			File extensionDestino = new File(cambioExtensiones + "/" + nombre);
			resultado = extensionDestino.createNewFile();
			System.out.println("Se ha creado el archivo " + extensionDestino.getName() + "? " + resultado);
			System.out.println("Nuevo archivo " + nombre);
		} else {
			System.out.println("No se ha podido realizar el cambio de extension.");
			System.out.println("Puede que no tengas la carpeta creada.");
		}

		lector.close();
	}

}
