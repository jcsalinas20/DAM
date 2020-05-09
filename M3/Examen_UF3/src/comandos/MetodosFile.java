package comandos;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MetodosFile {

	public static void main(String[] args) throws IOException {
		File path = new File("." + File.separator);
		System.out.println("Arae de trabajo (Opcion 1): " + path.getAbsolutePath());

		String dirTreball = System.getProperty("user.dir");
		path = new File(System.setProperty("user.dir", dirTreball) + "\\MostrarTamano\\2.txt");
		System.out.println("\nArae de trabajo (Opcion 2): " + path.getAbsolutePath());

		System.out.println("\nSeparador del sistema: " + File.separator);

		System.out.println("\n" + path.getParent());

		System.out.println("\n" + path.getName());

		System.out.println("\nEs un directorio: " + path.isDirectory());

		System.out.println("\nEs un fichero: " + path.isFile());

		System.out.println("\nExiste: " + path.exists());

		System.out.println("\nCrear carpetas: " + path.mkdirs());

		System.out.println("\nCrear fichero: " + path.createNewFile());

		System.out.println("\nEliminar ficheros o carpetas: path.delete()");

		System.out.println("\nMida del fichero: " + (path.length() / 1024) + "KB");

		Date data = new Date(path.lastModified());
		System.out.println("\nUltima modificacion: " + data);

		System.out.println("\nRenombrar: " + path.renameTo(path));

		System.out.println("\nSe puede escribir: " + path.canWrite());

		System.out.println("\nSe puede leer: " + path.canRead());

		System.out.println("\nSe puede ejecutar: " + path.canExecute());

		System.out.println("\nEsta oculto: " + path.isHidden());

		System.out.println("\nGuardar en un array: " + path.list());

		System.out.println("\nSon iguales: " + path.getName().equals("2.txt"));

		System.out.println("\nSolo se puede leer: " + path.setReadOnly());

		System.out.println("\nCambiar fecha modificacion: " + path.setLastModified(System.currentTimeMillis()));
	}

}
