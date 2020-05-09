import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		try {
			String dirTreball = System.getProperty("user.dir");
			File numeros = new File(dirTreball + "/1a100.txt");
			File parells = new File(dirTreball + "/Parells.txt");
			File senars = new File(dirTreball + "/Senars.txt");
			Scanner lectorParells = new Scanner(parells);
			Scanner lectorSenars = new Scanner(senars);
			PrintStream escriptor = new PrintStream(numeros);
			if (numeros.exists() == true) {
				for (int i = 1; i <= 100; i++) {
					if (i % 2 == 1) {
						escriptor.println(lectorSenars.next());
					} else {
						escriptor.println(lectorParells.next());
					}
				}
				System.out.println("Se han introducido todos los numero en " + numeros.getName() + ".");
			} else {
				System.out.println("Se ha creado el archivo " + numeros.getName());
				System.out.println("Ejecuta otra vez del programa.");
				numeros.createNewFile();
			}
			escriptor.close();
			lectorSenars.close();
			lectorParells.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		}

	}

}
