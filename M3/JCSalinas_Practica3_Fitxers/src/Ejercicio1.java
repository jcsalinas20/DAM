import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			String dirTreball = System.getProperty("user.dir");
			File parells = new File(dirTreball + "/Parells.txt");
			File senars = new File(dirTreball + "/Senars.txt");
			if (parells.exists() == true && senars.exists() == true) {

				PrintStream escriptorPar = new PrintStream(senars);
				PrintStream escriptorSen = new PrintStream(parells);
				for (int i = 1; i <= 100; i++) {
					if (i % 2 == 1) {
						escriptorPar.println(i);
					} else {
						escriptorSen.println(i);
					}
				}
				System.out.println("Se han introducido los numeros correctamente.");
				escriptorSen.close();
				escriptorPar.close();
			} else {
				System.out.println("Los archivos no estan creados.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		}
	}

}
