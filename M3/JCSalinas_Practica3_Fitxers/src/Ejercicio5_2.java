import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio5_2 {

	public static void main(String[] args) {
		try {
			int[][] matriz = new int[0][0];
			String dirTreball = System.getProperty("user.dir");
			File path = new File(dirTreball + "/Matriz.txt");
			Scanner lectorFichero = new Scanner(path);
			Scanner lectorDimensiones = new Scanner(path);
			if (path.exists() == true) {
				boolean dimensiones = false;
				int contadorI = 0;
				int contadorJ = 0;
//				Esto lo pongo para calcular cualquier dimension de la matriz.
				while (!dimensiones) {
					if (lectorDimensiones.hasNext("fi")) {
						contadorJ = contadorJ / contadorI;
						dimensiones = true;
					} else if (lectorDimensiones.hasNext(",")) {
						contadorI++;
					} else {
						contadorJ++;
					}
					lectorDimensiones.next();
				}
//				Actualizacion de la matriz con las nuevas dimensiones
				matriz = new int[contadorI][contadorJ];
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j <= matriz[i].length; j++) {
						if (j == matriz[i].length) {
							lectorFichero.next();
						} else {
							int valor = Integer.valueOf(lectorFichero.next());
							matriz[i][j] = valor;
						}
					}
				}
				for (int i = 0; i < matriz.length; i++) {
					for (int j = 0; j < matriz[i].length; j++) {
						System.out.print(matriz[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("El archivo no existe.");
			}
			lectorDimensiones.close();
			lectorFichero.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}