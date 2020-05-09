
public class Ordenacion2 {

	public static void main(String[] args) {
		int a=0;
		int intercambio = 0;
		int[] tabla = new int[5];

		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = (int) (Math.random() * 20 + 1);
		}

		System.out.println("Desordenados");
		for (int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[i]);
		}

		while (a<tabla.length) {
			int c = tabla.length-1;
			int b = tabla.length;
			while ( tabla.length>1) {
				System.out.print("Hola");
				if (c == 0) {
					c = c + 1;
				} else if (tabla[b] < tabla[c]) {
					intercambio = tabla[b];
					tabla[b] = tabla[c];
					tabla[c] = intercambio;
				}
				b--;
				c--;
			}
			a--;
		}

		System.out.println("\rOrdenados");
		for (int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[i]);
		}
	}

}
