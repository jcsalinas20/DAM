import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		try {
			String dirTreball = System.getProperty("user.dir");
			File ficheroJava = new File(dirTreball + "/src/Ejercicio3.java");
			File ficheroLineas = new File(dirTreball + "/SeleccionDeLineas.txt");
			Scanner lectroJava = new Scanner(ficheroJava);
			Scanner lectroLineas = new Scanner(ficheroLineas);
			boolean fi = false;
			int contadorAnterior = 0;
			int contador = 0;
			while (!fi) {
				if (lectroLineas.hasNext("fi")) {
					fi = true;
				} else {
					contador = lectroLineas.nextInt();
					contador = contador - contadorAnterior;
					int contadorI = 1;
					while (contadorI <= contador) {
						if (contadorI == contador) {
							System.out.println(lectroJava.nextLine());
							contadorAnterior = contador;
							contadorI++;
						} else {
							lectroJava.nextLine();
							contadorI++;
						}
					}
				}
			}
			lectroLineas.close();
			lectroJava.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
