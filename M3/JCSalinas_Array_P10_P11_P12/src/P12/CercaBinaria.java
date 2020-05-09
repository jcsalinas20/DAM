package P12;

import java.util.Scanner;

public class CercaBinaria {

	public static void main(String[] args) {
		//VARIABLES
		Scanner x = new Scanner(System.in);
		String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };
		int[] ingresos = new int[12];
		int[] ordenacionIng= new int[12];
		boolean validacion = false;
		int buscar = 0;

		//INGRESOS DE LOS MESES POR TECLADO
		for (int i = 0; i < meses.length; i++) {
			System.out.print("Ingresos del mes " + meses[i] + ": ");
			do {
				if (x.hasNextInt()) {
					ingresos[i] = x.nextInt();
					ordenacionIng[i]=ingresos[i];
					if (ingresos[i] >= 0) {
						validacion = true;
					}
				} else if (i == 0) {
					x.next();
				} else {
					x.next();
					i--;
				}
			} while (validacion != true);
		}
		
		//ORDENACION PARA LA CERCA BINARIA
		int a = 0;
		while (a < ordenacionIng.length) {
			int b = 0;
			int c = 1;
			int z = 0;
			int intercambio = 0;
			while (z < ordenacionIng.length) {
				if (c == ordenacionIng.length) {
					c--;
					intercambio = ordenacionIng[b];
					ordenacionIng[b] = ordenacionIng[c];
					ordenacionIng[c] = intercambio;
				} else if (ordenacionIng[b] > ordenacionIng[c]) {
					intercambio = ordenacionIng[b];
					ordenacionIng[b] = ordenacionIng[c];
					ordenacionIng[c] = intercambio;
				}
				z++;
				b++;
				c++;
			}
			a++;
		}
		
		//CERCA BINARIA
		validacion = false;
		do {
			System.out.print("Ingresa el numero que deseas buscar: ");
			if (x.hasNextInt()) {
				buscar = x.nextInt();
				if (buscar > 0) {
					int inicio = 0, fin = ingresos.length - 1, medio = 0;
					boolean encontrado = false;
					while ((inicio <= fin) && !encontrado) {
						medio = (fin + inicio) / 2;
						if (ingresos[medio] == buscar) {
							encontrado = true;
						}
						if (buscar < ingresos[medio]) {
							fin = medio - 1;
						} else {
							inicio = medio + 1;
						}
					}
					validacion = true;
				} else {
					System.out.println("Ingrese un numero positivo.");
				}
			} else {
				x.next();
			}
		} while (validacion != true);

		//MOSTRAR EN PANTALLA
		int e = 0;
		System.out.println();
		for (int i = 0; i < meses.length; i++) {
			if (ingresos[i] == buscar) {
				System.out.println("El mes " + meses[i] + " has tenido un ingreso de " + buscar);
				e++;
			}
		}
		if (e == 0) {
			System.out.print("No se ha encontrado ningun mes con estos ingresos: " + buscar);
		}
		x.close();
	}
}