
public class dedewd {

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
			int z = 0;
			int c = tabla.length - 2;
			int b = tabla.length - 1;
			while (z < tabla.length) {
				if (c == 0) {
					c = c + 1;
					intercambio = tabla[b];
					tabla[b] = tabla[c];
					tabla[c] = intercambio;
				} else if (tabla[b] < tabla[c]) {
					intercambio = tabla[b];
					tabla[b] = tabla[c];
					tabla[c] = intercambio;
				}
				b--;
				c--;
				z++;
			}
			a++;
		}

		System.out.println("\rOrdenados");
		for (int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[i]);
		}

	}

}
