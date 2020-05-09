package Practica2;

import java.util.Arrays;

public class Ejercicio5 {

	public static void main(String[] args) {
		Ejercicio5 programa = new Ejercicio5();
		programa.inici();
	}

	public void inici() {
		int[] numeros = { 100, 2014, 12, 30, 302, 40020, 7009, 500000 };
		System.out.println(Arrays.toString(numeros));
		ordenacionAscendente(numeros);
		System.out.println(Arrays.toString(numeros));
	}

	public void ordenacionAscendente(int[] numeros) {
		int auxiliar = 0;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = i; j < numeros.length; j++) {
				if (numeros[i] < numeros[j]) {
					auxiliar = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = auxiliar;
				}
			}
		}
	}
}
