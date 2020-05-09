package Ejercicio2;

import java.util.Scanner;

public class Main {
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		Vehicles[] v = new Vehicles[10];

		v[0] = new Vehicle1(0, 0, null, 0, null);
		v[1] = new Vehicle2(0, 0, null, 0, null);
		v[2] = new Vehicle3(0, 0, null, 0, null);
		v[3] = new Vehicle4(0, 0, null, 0, null);
		v[4] = new Vehicle5(0, 0, null, 0, null);
		v[5] = new Vehicle6(0, 0, null, 0, null);
		v[6] = new Vehicle7(0, 0, null, 0, null);
		v[7] = new Vehicle8(0, 0, null, 0, null);
		v[8] = new Vehicle9(0, 0, null, 0, null);
		v[9] = new Vehicle10(0, 0, null, 0, null);

		introducirDatos(v);

		mostrarDatos(v);
	}

	private static void mostrarDatos(Vehicles[] v) {
		System.out.print("\nMostrar datos(Si o No): ");
		String opcion = lector.next();
		if (opcion.equalsIgnoreCase("si")) {
			for (int i = 0; i < v.length; i++) {
				if (v[i].tipoCoche != null) {
					Vehicles.mostrarInfo(v, i);
				}
			}
		}
	}

	private static void introducirDatos(Vehicles[] v) {
		System.out.println("Introduce \"fi\" en matriculacion para terminar.");
		for (int i = 0; i < v.length; i++) {
			System.out.println("Vehicle" + (i + 1));

			System.out.print("Fecha de matriculacion: ");
			v[i].fechaMatriculacion = lector.next();
			if (v[i].fechaMatriculacion.equalsIgnoreCase("fi")) {
				break;
			}
			System.out.print("Numero de Ocupantes: ");
			v[i].numOcupantes = lector.nextInt();
			System.out.print("Numero de ruedas: ");
			v[i].numRuedas = lector.nextInt();
			System.out.print("Numero de Puertas: ");
			v[i].numPuertas = lector.nextInt();
			System.out.print("Tipo de coche(familiar, todoterreno...): ");
			v[i].tipoCoche = lector.next();
			System.out.println("\n");

		}
	}

}
