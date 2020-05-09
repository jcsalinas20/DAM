import java.io.RandomAccessFile;
import java.util.Scanner;
import java.io.File;

public class Ejercicio5 {

	public static void main(String[] args) {
		try {
			Scanner lector = new Scanner(System.in);
			System.out.print("Introduce la ruta del archivo de ORIGEN: ");
			String origen = lector.next();
			System.out.print("Introduce la ruta del archivo de DESTINO: ");
			String destino = lector.next();
			File pathOrigen = new File(origen);
			File pathDestino = new File(destino);
			if (pathOrigen.exists() == true && pathDestino.exists() == false) {
				RandomAccessFile rafOrigen = new RandomAccessFile(pathOrigen, "r");
				RandomAccessFile rafDestino = new RandomAccessFile(pathDestino, "rw");
				long contador = pathOrigen.length();
				System.out.println("Frase: ");
				for (int i = 0; i < contador; i++) {
					byte caracter = rafOrigen.readByte();
					if (i == contador - 1) {
						System.out.println("[" + caracter + "] ");
					} else {
						System.out.print("[" + caracter + "], ");
					}
					rafDestino.writeByte(caracter);
				}
				System.out.println("Se ha introducido correctamente.");
				rafDestino.close();
				rafOrigen.close();
			} else {
				System.out.println("El archivo origen no existe o el archivo destino ya existe.");
				System.out.println("Origen: " + pathOrigen.exists());
				System.out.println("Destino: " + pathDestino.exists());
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}