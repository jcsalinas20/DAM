import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Ejercicio3 {
	static Scanner lector = new Scanner(System.in);
	static boolean validacio = false;

	public static void main(String[] args) throws IOException {
		try {
			String dirTreball = System.getProperty("user.dir");
			File persones = new File(dirTreball + "/Persones.txt");
			PrintStream escriptor = new PrintStream(persones);
			if (persones.exists() == true) {
				String[] dadesPersones = { "Nom: ", "Cognom: ", "NIF: ", "Edat: ", "Altura: " };
				String[] dadesIntroduides = new String[5];
				boolean fi = false;
				System.out.println("Para terminar: \"fi\" en nom.");
				while (!fi) {
					for (int i = 0; i <= 2; i++) {
						System.out.print(dadesPersones[i]);
						dadesIntroduides[i] = lector.next();
						if (i == 0 && dadesIntroduides[i].equalsIgnoreCase("fi")) {
							escriptor.print(dadesIntroduides[i]);
							fi = true;
							break;
						} else {
							escriptor.print(dadesPersones[i]);
							escriptor.println(dadesIntroduides[i]);
						}
					}
					if (fi == false) {
						for (int edat = 3; edat < 4; edat++) {
							validacio = false;
							int valor = 0;
							System.out.print(dadesPersones[edat]);
							do {
								valor = validacioEdat(valor);
							} while (validacio != true);
							dadesIntroduides[edat] = String.valueOf(valor);
							escriptor.print(dadesPersones[edat]);
							escriptor.println(dadesIntroduides[edat]);
						}
						for (int altura = 4; altura < 5; altura++) {
							validacio = false;
							float valor = 0f;
							System.out.print(dadesPersones[altura]);
							do {
								valor = validacioAltura(valor);
							} while (validacio != true);
							dadesIntroduides[altura] = String.valueOf(valor);
							escriptor.print(dadesPersones[altura]);
							escriptor.println(dadesIntroduides[altura]);
						}
						String separador = "------------------";
						System.out.println("\n" + separador);
						escriptor.println("\n" + separador);
					}
				}
			} else {
				System.out.println("Se ha creado el archivo " + persones.getName());
				System.out.println("Ejecuta otra vez del programa.");
				persones.createNewFile();
			}
			lector.close();
			escriptor.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e);
		}

	}

	public static int validacioEdat(int valor) {
		if (lector.hasNextInt()) {
			valor = lector.nextInt();
			if (valor >= 0) {
				validacio = true;
				return valor;
			} else {
				System.out.println("Introduce un numero mayor que 0.");
				lector.nextLine();
				return valor;
			}
		} else {
			System.out.println("Introduce un numero.");
			lector.nextLine();
			return valor;
		}
	}

	public static float validacioAltura(float valor) {
		if (lector.hasNextFloat()) {
			valor = lector.nextFloat();
			if (valor >= 0) {
				validacio = true;
				return valor;
			} else {
				System.out.println("Introduce un numero mayor que 0.");
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
