import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ejercicio2 {
	static boolean validacion = false;
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		try {
			String dirTreball = System.getProperty("user.dir");
			File path = new File(dirTreball + "/NotaMitja.txt");
			if (path.exists() == false) {
				path.createNewFile();
				System.out.println("Se ha creado el archivo \"notaMitja.txt\" inicia el programa otra vez.");
			} else {
				Scanner lectorFichero = new Scanner(path);
				PrintStream escriptor = new PrintStream(path);
				boolean fi = false;
				System.out.println("Introduce \"fi\" en el nombre para finalizar.");
//				INTRODUCCION DE DATOS DE ALUMNOS
				while (!fi) {
					System.out.print("Introduce el nombre del Alumno\\a: ");
					String nom = lector.next();
					escriptor.print(nom);
					if (nom.equalsIgnoreCase("fi")) {
						fi = true;
					} else {
						boolean notasFi = false;
						int notas = 0;
						System.out.println("Introduce las notas de " + nom + " (-1 para finalizar):");
						while (!notasFi) {
							if (notas == -1) {
								escriptor.println();
								notas = 0;
								notasFi = true;
							} else {
								validacion = false;
								do {
									notas = validacion(notas);
								} while (validacion != true);
								escriptor.print(" " + notas);
							}
						}
					}
				}
//				CALCULO DE LA NOTA MITJANA
				fi = false;
				int media = 0;
				int contador = 0;
				Float mediaFinal = 0f;
				while (!fi) {
					if (lectorFichero.hasNext("fi")) {
						fi = true;
					} else {
						boolean mediaNotas = false;
						while (!mediaNotas) {
							if (lectorFichero.hasNextInt()) {
								if (lectorFichero.hasNext("-1")) {
									mediaFinal = (float) (media / contador);
									System.out.println("(Mitja: "+mediaFinal+")");
									lectorFichero.next();
									mediaNotas = true;
								} else {
									media = media + lectorFichero.nextInt();
									contador++;
								}
							} else {
								System.out.print(lectorFichero.next() + " ");
							}
						}
					}
				}
				escriptor.close();
				lectorFichero.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int validacion(int valor) {
		if (lector.hasNextInt()) {
			valor = lector.nextInt();
			if (valor >= -1 && valor <= 10) {
				validacion = true;
				return valor;
			} else {
				System.out.println("Introduce un numero del 0 al 10.");
				lector.nextLine();
				return valor;
			}
		} else {
			System.out.println("Introduce un numero.");
			lector.nextLine();
			return valor;
		}
	}

}
