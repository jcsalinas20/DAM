package ejercicio.InvertirArrayList;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();

		contenidoArrayList(array);

		System.out.println("Ordenacion normal");
		System.out.print(array);

		invertirArrayList(array);

		System.out.println("\nOrdenacion inversa");
		System.out.println(array);
	}

	private static void invertirArrayList(ArrayList<String> array) {
		int posicionMax = array.size();
		for (int i = 0; i < array.size(); i++) {
			String valor = array.get(posicionMax - 1);
			array.remove(posicionMax - 1);
			array.add(i, valor);
		}
	}

	private static void contenidoArrayList(ArrayList<String> array) {
		array.add("uno");
		array.add("dos");
		array.add("tres");
		array.add("cuatro");
		array.add("cinco");
		array.add("seis");
	}

}
