import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		try {
			String dirTreball = System.getProperty("user.dir");
			File persona = new File(dirTreball + "/Persones.txt");
			if (persona.exists() == true) {
				Scanner lectorFichero = new Scanner(persona);
				Scanner mostrarPersonas = new Scanner(persona);
				String separador = "------------------";
				boolean fi = false;
				while (!fi) {
					if (lectorFichero.next().equalsIgnoreCase("edat:")) {
						boolean edatEncontrada = false;
						boolean siguientePersona = false;
						while (!edatEncontrada) {
							if (lectorFichero.nextInt() >= 18) {
								siguientePersona = false;
								while (!siguientePersona) {
									boolean encontrado = mostrarPersonas.hasNext(separador);
									if (encontrado == true) {
										mostrarPersonas.next();
										siguientePersona = true;
									} else {
										System.out.println(mostrarPersonas.nextLine());
									}
								}
							} else {
								siguientePersona = false;
								while (!siguientePersona) {
									if (mostrarPersonas.next().equals(separador)) {
										siguientePersona = true;
									} else {
										mostrarPersonas.nextLine();
									}
								}
							}
							siguientePersona = false;
							while (!siguientePersona) {
								boolean encontrado = lectorFichero.hasNext(separador);
								if (encontrado == true) {
									lectorFichero.nextLine();
									siguientePersona = true;
									edatEncontrada = true;
								} else {
									lectorFichero.nextLine();
								}
							}
						}
					} else if (lectorFichero.next().equalsIgnoreCase("fi")) {
						fi = true;
					} else {
						lectorFichero.nextLine();
					}
				}
				mostrarPersonas.close();
				lectorFichero.close();
			} else {
				System.out.println("Crea el archivo para poder mostrar el resultado.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
