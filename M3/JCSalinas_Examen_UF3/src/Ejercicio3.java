import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		File clasificacio = new File("classificacio.txt");
		for (int i = 1; i < 5; i++) {
			File jornades = new File("jornada0" + i + ".txt");
			File resultats = new File("resultats0" + i + ".txt");
			String[][] jornada = new String[3][2];
			int[][] tirades = new int[3][2];
			nomsJugadors(jornada, jornades);

			numeroTirades(tirades);

			puntuacions(clasificacio, jornada, tirades);
		}
//		ordenar();
	}

	private static void puntuacions(File clasificacio, String[][] jornada, int[][] tirades) {
		for (int i = 0; i < tirades.length; i++) {
			if (tirades[i][0] > tirades[i][1]) {
				
			} else if (tirades[i][0] < tirades[i][1]) {
				
			} else {
				System.out.println("dwed");
			}
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
