import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		ArrayList<Persona> personas = new ArrayList<Persona>();

		Persona p = new Dani("Dani", 187, 22);
		personas.add(p);
		p = new Pol("Pol", 173, 52);
		personas.add(p);
		p = new Manel("Manel", 158, 27);
		personas.add(p);
		p = new David("David", 164, 25);
		personas.add(p);
		p = new Pere("Pere", 184, 80);
		personas.add(p);

		OrdenacionPorAltura.sinOrdenar(personas);

		for (int i = 0; i < personas.size(); i++) {
			p.compareTo(personas.get(i));
		}

		Collections.sort(personas);

		OrdenacionPorAltura.Ordenado(personas);
	}

}
