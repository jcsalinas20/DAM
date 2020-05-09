import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		for (int i = 1; i < 5; i++) {
			File jornades = new File("jornada0" + i + ".txt");
			File resultats = new File("resultats0" + i + ".txt");
			String[][] jornada = new String[3][2];
			int[][] tirades = new int[3][2];
			nomsJugadors(jornada, jornades);

			numeroTirades(tirades);

			resultadosJornadas(resultats, jornada, tirades);
		}
		System.out.println("Se ha introducido todo correctamente.");
	}

	private static void resultadosJornadas(File resultats, String[][] jornades, int[][] tirades) {
		try {
			PrintStream escriptor = new PrintStream(resultats);
			if (resultats.exists() == false) {
				resultats.createNewFile();
			}
			for (int i = 0; i < jornades.length; i++) {
				for (int j = 0; j < 2; j++) {
					escriptor.print(jornades[i][j] + " ");
				}
				for (int j = 0; j < 2; j++) {
					escriptor.print("Tiradas_" + jornades[i][j] + ": " + tirades[i][j] + "  ");
				}
				escriptor.println();
			}
			escriptor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void numeroTirades(int[][] tirades) {
		for (int i = 0; i < tirades.length; i++) {
			for (int j = 0; j < tirades[i].length; j++) {
				tirades[i][j] = (int) (Math.random() * 11 + 2);
			}
		}
	}

	public static void nomsJugadors(String[][] jornada, File jornada1) {
		try {
			Scanner lectorFicheros = new Scanner(jornada1);
			for (int i = 0; i < jornada.length; i++) {
				for (int j = 0; j < jornada[i].length; j++) {
					jornada[i][j] = lectorFicheros.next();
				}
			}
			lectorFicheros.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
