package ejercicios.tractament;

import java.io.*;
import java.util.Scanner;

public class TablasDeMultiplicar {

	public static void main(String[] args) {
		try {
			File archivo = new File("TablasDeMultiplicar.txt");

			if (archivo.exists()) {
				PrintStream escriptorFichero = new PrintStream(archivo);
				Scanner lector = new Scanner(System.in);

				System.out.println("Escribe el numero de las tablas de multiplicar:");
				String numeros = lector.nextLine();

				escriptorFichero.print(numeros);

				lector.close();
				escriptorFichero.close();
				Scanner lectorFichero = new Scanner(archivo);

				numeros = "";
				while (lectorFichero.hasNext()) {
					if (lectorFichero.hasNextInt()) {
						int valor = lectorFichero.nextInt();
						if (valor >= 0) {
							numeros += valor + " ";
						}
					} else {
						lectorFichero.next();
					}
				}
				lectorFichero.close();
				String[] tablas = numeros.split(" ");
				PrintStream escriptor = new PrintStream(archivo);
				for (int i = 0; i < tablas.length; i++) {
					escriptor.print("TABLA " + tablas[i] + "\t\t\t");
				}
				escriptor.println();
				for (int i = 0; i < 11; i++) {
					for (int j = 0; j < tablas.length; j++) {
						int tabla = Integer.parseInt(tablas[j]);
						escriptor.print(tabla + " x " + i + " = " + (tabla * i) + "\t\t");
					}
					escriptor.println();
				}
				escriptor.close();
				System.out.println("Se han creado las tablas correctamente.");
			}

		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

}
