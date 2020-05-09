package Ejercicio1;

import java.util.Scanner;

public class Principal {
	static boolean validacion = false;
	static boolean validacion2 = false;
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {

		Estudiant alumneCarlos = new Estudiant("Carlos", "Salinas", "47854785E", "AMS", 1);

		cambioCicloCurso(alumneCarlos);
		mostrarAlumno(alumneCarlos);

	}

	public static void mostrarAlumno(Estudiant alumneCarlos) {
		System.out.print("Quieres ver la informacion del alumno: ");
		String opcion = lector.next();
		if (opcion.equalsIgnoreCase("si")) {
			Estudiant.infoAlumno(alumneCarlos);
		}
	}

	public static void cambioCicloCurso(Estudiant alumneCarlos) {
		System.out.println("Quieres cambiar de curso o de ciclo a " + alumneCarlos.getNomAlumne() + " (Si/No).");
		validacion = false;
		do {
			String alumne = lector.next();
			if (alumne.equalsIgnoreCase("si")) {
				do {
					System.out.print("Curso o Ciclo: ");
					String opcion = lector.next();
					if (opcion.equalsIgnoreCase("curso")) {
						System.out.print("Actualmente " + alumneCarlos.getNomAlumne() + " esta en el curso "
								+ alumneCarlos.getCursAlumne() + ".\nA que curso quieres cambiarlo:");
						int nuevoCurso = lector.nextInt();
						Estudiant.cambioCurso(nuevoCurso);
						alumneCarlos.setCursAlumne(nuevoCurso);
						validacion2 = true;
						validacion = true;
					} else if (opcion.equalsIgnoreCase("ciclo")) {
						System.out.print("Actualmente " + alumneCarlos.getNomAlumne() + " esta en el ciclo "
								+ alumneCarlos.getNomCicleAlumne() + ".\nA que ciclo quieres cambiarlo:");
						String nuevoCiclo = lector.next();
						alumneCarlos.setNomCicleAlumne(nuevoCiclo);
						validacion2 = true;
						validacion = true;
					} else {
						lector.nextLine();
					}
				} while (validacion2 != true);
			} else if (alumne.equalsIgnoreCase("no")) {
				validacion = true;
			} else {
				lector.nextLine();
			}
		} while (validacion != true);
	}

}
