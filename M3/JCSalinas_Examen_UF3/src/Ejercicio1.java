import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		File path = new File("classificacio.txt");
		String[][] jugadores = new String[6][2];
		introduccionJugadores(jugadores);

		introduccionFichero(jugadores, path);
	}

	public static void introduccionJugadores(String[][] array) {
		Scanner lector = new Scanner(System.in);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < 1; j++) {
				System.out.print("Introduce el nombre del jugador: ");
				array[i][j] = lector.next();
			}
			for (int j = 1; j < array[i].length; j++) {
				array[i][j] = " 0";
			}
			System.out.println();
		}
		lector.close();
	}

	private static void introduccionFichero(String[][] jugadores, File path) {
		try {
			PrintStream escriptor = new PrintStream(path);
			if (path.exists() == true) {
				for (int i = 0; i < jugadores.length; i++) {
					for (int j = 0; j < jugadores[i].length; j++) {
						escriptor.print(jugadores[i][j] + " ");
					}
					escriptor.println();
				}
				System.out.println("Se han introducido los datos correctamente.");
			} else {
				System.out.println("El fichero" + path + " no existe.");
			}
			escriptor.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
