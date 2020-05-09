import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio4A {

	public static void main(String[] args) {
		try {
			Scanner lector = new Scanner(System.in);
			String frase = "Hi havia una vegada una cadena de text";
//			System.out.println("Introduce una frase: ");
//			String frase = lector.nextLine();
			String[] palabras = frase.split(" ");
			File path = new File("Ejercicio4.bin");
			if (path.exists() == false) {
				path.createNewFile();
			}
			RandomAccessFile raf = new RandomAccessFile(path, "rw");
			byte[] bytes = null;
			for (int i = 0; i < palabras.length; i++) {
				bytes = palabras[i].getBytes();
				raf.writeInt(bytes.length);
				raf.writeBytes(palabras[i]);
				System.out.println(Arrays.toString(bytes) + " " + palabras[i]);
			}
			lector.close();
			raf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}