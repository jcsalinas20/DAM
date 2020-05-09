package P12;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int[] num = new int[4];
		int buscar = 0;
		boolean encontrado = false;

		for (int i = 0; i < num.length; i++) {
			int a = 0;
			System.out.print("Introduce un numero: ");
			buscar = x.nextInt();
			num[i] = buscar;
			while (a < i) {
				int z = 1;
				int k = 0;
				int intercambio = 0;
				while (k < i) {
					if (num[k] > num[z]) {
						intercambio = num[z];
						num[z] = num[k];
						num[k] = intercambio;
					}
					z++;
					k++;
				}
				a++;
			}
			for (int j = 0; j < num.length; j++) {
				System.out.print(num[j]);
			}
			int inicio = 0, fin = num.length, medio = 0;
			encontrado = false;
			while ((inicio <= fin) && !encontrado) {
				medio = (fin + inicio) / 2;
				if (num[medio] == buscar) {
					encontrado = true;
				}
				if (buscar < num[medio]) {
					fin = medio - 1;
				} else {
					inicio = medio + 1;
				}
			}

		}

		x.close();
	}

}
