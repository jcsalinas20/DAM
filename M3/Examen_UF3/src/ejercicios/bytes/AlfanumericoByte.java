package ejercicios.bytes;

import java.io.*;

public class AlfanumericoByte {

	public static void main(String[] args) throws Exception {
		String mensaje = "Hola a todos me llamo Juan Carlos Salinas";

		File archivo = new File("MensajeEnByte.bin");

		archivo.delete();
		archivo.createNewFile();

		RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
		String[] palabras = mensaje.split(" ");

		byte[] bytes = null;
		for (int i = 0; i < palabras.length; i++) {
			bytes = palabras[i].getBytes();
			raf.writeInt(bytes.length);
			raf.writeBytes(palabras[i]);
		}

		raf.close();
		
		System.out.println("Mensaje correctamente insertado.");
	}

}
