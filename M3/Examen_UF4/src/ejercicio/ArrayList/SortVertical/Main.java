package ejercicio.ArrayList.SortVertical;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>(100);
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
			ArrayList<Integer> arraySimple = new ArrayList<Integer>();
			for (int j = 0; j < array.size(); j++) {
				arraySimple.add(array.get(j).get(i));
			}
			Collections.sort((ArrayList<Integer>) arraySimple);
			for (int j = 0; j < array.size(); j++) {
				array.get(j).set(i, arraySimple.get(j));
			}
		}

		System.out.println("\nOrdenar.");
		for (Object i : array) {
			System.out.println(i.toString());
		}
	}
}
