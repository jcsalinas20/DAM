import java.util.Scanner;
import java.lang.Math;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		String[] texto = new String[5];
		double mitad = 0f;
		String subcadena = "";

		for (int i = 0; i < texto.length; i++) {
			texto[i] = lector.next();
		}

		for (int i = 0; i < texto.length; i++) {
			mitad = texto[i].length() / 2f;
			mitad=(double) Math.ceil(mitad);
			subcadena=texto[i].substring(0, (int) mitad);
			System.out.println(subcadena);
		}
		
		lector.close();
	}
}