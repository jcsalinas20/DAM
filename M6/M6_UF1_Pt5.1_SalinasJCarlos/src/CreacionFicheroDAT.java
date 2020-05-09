import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CreacionFicheroDAT {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File archivo = new File("myPeople.dat");// Ruta fichero .dat
		comprobacionSiElArchivoExiste(archivo);// Metodo para comtrobar si existe el fichero

		escrituraDeArchivo(archivo);// Metodo para esbribir en el archivo
	}

//	 Metodo para esbribir en el archivo
	private static void escrituraDeArchivo(File archivo) throws ClassNotFoundException {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(archivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			Persona persona = new Persona("Maria Lopez", 36);// Creacion de la Persona con nombre y edad
			oos.writeObject(persona);// Escribir el objeto persona en el fichero
			persona = new Persona("Gustavo Gomez", 1);
			oos.writeObject(persona);
			persona = new Persona("Irene Salas", 36);
			oos.writeObject(persona);
			persona = new Persona("Roberto Morgade", 63);
			oos.writeObject(persona);
			persona = new Persona("Graciela Iglesias", 60);
			oos.writeObject(persona);

			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	 Metodo para comtrobar si existe el fichero
	private static void comprobacionSiElArchivoExiste(File archivo) throws IOException {
		if (!archivo.exists()) {
			archivo.createNewFile();
		}
	}

}
