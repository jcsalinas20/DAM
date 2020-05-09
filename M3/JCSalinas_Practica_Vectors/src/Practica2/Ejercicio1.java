package Practica2;

public class Ejercicio1 {

	public static void main(String[] args) {
		char[] tabla = { 'a', 's', 'd', 'f', 'a', 'w', 'x', 'a', 'b', 'c', 'd' };
		int cont = 0;
		for (int i = 0; i < tabla.length; i++) {
			if (tabla[i] == 'a') {
				cont++;
			}
		}
		if (cont>=1) {
			System.out.println("Hay " + cont + " letras A");
		}
		else {
			System.out.println("Parece que no hay ningun caracter de la letra A");
		}
	}
}
