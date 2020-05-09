import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		try {
			File path = new File("");
			File pathHistograma = new File("");
			Scanner lector = new Scanner(System.in);
			boolean fi = false;
			String[] notes = { "Suspendidos: ", "Aprobados: ", "Notables: ", "Excelentes: " };
			int[] histograma = new int[4];
			String fichero = "";
			boolean encontrarArchivo = false;
			while (!encontrarArchivo) {
				System.out.print("Introduce el nombre del archivo: ");
				fichero = lector.next();
				path = new File(fichero);
				if (path.exists() == true) {
					encontrarArchivo = true;
					pathHistograma = new File("Histograma-" + fichero);
					System.out.println("Se ha encontrado el archivo.");
				} else {
					System.out.println("El archivo no se ha encontrado.");
				}
			}
			Scanner lectorFichero = new Scanner(path);
			PrintStream escriptor = new PrintStream(pathHistograma);
			if (pathHistograma.exists() == false) {
				pathHistograma.createNewFile();
			}
			double valor = 0;
			while (!fi) {
				valor = lectorFichero.nextDouble();
				if (valor >= -1 && valor <= 10) {
					if (valor == -1) {
						fi = true;
					} else {
						if (valor >= 0 && valor < 5) {
							histograma[0]++;
						} else if (valor >= 5 && valor < 6.5) {
							histograma[1]++;
						} else if (valor >= 6.5 && valor < 9) {
							histograma[2]++;
						} else if (valor >= 9 && valor <= 10) {
							histograma[3]++;
						}
					}
				} else {
					lectorFichero.next();
				}
			}
			escriptor.println("Histograma de "+path.getName()+"\n");
			for (int i = 0; i < histograma.length; i++) {
				escriptor.print(notes[i]);
				for (int j = 0; j < histograma[i]; j++) {
					escriptor.print("*");
				}
				escriptor.println();
			}
			System.out.println("Histograma guardado en "+pathHistograma.getName());
			escriptor.close();
			lector.close();
			lectorFichero.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
