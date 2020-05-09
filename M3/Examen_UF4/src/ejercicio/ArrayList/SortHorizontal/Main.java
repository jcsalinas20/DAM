package ejercicio.ArrayList.SortHorizontal;

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

//		ArrayList<Integer> array2 = new ArrayList<Integer>(10);
//		array2.add(7);
//		array2.add(1);
//		array2.add(5);
//		array2.add(9);
//		array2.add(2);

		System.out.println("Sin ordenar.");
		for (Object i : array) {
			System.out.println(i.toString());
		}

		for (int i = 0; i < array.size(); i++) {
			ArrayList<Integer> arraySimple = array.get(i);
			Collections.sort((ArrayList<Integer>) arraySimple);
			array.set(i, arraySimple);
		}

//		Ordenar array simple
//		Collections.sort((ArrayList<Integer>) array2);

		System.out.println("\nOrdenar.");
		for (Object i : array) {
			System.out.println(i.toString());
		}
	}
}
