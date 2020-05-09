package Practica1;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Ejercicio3 programa = new Ejercicio3();
		programa.programaGeneral();
	}

	public void programaGeneral() {
		Scanner lector = new Scanner(System.in);
		int[] notas = new int[10];
		String opcion = "";
		float[] mediaNotas = new float[1];
		boolean validacion = false;
		boolean seguir = false;

		ingresarNotas(notas);

		while (seguir == false) {

			System.out.println(
					"Bienvenido al gestor de notas" + "\n-----------------------------" + "\n[RT] Registrar Notas"
							+ "\n[MJ] Consultar Nota Media" + "\n[HT] Histograma de Notas" + "\n[FI] Salir");

			System.out.print("\n(Key Sensitive) Opcion: ");

			validacion = false;
			do {
				opcion = lector.nextLine();
				if (opcion.equals("RT")) {
					validacion = true;
				} else if (opcion.equals("MJ")) {
					validacion = true;
				} else if (opcion.equals("HT")) {
					validacion = true;
				} else if (opcion.equals("FI")) {
					validacion = true;
				} else {
					System.out.print("Error. Intentalo otra vez: ");
				}
			} while (validacion != true);

			switch (opcion) {
			case "RT":
				reescribirNotas(notas);
				break;
			case "MJ":
				media(mediaNotas, notas);
				break;
			case "HT":
				histograma(notas);
				break;
			case "FI":
				seguir = true;
				break;
			}

		}
	}

	//INGRESO DE NOTAS DE ALUMNOS
	public void ingresarNotas(int[] notas) {
		Scanner lector = new Scanner(System.in);
		boolean validacion = false;

		do {
			System.out.println("Ingrese las notas de los alumnos (Obligatorio 10 notas).");
			for (int i = 0; i < notas.length; i++) {
				if (lector.hasNextInt()) {
					notas[i] = lector.nextInt();
					if (notas[i] >= 0 && notas[i] < 11) {
						validacion = true;
					} else {
						i--;
						System.out.println("Ingresa un numero positivo o menor de 11.");
					}
				} else {
					i--;
					lector.nextLine();
					System.out.println("Ingrese un numero.");
				}
			}
		} while (validacion != true);
	}

	//OPCION REGISTRAR NOTAS
	public void reescribirNotas(int[] notas) {
		Scanner lector = new Scanner(System.in);
		boolean validacion = false;
		boolean infinito = false;

		do {
			System.out.println("Ingrese las notas de los 10 alumnos (Ingresa el numero -1 para terminar).");
			while (infinito == false) {
				for (int i = 0; i < notas.length; i++) {
					if (lector.hasNextInt()) {
						int numAnterior = notas[i];
						notas[i] = lector.nextInt();
						if (notas[i] == -1) {
							notas[i]=numAnterior;
							System.out.println("As salido de \"Registrar Notas\".");
							infinito = true;
							validacion = true;
							break;
						} else if (notas[i] >= 0 && notas[i] < 11) {
							validacion = true;
						} else {
							i--;
							System.out.println("Ingresa un numero positivo o menor de 11.");
						}
					} else {
						i--;
						lector.nextLine();
						System.out.println("Ingrese un numero.");
					}
				}
				if (infinito == false) {
					System.out.println("Has completado la vuelta (-1 para salir).");
				}
			}
		} while (validacion != true);
	}

	//OPCION CONSULTAR NOTA MEDIA
	public void media(float[] mediaNotas, int[] notas) {
		float suma = 0f;

		for (int i = 0; i < notas.length; i++) {
			suma = suma + notas[i];
		}
		mediaNotas[0] = suma / notas.length;

		System.out.println("\nMedia de las notas: " + mediaNotas[0] + "\n");
	}

	//OPCION HISTOGRAMA DE NOTAS
	public void histograma(int[] notas) {
		String[] calificaciones = { " Suspensos: ", " Aprobados: ", "  Notables: ", "Excelentes: " };
		int[] notasCalificadas = new int[4];

		for (int i = 0; i < notas.length; i++) {
			if (notas[i] < 5) {
				notasCalificadas[0]++;
			} else if (notas[i] >= 5 && notas[i] < 6.5) {
				notasCalificadas[1]++;
			} else if (notas[i] >= 6.5 && notas[i] < 8.5) {
				notasCalificadas[2]++;
			} else if (notas[i] >= 8.5) {
				notasCalificadas[3]++;
			}
		}

		System.out.println("\nNotas: " + Arrays.toString(notas) + "\n");

		for (int i = 0; i < notasCalificadas.length; i++) {
			System.out.print(calificaciones[i]);
			for (int j = 0; j < notasCalificadas[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

}
