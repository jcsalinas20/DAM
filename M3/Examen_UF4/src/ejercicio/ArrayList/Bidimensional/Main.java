package ejercicio.ArrayList.Bidimensional;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		ArrayList<String> nombres = new ArrayList<String>();
		ArrayList<ArrayList<Integer>> notas = new ArrayList<ArrayList<Integer>>();

		nombres.add("Miquel");
		nombres.add("Eric");
		nombres.add("Carlos");

		for (int i = 0; i < nombres.size(); i++) {
			boolean fi = false;
			notas.add(new ArrayList<Integer>());// IMPORTANTE!!!!!
			System.out.println("Introduce las notas de " + nombres.get(i) + ": ");
			while (!fi) {
				int nota = lector.nextInt();
				if (nota < 0) {
					fi = true;
				} else {
					notas.get(i).add(nota);
				}
			}
		}

		for (int i = 0; i < nombres.size(); i++) {
			System.out.println(nombres.get(i) + ": ");
			for (int j = 0; j < notas.get(i).size(); j++) {
				if (j == notas.get(i).size() - 1) {
					System.out.print(notas.get(i).get(j));
				} else {
					System.out.print(notas.get(i).get(j) + ", ");
				}
			}
			System.out.println();
		}
		lector.close();

	}

}
