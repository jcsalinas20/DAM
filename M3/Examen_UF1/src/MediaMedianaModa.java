
public class MediaMedianaModa {
	int[] array = { 2, 3, 5, 2, 2, 6, 5, 6, 46, 45 };

	public static void main(String[] args) {
		new Media();
		new Mediana();
		new Moda();
	}

}

class Media {

	public Media() {
		MediaMedianaModa m = new MediaMedianaModa();
		int valorFinal = 0;

		for (int i = 0; i < m.array.length; i++) {
			valorFinal += m.array[i];
		}

		System.out.println("Resultado Media: " + valorFinal / m.array.length);
		System.out.println();
	}

}

class Mediana {

	public Mediana() {
		MediaMedianaModa m = new MediaMedianaModa();
		int auxiliar = 0;
		for (int i = 0; i < m.array.length; i++) {
			for (int j = 0; j < m.array.length - 1; j++) {
				if (m.array[j] > m.array[j + 1]) {
					auxiliar = m.array[j];
					m.array[j] = m.array[j + 1];
					m.array[j + 1] = auxiliar;
				}
			}
		}
		System.out.println("Resultado Mediana: "+m.array[m.array.length / 2]);
		System.out.println();
	}

}

class Moda {

	public Moda() {
		MediaMedianaModa m = new MediaMedianaModa();
		int[] numMax = new int[2];

		for (int i = 0; i < m.array.length; i++) {
			for (int k = 0; k < 50; k++) {
				int contador = 0;
				for (int j = 0; j < m.array.length; j++) {
					if (k == m.array[j]) {
						contador++;
					}
				}
				if (contador > numMax[1]) {
					numMax[0] = k;
					numMax[1] = contador;
				}
			}
		}
		System.out.println("Resultado Moda: numero " + numMax[0] + " repetido " + numMax[1]);

	}

}
