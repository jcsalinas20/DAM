/* DESCRIPCION: Programa que encripta un fichero. 
 * Encripta el fichero usando el algoritmo basado en 
 * PBEWithMD5AndDES, con salt de 64 bits  
 * y iteration count do 1024 
 * El fichero generado consta de las siguientes partes: 
 * - Entero con la longitud de los parametros encoded 
 * - Los parametros encoded por AlgorithmParameters 
 *   (salt y iteration count) 
 * - Los datos encriptados (siempre seran multiplos de 
 *   8 bytes, que es el tamano de bloque) 
 */

import java.io.*;
import java.security.*;
import java.util.Scanner;

import javax.crypto.*;
import javax.crypto.spec.*;

public class EncriptaFichero {
	public static final int ITERACIONES = 1024;
	public static final int TAMANO_SALT_BYTES = 8;
	public static final int TAMANO_BUFFER = 1024;

	public static void main(String args[]) throws Exception {
		String[] parametroStrings = new String[3];//array para guardar los parametros
		Scanner lector = new Scanner(System.in);
		System.out.print("Introduce el password: ");
		parametroStrings[0] = lector.next();//guardar la password
		System.out.print("Introduce la ruta del fichero: ");
		lector.nextLine();//guardar la ruta del texto plano
		parametroStrings[1] = lector.nextLine();
		System.out.print("Introduce el nombre del fichero encriptado: ");
		parametroStrings[2] = lector.nextLine();//guardar el nombre del fichero encriptado

		// Comprobacion de argumentos
		if (parametroStrings[0].isEmpty() || !new File(parametroStrings[1]).exists()) {
			System.out
					.println("Para encriptar indique <password> <fichero_plano> [<fichero_encriptar>] como argumento");
			return;
		}
		if (!parametroStrings[2].endsWith(".des")) {
			System.out.println("Los ficheros encriptados deben tener la extension .des");
			return;
		}

		mostrarContenidoFichero(new File(parametroStrings[1]));

		// Abrimos los ficheros
		FileInputStream fichero_plano = new FileInputStream(parametroStrings[1]);
		DataOutputStream fichero_encriptado;
		if (args.length == 2)
			fichero_encriptado = new DataOutputStream(new FileOutputStream(parametroStrings[1] + ".des"));
		else
			fichero_encriptado = new DataOutputStream(new FileOutputStream(parametroStrings[2]));

		// Generamos un salt aleatorio
		System.out.print("Generando salt...");
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[8];
		sr.nextBytes(salt);

		// Generamos una clave secreta a
		// partir del password
		System.out.print("\rGenerando clave secreta");
		PBEKeySpec objeto_password = new PBEKeySpec(parametroStrings[0].toCharArray());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		SecretKey clave_secreta = skf.generateSecret(objeto_password);

		// Generamos los parametros de PBEParameterSpec
		PBEParameterSpec pbeps = new PBEParameterSpec(salt, ITERACIONES);

		// Generamos el cifrador
		Cipher cifrador = Cipher.getInstance("PBEWithMD5AndDES");
		cifrador.init(Cipher.ENCRYPT_MODE, clave_secreta, pbeps);

		// Escribimos en el fichero encriptado los
		// parametros encoded
		System.out.print("\rEscribiendo fichero encriptado...           ");
		AlgorithmParameters ap = cifrador.getParameters();
		byte[] encoded = ap.getEncoded();
		fichero_encriptado.writeInt(encoded.length);
		fichero_encriptado.write(encoded);

		// Escribimos en el fichero encriptado los
		// datos del fichero plano
		byte[] buffer_plano = new byte[TAMANO_BUFFER];
		int leidos = fichero_plano.read(buffer_plano);
		while (leidos > 0) {
			byte[] buffer_encriptado = cifrador.update(buffer_plano, 0, leidos);
			fichero_encriptado.write(buffer_encriptado);
			leidos = fichero_plano.read(buffer_plano);
		}
		fichero_encriptado.write(cifrador.doFinal());

		// Cerramos los ficheros
		fichero_plano.close();
		fichero_encriptado.close();
		lector.close();
		System.out.println("\rHecho");
	}

	private static void mostrarContenidoFichero(File fichero) {
		try {
			Scanner lectorFichero = new Scanner(fichero);

			System.out.println("\nCONTENIDO DEL FICHERO:");
			while (lectorFichero.hasNextLine()) {
				//Lectura de linea
				System.out.println(lectorFichero.nextLine());
			}
			System.out.println();

			lectorFichero.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}