import java.util.ArrayList;

public interface OrdenacionPorAltura {

	public static void sinOrdenar(ArrayList<Persona> personas) {
		System.out.println("Personas sin ordenar");
		for (int i = 0; i < personas.size(); i++) {
			System.out.print(personas.get(i).getNombre() + " - Altura: " + personas.get(i).getAltura() + " - Edad: "
					+ personas.get(i).getEdad());
			System.out.println();
		}
		System.out.println();
	}

	public static void Ordenado(ArrayList<Persona> personas) {
		System.out.println("Personas ordenaradas");
		for (int i = 0; i < personas.size(); i++) {
			System.out.print(personas.get(i).getNombre() + " - Altura: " + personas.get(i).getAltura() + " - Edad: "
					+ personas.get(i).getEdad());
			System.out.println();
		}
	}
	
}
