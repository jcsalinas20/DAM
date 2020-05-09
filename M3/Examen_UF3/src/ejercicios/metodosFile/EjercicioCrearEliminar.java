package ejercicios.metodosFile;

import java.io.File;
import java.io.IOException;

public class EjercicioCrearEliminar {

	public static void main(String[] args) throws IOException {
		File archivo = new File("EjercicioCrearEliminar.txt");
		if (archivo.exists()) {
			archivo.delete();
			System.out.println("S'ha esborrat el fitxer \"EjercicioCrearEliminar.txt\"");
		} else {
			if (archivo.isDirectory()) {
				archivo.mkdirs();
			} else {
				archivo.createNewFile();
			}
			System.out.println("S'ha creat el fitxer \"EjercicioCrearEliminar.txt\"");
		}
	}

}
