package Practica2;
import java.util.*;
public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int altura = 0;
		System.out.print("Introduce la altura: ");
		altura = x.nextInt();
		for (int contador = 0; contador < altura; contador++) {
			for (int espacio = 1; espacio <= (altura - contador); espacio++) {
				System.out.print(" ");
			}
			for (int asterisco = 1; asterisco <= (contador * 2 - 1); asterisco++) {
				System.out.print("*");
			}
			System.out.println();
		}
		x.close();
	}

}
