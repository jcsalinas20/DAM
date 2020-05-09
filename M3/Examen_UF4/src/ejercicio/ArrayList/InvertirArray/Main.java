package ejercicio.ArrayList.InvertirArray;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();

		for (int i = 0; i < 7; i++) {
			array.add(i);
		}

		for (Integer o : array) {
			System.out.print(o + ", ");
		}
		System.out.println();
		System.out.println();

		for (int i = array.size() - 1; i >= 0; i--) {
			array.add(array.get(i));
		}

		int max = array.size() / 2;
		for (int i = 0; i < max; i++) {
			array.remove(0);
		}

		for (Integer o : array) {
			System.out.print(o + ", ");
		}

	}

}
