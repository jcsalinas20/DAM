package Practica2;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Ejercicio6 programa = new Ejercicio6();
		programa.inici();
	}

	public void inici() {
		Scanner lector = new Scanner(System.in);
		System.out.println("Escriu una frase:");
		String frase = lector.nextLine();
		String[] palabras = frase.split(" ");
		String[] caracteres = frase.split("");
		buscadorVocales(caracteres, palabras);
	}

	public void buscadorVocales(String[] caracteres, String[] palabras) {
		int[] contador = new int[palabras.length];
		int cont = 0;
		int mayor = 0;
		int posicion=0;
		
		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i].equalsIgnoreCase(" ")) {
				cont++;
			} else if (caracteres[i].equalsIgnoreCase("a")) {
				contador[cont]++;
			} else if (caracteres[i].equalsIgnoreCase("e")) {
				contador[cont]++;
			} else if (caracteres[i].equalsIgnoreCase("i")) {
				contador[cont]++;
			} else if (caracteres[i].equalsIgnoreCase("o")) {
				contador[cont]++;
			} else if (caracteres[i].equalsIgnoreCase("u")) {
				contador[cont]++;
			}
		}
		
		System.out.print("\nLa paraula amb mes vocals es: ");
		for (int i = 0; i < palabras.length; i++) {
			for (int j = 0; j < palabras.length; j++) {
				if (mayor < contador[j]) {
					mayor = contador[j];
					if (mayor == contador[j]) {
						posicion=j;
					}
				}
			}
		}
		System.out.println(palabras[posicion]);
	}

}
