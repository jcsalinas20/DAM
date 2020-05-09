package ejercicio.CompareTo_Sort;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Personajes> per = new ArrayList<Personajes>();
	static String ordenacion;

	public static void main(String[] args) {
		Personajes p = new Eren("Eren", "Maria", 18, true);
		per.add(p);
		p = new Armin("Armin", "Ross", 17, false);
		per.add(p);
		p = new Reiner("Reiner", "Orvud", 21, true);
		per.add(p);
		p = new Bertholdt("Bertholdt", "Orvud", 22, true);
		per.add(p);
		p = new Mikasa("Mikasa", "Meria", 19, false);
		per.add(p);
		p = new Mikasa("Mikasa", "Maria", 19, false);
		per.add(p);

		MostrarResultados.m();

		System.out.println("\n\nOrdenar por Nombre.");

		ordenacion="nombre";
		for (int i = 0; i < per.size(); i++) {
			p.compareTo(per.get(i));
		}
		Collections.sort(per);
		
		MostrarResultados.m();

		System.out.println("\n\nOrdenar por edad asc.");

		ordenacion="edad";
		for (int i = 0; i < per.size(); i++) {
			p.compareTo(per.get(i));
		}
		Collections.sort(per);
		
		MostrarResultados.m();

		System.out.println("\n\nOrdenar por objeto.");

		ordenacion="objeto";
		for (int i = 0; i < per.size(); i++) {
			p.compareTo(per.get(i));
		}
		Collections.sort(per);
		
		MostrarResultados.m();
	}

}
