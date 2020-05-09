package Practica2;

public class Ejercicio2 {

	public static void main(String[] args) {
		Ejercicio2 programa = new Ejercicio2();
		programa.inici();
	}

	public void inici() {
		int num1 = 18;
		int num2 = 13;
		int num3 = 33;
		System.out.println("El " + num1 + " es primer? " + esPrimer(num1));
		System.out.println("El " + num2 + " es primer? " + esPrimer(num2));
		System.out.println("El " + num3 + " es primer? " + esPrimer(num3));
	}

	public boolean esPrimer(int valor) {
		boolean primo = true;
		for (int cont = 2; cont < valor; cont++) {
			if (valor % cont == 0) {
				primo = false;
			}
		}
		return primo;
	}

}
