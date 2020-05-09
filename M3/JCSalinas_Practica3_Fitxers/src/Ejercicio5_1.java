import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Ejercicio5_1 {

	public static void main(String[] args) {
		try {
			int[][] matriz = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 0, 0, 0, 0, 0, 0, 0, 1 },
					{ 1, 0, 1, 0, 0, 0, 0, 0, 1, 1 }, { 1, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
					{ 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
					{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, };
			String dirTreball = System.getProperty("user.dir");
			File path = new File(dirTreball + "/Matriz.txt");
			PrintStream escriptor = new PrintStream(path);
			if (path.exists() == true) {
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						if (j == matriz[i].length-1) {
							escriptor.print(matriz[i][j] + " ,");
						} else {
							escriptor.print(matriz[i][j] + " ");
						}
					}
					escriptor.println("");
				}
				escriptor.print("fi");
			} else {
				System.out.println("El archivo no existe.");
			}
			escriptor.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}