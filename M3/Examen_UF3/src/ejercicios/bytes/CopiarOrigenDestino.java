package ejercicios.bytes;

import java.io.*;

public class CopiarOrigenDestino {

	public static void main(String[] args) {
		try {
			File origen = new File("CopiarOrigenDestino/Origen");
			File destino = new File("CopiarOrigenDestino/Destino");

			if (origen.exists() && destino.exists()) {
				tree(origen, destino);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	private static void tree(File origen, File destino) throws IOException {
		File lista[] = origen.listFiles();
		for (int i = 0; i < lista.length; i++) {
			if (lista[i].isDirectory()) {
				tree(lista[i], destino);
			} else {
				if (destino.isFile()) {
					destino = new File(destino.getParent());
				}
				destino = new File(destino.getAbsolutePath() + File.separator + lista[i].getName());
				if (!destino.exists()) {
					RandomAccessFile rafOrigen = new RandomAccessFile(lista[i], "r");
					RandomAccessFile rafDestino = new RandomAccessFile(destino, "rw");
					byte[] buffer = new byte[1024];
					int numRead;
					while ((numRead = rafOrigen.read(buffer)) != -1) {
						rafDestino.write(buffer, 0, numRead);
					}
					rafDestino.close();
					rafOrigen.close();
				}
			}
		}
	}

}
