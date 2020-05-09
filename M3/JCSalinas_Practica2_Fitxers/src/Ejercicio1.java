import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		try {
			String dirTreball = System.getProperty("user.dir");
			File path = new File(dirTreball + "/NotaMitja.txt");
			Scanner lectorFichero = new Scanner(path);
			if (path.exists() == true) {
				boolean fi = false;
				while (!fi) {
					if (lectorFichero.hasNextFloat()) {
						float media = 0f;
						float contador = lectorFichero.nextFloat();
						for (float i = 0; i < contador; i++) {
							media = media + lectorFichero.nextFloat();
							if (i == contador - 1) {
								media = media / contador;
							}
						}
						System.out.println("(Nota Mitjana: " + media + ")");
					} else {
						if (lectorFichero.hasNext("fi")) {
							fi = true;
							break;
						} else {
							System.out.print(lectorFichero.next() + " ");
						}
					}
				}
			} else {
				System.out.println("El fichero" + path.getName() + " no existe");
			}
			lectorFichero.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
