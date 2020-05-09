package comandos;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Bytes {

	public static void main(String[] args) {
		try {
			File f_escriptura = new File("archivo.bin");
			RandomAccessFile raf2 = new RandomAccessFile(f_escriptura, "rw");

			System.out.println("RandomAccessFile raf = new RandomAccessFile(f_lectura, \"r\")\n");

			System.out.println("RandomAccessFile raf2 = new RandomAccessFile(f_escriptura, \"rw\")\n");

			System.out.println("Escribir Integers: \r\n" + "for (int i = 0; i < 20; i++) {\r\n"
					+ "\traf.writeInt(valor);\r\n" + "\tvalor = valor * 2;\r\n" + "} \n");

			System.out.println("Posicion donde esta el puntero: " + raf2.getFilePointer() + "\n");

			System.out.println("Poner nuevo mida de archivo: raf2.setLength(1024)\n");
			
			System.out.println("Leer: \r\n" + "for (int i = 0; i < numEnters; i++) {\r\n" + 
					"\tdouble valor = raf.readDouble();\r\n" + 
					"\tSystem.out.println(\"S'ha llegit el valor real \" + valor);\r\n" + 
					"} \n");

			System.out.println("Mover de posicion en el fichero 4: seek(4)\n");
			
			System.out.println("Saltar de posicion 2 a 8: skipBytes(6)\n");
			
			raf2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
