package ejercicio.ArrayList.Productos;

import java.util.ArrayList;

public class ArrayProducte {
	static ArrayList<Producte> array = new ArrayList<Producte>();

	public void agregar() {
		System.out.print("Codi: ");
		int codi = Main.lector.nextInt();
		System.out.print("Nom: "); 
		Main.lector.nextLine();
		String nom = Main.lector.nextLine();
		System.out.print("Tipus: ");
		String tipus = Main.lector.next();
		System.out.print("Preu: ");
		double preu = Main.lector.nextDouble();
		System.out.print("Stock: ");
		int stock = Main.lector.nextInt();
		Producte p = new Producte(codi, nom, tipus, preu, stock);
		if (buscar(codi)) {
			array.add(p);
		} else {
			System.out.println("El codi indroduir ja existeix.");
		}
	}

	public void eliminar() {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getStock() == 0) {
				array.remove(i);
			}
		}
	}

	public void obtenir() {
		for (Producte o : array) {
			System.out.println(o.toString());
		}
	}

	public boolean buscar(int codi) {
		boolean repetido = true;
		if (array.size() > 0) {
			for (int i = 0; i < array.size(); i++) {
				if (codi == array.get(i).getCodi()) {
					repetido = false;
				}
			}
		}
		return repetido;
	}

	public void grandaria() {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getTipus().equalsIgnoreCase("oficina")) {
				array.get(i).setPreu(array.get(i).getPreu() + 1.10);
			}
		}
	}

}
