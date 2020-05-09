import java.io.*;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			File path = new File("Ejercicio1.txt");
			Scanner lectorFichero = new Scanner(path);
			int suma = 0;
			int posicion = 0;

			while (lectorFichero.hasNextInt()) {
				int resultado = posicion % 2;
				if (resultado == 0) {
					int num = lectorFichero.nextInt();
					suma += num;
				} else {
					lectorFichero.next();
				}
				posicion++;
			}

			System.out.println("Suma total de posiciones de numeros pares: " + suma);

			lectorFichero.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
