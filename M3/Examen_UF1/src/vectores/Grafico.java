package vectores;

public class Grafico {

	public static void main(String[] args) {
		float[] array = { 12.00f, 2.34f, 3.30f, 56.20f, 45.60f, 34.50f, 23.40f, 1.20f, 101.00f, 10.40f, 23.50f, 50.20f,
				69.40f };
		float valorMax = 0f;

		for (int i = 0; i < array.length; i++) {
			if (array[i] > valorMax) {
				valorMax = array[i];
			}
		}

		for (int i = 0; i < array.length; i++) {
			double longitud = Math.floor(70 * (array[i] / valorMax));
			System.out.print(array[i] + "\t|");
			for (int j = 0; j < longitud; j++) {
				System.out.print("=");
			}
			System.out.println(" (" + (int) longitud + ")");
		}
	}

}
