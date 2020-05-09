package Practica1;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Ejercicio1 programa = new Ejercicio1();
		programa.inici(); 
	}
	
	public void inici() {
		Scanner lector = new Scanner(System.in);
		String frase = "";
		String[] fraseDividida = { "", "" };
		String fraseMayor = "";
		int contadorA = 0;
		int mayor = 0;
		int seguir = 1;

		while (seguir != 0) {

			contadorA = 0;
			System.out.println("Introduce una frase:");
			frase = lector.nextLine();
			if (frase.equalsIgnoreCase("fi")) {
				seguir = 0;
				System.out.println("El programa ha acabado.");
				break;
			}
			fraseDividida = frase.split("");
			for (int i = 0; i < fraseDividida.length; i++) {
				if (fraseDividida[i].equalsIgnoreCase("a")) {
					contadorA++;
				}
			}
			if (contadorA > mayor) {
				mayor = contadorA;
				fraseMayor = frase;
			}
			System.out.println("La frase con mas 'a' es: " + fraseMayor);
			System.out.println("Tiene " + mayor + " 'a'.");
		}
		lector.close();
	}
}
