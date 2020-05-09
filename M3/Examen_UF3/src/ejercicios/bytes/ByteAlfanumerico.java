package ejercicios.bytes;

import java.io.*;

public class ByteAlfanumerico {

	public static void main(String[] args) throws Exception {
		File archivo = new File("MensajeEnByte.bin");

		RandomAccessFile raf = new RandomAccessFile(archivo, "r");

		System.out.println("Leyendo mensaje...");

		while (raf.getFilePointer() < raf.length()) {
			int contadorBytes = raf.readInt();
			if (contadorBytes > 4) {
				byte[] bytes = new byte[contadorBytes];
				for (int i = 0; i < contadorBytes; i++) {
					bytes[i] = raf.readByte();
				}
				String palabra = new String(bytes);
				System.out.print(palabra + " ");
			} else {
				raf.skipBytes(contadorBytes);
			}
		}

		raf.close();
	}

}
