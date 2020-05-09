package ejercicio.ArrayList.Figuras;

import java.util.ArrayList;

public class Main {
	static ArrayList<Figura> array = new ArrayList<Figura>(10);

	public static void main(String[] args) {

		Figura f = new Cercle(10);
		
		f.calcularArea(f);
		
		System.out.println(f.getArea());
		
//		System.out.println(f.getClass().getSimpleName().equals("Cercle"));
	}

}
