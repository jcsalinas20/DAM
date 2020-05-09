package ejercicio.ArrayList.OrdenarBurbuja;

import java.util.ArrayList;

public class Main {
	static ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>(100);

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			array.add(new ArrayList<Integer>());
			for (int j = 0; j < 10; j++) {
				array.get(i).add((int) (Math.random() * 101));
			}
		}

		System.out.println("Sin ordenar.");
		for (Object i : array) {
			System.out.println(i.toString());
		}

		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size(); j++) {
				for (int k = 0; k < array.size() - 1; k++) {
					if (array.get(k).get(i) > array.get(k + 1).get(i)) {
						array.get(k + 1).add(i, array.get(k).get(i));
						array.get(k).remove(i);
						array.get(k).add(i, array.get(k + 1).get(i + 1));
						array.get(k + 1).remove(i + 1);
					}

				}
			}
		}

		System.out.println("\nOrdenar.");
		for (Object i : array) {
			System.out.println(i.toString());
		}
	}
}
