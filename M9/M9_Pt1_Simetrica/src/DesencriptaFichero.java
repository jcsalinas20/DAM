/* DESCRIPCION: Programa que desencripta un fichero  
 *              encriptado por EncriptaFichero 
 */

import java.io.*;
import java.security.*;
import java.util.Scanner;

import javax.crypto.*;
import javax.crypto.spec.*;

public class DesencriptaFichero {
	public static final int ITERACIONES = 1024;
	public static final int TAMANO_BUFFER = 1024;

	public static void main(String args[]) throws Exception {
		String[] parametroStrings = new String[3];
		Scanner lector = new Scanner(System.in);
		System.out.print("Introduce el password: ");
		parametroStrings[0] = lector.next();//guardar el password
		System.out.print("Introduce la ruta del fichero encriptado: ");//encriptado.des
		lector.nextLine();
		parametroStrings[1] = lector.nextLine();//guardar la ruta del texto encriptado
		System.out.print("Introduce el nombre del fichero plano: ");
		parametroStrings[2] = lector.nextLine();//guardar el nombre del texto plano
		
		// Comprobacion de argumentos
		if (!new File(parametroStrings[1]).exists()) {
			System.out.println("Indique <password> " + " <fichero_encriptado> [<fichero_plano>]" + " como argumento");
			return;
		}
		if (!parametroStrings[1].endsWith(".des")) {
			System.out.println("Los ficheros encriptados" + " deben tener la extension .des");
			return;
		}

		// Abrimos los ficheros
		System.out.print("Abriendo fichero...");
		DataInputStream fichero_encriptado = new DataInputStream(new FileInputStream(parametroStrings[1]));
		FileOutputStream fichero_plano;
		if (args.length == 2)
			fichero_plano = new FileOutputStream(parametroStrings[1].substring(0, parametroStrings[1].length() - 4));
		else
			fichero_plano = new FileOutputStream(parametroStrings[2]);

		// Generamos una clave secreta a partir
		// del password
		System.out.print("\rGenerando clave secreta");
		PBEKeySpec objeto_password = new PBEKeySpec(parametroStrings[0].toCharArray());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey clave_secreta = skf.generateSecret(objeto_password);

		// Leemos los parametros encoded
		int longitud_encoded = fichero_encriptado.readInt();
		byte[] encoded = new byte[longitud_encoded];
		fichero_encriptado.read(encoded);
		AlgorithmParameters ap = AlgorithmParameters.getInstance("PBEWithMD5AndDES");
		ap.init(encoded);

		// Creamos el cifrador
		Cipher cifrador = Cipher.getInstance("PBEWithMD5andDES");
		cifrador.init(Cipher.DECRYPT_MODE, clave_secreta, ap);

		// Desencriptamos el contenido del fichero
		// encriptado y lo pasamos al fichero plano
		System.out.print("\rDesencriptando fichero...");
		byte[] buffer = new byte[TAMANO_BUFFER];
		int bytes_leidos = fichero_encriptado.read(buffer);
		while (bytes_leidos > 0) {
			fichero_plano.write(cifrador.update(buffer, 0, bytes_leidos));
			bytes_leidos = fichero_encriptado.read(buffer);
		}
		fichero_plano.write(cifrador.doFinal());
		
		mostrarFicheroDesencriptado(new File(parametroStrings[2]));
		
		// Cerramos los ficheros
		fichero_encriptado.close();
		fichero_plano.close();
		System.out.println("\rHecho                   ");
	}

	private static void mostrarFicheroDesencriptado(File fichero) {
		try {
			Scanner lectorFichero = new Scanner(fichero);

			System.out.println("\n\nCONTENIDO DEL FICHERO:");
			while (lectorFichero.hasNextLine()) {
				System.out.println(lectorFichero.nextLine());
			}
			System.out.println();

			lectorFichero.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}