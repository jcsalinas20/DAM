import java.io.File;
import java.io.RandomAccessFile;

public class Ejercicio4B {

	public static void main(String[] args) {
		try {
			File path = new File("Ejercicio4.bin");
			RandomAccessFile raf = new RandomAccessFile(path, "r");
			while (raf.getFilePointer() < raf.length()) {
				int contadorBytes = raf.readInt();
				if (contadorBytes >= 4) {
					byte[] bytes = new byte[contadorBytes];
					for (int i = 0; i < contadorBytes; i++) {
						bytes[i] = raf.readByte();
					}
					String palabra = new String(bytes);
					System.out.println(palabra);
				} else {
					raf.skipBytes(contadorBytes);
				}
			}
			raf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}