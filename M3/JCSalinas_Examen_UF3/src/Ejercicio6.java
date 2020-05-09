import java.io.*;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) throws IOException {
		File origen = new File("Ejercicio6.txt");
		File destino = new File("src/");

		if (!origen.exists()) {
			origen.createNewFile();
			System.out.println("Se ha creado el archivo de origen.");
		}

		copiar(origen, destino);
	}

	private static void copiar(File origen, File destino) {
		Scanner lector = new Scanner(System.in);

		boolean validacion = false;
		String opcion = "";
		System.out.print("Que deseas hacer copiar o mover el archivo: ");
		do {
			opcion = lector.next();
			if (opcion.equals("copiar")) {
				validacion = true;
			} else if (opcion.equals("mover")) {
				validacion = true;
			} else {
				lector.nextLine();
			}
		} while (validacion != true);
		lector.nextLine();
		
		System.out.print("Introduce un nuevo nombre (Enter para utilizar el mismo): ");
		String newName = lector.nextLine();

		if (!newName.equals("")) {
			destino = new File(destino.getPath() + File.separator + newName);
		} else {
			destino = new File(destino.getPath() + File.separator + origen.getName());
		}

		copiarOrigenDestino(destino, origen);

		if (opcion.equals("mover")) {
			origen.delete();
		}

		System.out.println("Se ha copiado el archivo.");

		lector.close();
	}

	private static void copiarOrigenDestino(File destino, File origen) {
		try {
			byte[] buffer = new byte[1024];
			InputStream fis = new FileInputStream(origen);
			OutputStream fos = new FileOutputStream(destino);
			int numRead;
			System.out.println("Copiando archivo...\n\n");
			while ((numRead = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, numRead);
			}
			fos.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
