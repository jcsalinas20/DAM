package comandos;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayList_ {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Juan");
		lista.add("Carlos");
		lista.add("Navarrete");

		System.out.println("Longitud: " + lista.size() + "\n");

		System.out.print("[");
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i) + ", ");
		}
		System.out.println("]\n");

		lista.set(1, "Salinas");
		System.out.print("[");
		for (String o : lista) {
			System.out.print(o + ", ");
		}
		System.out.println("]\n");

		lista.add(1, "Carlos");
		System.out.print("[");
		Iterator<String> it = lista.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", ");
		}
		System.out.println("]\n");

		System.out.println("El array contiene Carlos: " + lista.contains("Carlos") + "\n");

		System.out.println("Posicion donde se encuentra Salinas: " + lista.indexOf("Salinas") + "\n");

		System.out.println("Posicion donde se encuentra Juan: " + lista.lastIndexOf("Juan") + "\n");

		System.out.println("Eliminar posicion 0: " + lista.remove(0) + "\n");

		System.out.println("Clonar array: " + lista.clone() + "\n");

		System.out.println("Esta vacio: " + lista.isEmpty() + "\n");

		lista.clear();

		System.out.println("Esta vacio: " + lista.isEmpty() + "\n");
	}

}
