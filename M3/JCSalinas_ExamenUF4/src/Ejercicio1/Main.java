package Ejercicio1;

import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		ListaVehiculos lv = new ListaVehiculos();
		lv.vehiculo.add(new motocarro(3, 3, 0, "1111AAA", 0, 30));
		lv.vehiculo.add(new motocarro(4, 8, 0, "4444BBB", 0, 40));
		lv.vehiculo.add(new motocarro(2, 2, 0, "3333CCC", 0, 50));

		opciones(lv);

		opciones2(lv);

		for (int i = 0; i < 10; i++) {
			lv.compareTo(lv.vehiculo.get(i));
		}
		Collections.sort(lv.vehiculo);

		Vehicles.mostrar(lv);
	}

	private static void opciones2(ListaVehiculos lv) {
		boolean fi = false;
		while (!fi) {
			System.out.println("Introduce la matricula: ");
			String matricula = lector.next();
			for (int i = 0; i < lv.vehiculo.size(); i++) {
				boolean fi2 = false;
				int marcha = 0;
				if (matricula.equalsIgnoreCase(lv.vehiculo.get(i).getMatricula())) {
					while (!fi2) {
						System.out.println("Velocidad " + lv.vehiculo.get(i).getVelocidadActual() + "\nMarcha " + marcha
								+ "\nAcelerar, Frenar o CambiarMarcha(fi para terminar): ");
						String opcion = lector.next();
						if (opcion.equalsIgnoreCase("fi")) {
							fi = true;
						} else if (opcion.equalsIgnoreCase("Acelerar")) {
							lv.vehiculo.get(i)
									.setVelocidadActual((lv.acelerar(lv.vehiculo.get(i).getVelocidadActual())));
						} else if (opcion.equalsIgnoreCase("Frenar")) {
							lv.vehiculo.get(i).setVelocidadActual((lv.frenar(lv.vehiculo.get(i).getVelocidadActual())));
						} else if (opcion.equalsIgnoreCase("CambiarMarcha")) {
							marcha = lv.canviar_marxa(lv.vehiculo.get(i).getVelocidadActual(), marcha);
						}
					}
				}
			}
		}
	}

	private static void opciones(ListaVehiculos lv) {
		boolean fi = false;
		while (!fi) {
			System.out.println("Quieres añadir un nuevo vehiculo: ");
			String opcion = lector.next();
			if (opcion.equalsIgnoreCase("no")) {
				fi = true;
			} else if (opcion.equalsIgnoreCase("si")) {
				lv.afegir(lv);
			}
		}
		fi = false;
		while (!fi) {
			System.out.println("Quieres eliminar un vehiculo: ");
			String opcion = lector.next();
			if (opcion.equalsIgnoreCase("no")) {
				fi = true;
			} else if (opcion.equalsIgnoreCase("si")) {
				System.out.println("Introduce la matricula:");
				String opcion2 = lector.next();
				lv.eliminar(lv, opcion2);
			}
		}
		System.out.println("Introduce la matricula del coche que mostrar: ");
		String opcion = lector.next();
		lv.mostrarVelocidad(opcion);
	}

}
