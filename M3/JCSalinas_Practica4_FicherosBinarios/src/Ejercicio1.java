import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			File path = new File("Ejercicio1.txt");
			Scanner lectorFichero = new Scanner(path);
			boolean fi = false;
			int contadorLineas = 0;
			while (!fi) {
				if (lectorFichero.hasNext("fi")) {
					fi = true;
				} else {
					String frase = lectorFichero.nextLine();
					String[] fraseDividida = frase.split(" ");
					contadorLineas++;
					System.out.println("La línia " + contadorLineas + " té " + fraseDividida.length + " paraules.");
				}
			}
			lectorFichero.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}

	}

}
