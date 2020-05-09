
public class Ordenacion {

	public static void main(String[] args) {
		int a = 0;
		int intercambio = 0;
		int[] tabla = new int[5];

		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = (int) (Math.random() * 20 + 1);
		}

		System.out.println("Desordenados");
		for (int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[i]);
		}

		while (a < tabla.length) {
			int b = 0;
			int c = 1;
			int d = tabla.length - 1;
			int e = tabla.length - 2;
			int z = 0;
			if (a % 2 == 0) {
				//System.out.println("Izquierda");
				while (z < tabla.length) {
					if (c == tabla.length) {
						c = c - 1;
						intercambio = tabla[b];
						tabla[b] = tabla[c];
						tabla[c] = intercambio;
					} else if (tabla[b] > tabla[c]) {
						intercambio = tabla[b];
						tabla[b] = tabla[c];
						tabla[c] = intercambio;
					}
					z++;
					b++;
					c++;
				}
			}
			else if (a % 2 == 1) {
				//System.out.println("Derecha");
				while (z < tabla.length) {
				if (e == 0) {
					e = e + 1;
					intercambio = tabla[d];
					tabla[d] = tabla[e];
					tabla[e] = intercambio;
				} else if (tabla[d] < tabla[e]) {
					intercambio = tabla[d];
					tabla[d] = tabla[e];
					tabla[e] = intercambio;
				}
				d--;
				e--;
				z++;
			}
			}
			a++;
		}

		System.out.println("\rOrdenados");
		for (int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[i]);
		}
	}

}
