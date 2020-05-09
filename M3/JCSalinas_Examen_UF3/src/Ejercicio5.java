import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		try {
			Scanner lector = new Scanner(System.in);
			File path = new File("taules_de_multiplicar.bin");
			int[] tablaMultiplicar = new int[10];
			int J = 1;
			for (int i = 0; i < 10; i++) {
				tablaMultiplicar[i] = J;
				J++;
			}
			System.out.println(Arrays.toString(tablaMultiplicar));
			if (path.exists() == false) {
				path.createNewFile();
			}
			RandomAccessFile raf = new RandomAccessFile(path, "rw");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					raf.writeByte(tablaMultiplicar[i]);
//					System.out.println(Arrays.toString(bytes) + " " + palabras[i]);
				}
			}
			lector.close();
			raf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
