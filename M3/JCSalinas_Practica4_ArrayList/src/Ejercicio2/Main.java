package Ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<String> alumnos = new ArrayList<String>();
		ArrayList<ArrayList<Integer>> notas = new ArrayList<ArrayList<Integer>>();

		nombreAlumnos(alumnos);

		introducirNotas(alumnos, notas);

		mostrarNotas(alumnos, notas);
	}

	private static void mostrarNotas(ArrayList<String> alumnos, ArrayList<ArrayList<Integer>> notas) {
		int cont = 0;
		for (Object i : alumnos) {
			System.out.print(i);
			System.out.println(notas.get(cont));
			cont++;
		}
	}

	private static void introducirNotas(ArrayList<String> alumnos, ArrayList<ArrayList<Integer>> notas) {
		int cont = 0;
		System.out.println("Numero negativo para terminar con cada alumno.\n");
		for (Object i : alumnos) {
			notas.add(new ArrayList<Integer>());

			int nota = 0;
			System.out.println("Introduce las notas de " + i);

			while (nota >= 0) {
				nota = lector.nextInt();
				if (nota < 0) {
					break;
				} else {
					notas.get(cont).add(nota);
				}
			}

			cont++;
		}
	}

	private static void nombreAlumnos(ArrayList<String> alumnos) {
		alumnos.add("Carlos");
		alumnos.add("Juan");
		alumnos.add("Adrian");
//		alumnos.add("Miquel");
//		alumnos.add("Sergio");
//		alumnos.add("Eric");
//		alumnos.add("Oriol");
//		alumnos.add("Dani");
//		alumnos.add("Jesus");
//		alumnos.add("David");
	}

}
