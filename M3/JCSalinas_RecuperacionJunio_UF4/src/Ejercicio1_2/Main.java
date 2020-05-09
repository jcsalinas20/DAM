package Ejercicio1_2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static Furgoneta f1 = new Furgoneta();
	public static Furgoneta f2 = new Furgoneta();
	public static Turisme t1 = new Turisme();
	public static Turisme t2 = new Turisme();
	public static Conductor conductor1 = new Conductor();
	public static Mossos m1 = new Mossos();
	public static Camio c1 = new Camio();
	public static Camio c2 = new Camio();
	static ArrayList<Vheicle> array = new ArrayList<Vheicle>();
	public static String ordenacion;

	public static void main(String[] args) {

		f1.setMatricula("ABC2154");
		f1.setMarcaModel("Volkswagen Multivan");
		f1.setCombustible("gasoli");
		f1.setKm(10);
		f1.setPrecio(50f);

		array.add(f1);

		t1.setMatricula("WER6159");
		t1.setMarcaModel("Seat Toledo");
		t1.setCombustible("super 98");
		t1.setKm(500);
		t1.setPrecio(40f);

		array.add(t1);

		f2.setMatricula("EFK3209");
		f2.setMarcaModel("Volkswagen Multivan");
		f2.setCombustible("super 95");
		f2.setKm(300);
		f2.setPrecio(20f);

		array.add(f2);

		t2.setMatricula("YUI1235");
		t2.setMarcaModel("Seat Toledo");
		t2.setCombustible("super 95");
		t2.setKm(200);
		t2.setPrecio(50f);

		array.add(t2);

		conductor1.setNomeni("Pedro");
		conductor1.setDni("45812457W");
		conductor1.setTarifa(80);
		m1.setNomeni("Carlos");
		m1.setDni("25896321P");
		c1.setMatricula("AWX1452");
		c1.setMarcaModel("BMW i3");
		c1.setCombustible("super 95");
		c1.setKm(250);
		c1.setPrecio(50f);
		c1.setKg(1200);

		array.add(c1);

		conductor1.setNomeni("Pedro");
		conductor1.setDni("45812457W");
		conductor1.setTarifa(60);
		m1.setNomeni("Carlos");
		m1.setDni("25896321P");
		c2.setMatricula("AWX1452");
		c2.setMarcaModel("BMW i3");
		c2.setCombustible("super 98");
		c2.setKm(150);
		c2.setPrecio(20f);
		c2.setKg(2000);

		array.add(c2);

		mostrarArray();

		sumaTotal();

		System.out.println("\n\n\n******************************Ejercicio2**************************");
		System.out.println("Ordenacion por Matricula.");
		
		ordenacion="matricula";
		for (int i = 0; i < array.size(); i++) {
			c2.compareTo(array.get(i));
		}
		Collections.sort(array);

		mostrarArray();
		System.out.println("\n\n\n\nOrdenacion por Marca.");
		
		ordenacion="marca";
		for (int i = 0; i < array.size(); i++) {
			c2.compareTo(array.get(i));
		}
		Collections.sort(array);

		mostrarArray();
	}

	private static void mostrarArray() {
		for (Vheicle o : array) {
			System.out.println(o.toString());
		}
	}

	private static void sumaTotal() {
		float total = f1.getPrecio();
		total = f2.getPrecio();
		total = t1.getPrecio();
		total = t2.getPrecio();
		total = c1.getPrecio();
		total = c2.getPrecio();
		System.out.println("Suma total de precios: " + total);
	}

}
