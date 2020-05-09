import java.io.*;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		try {
			File vehicles = new File("Ejercicio4/Vehicles.txt");
			File tipoVehicles = new File("");
			int contadorRevisones = 0;
			int ultimaRevision = 0;
			String frase = "";
			Scanner lectorFichero = new Scanner(vehicles);
			Scanner lectorBenzinaRevisiones = new Scanner(vehicles);
			PrintStream escriptor = null;

			while (!lectorBenzinaRevisiones.hasNext("FI")) {
				String tipoBenzina = lectorBenzinaRevisiones.next();
				if (tipoBenzina.equalsIgnoreCase("BENZINA")) {
					frase = "";
					contadorRevisones = 0;
					tipoVehicles = new File("Ejercicio4/BENZINA.txt");
					escriptor = new PrintStream(tipoVehicles);
					while (!lectorBenzinaRevisiones.hasNext("-1")) {
						ultimaRevision = lectorBenzinaRevisiones.nextInt();
						contadorRevisones++;
					}
					while (!lectorFichero.hasNext("BENZINA")) {
						frase += lectorFichero.next() + " ";
					}
					frase += "BENZINA num revisions: " + contadorRevisones + " last: " + ultimaRevision;
					System.out.println(frase);
					escriptor.println(frase);
					lectorFichero.nextLine();
				} else if (tipoBenzina.equalsIgnoreCase("DIESEL")) {
					frase = "";
					contadorRevisones = 0;
					tipoVehicles = new File("Ejercicio4/DIESEL.txt");
					escriptor = new PrintStream(tipoVehicles);
					while (!lectorBenzinaRevisiones.hasNext("-1")) {
						ultimaRevision = lectorBenzinaRevisiones.nextInt();
						contadorRevisones++;
					}
					while (!lectorFichero.hasNext("DIESEL")) {
						frase += lectorFichero.next() + " ";
					}
					frase += "DIESEL num revisions: " + contadorRevisones + " last: " + ultimaRevision;
					System.out.println(frase);
					escriptor.println(frase);
					lectorFichero.nextLine();
				} else if (tipoBenzina.equalsIgnoreCase("ELECTRIC")) {
					frase = "";
					contadorRevisones = 0;
					tipoVehicles = new File("Ejercicio4/ELECTRIC.txt");
					escriptor = new PrintStream(tipoVehicles);
					while (!lectorBenzinaRevisiones.hasNext("-1")) {
						ultimaRevision = lectorBenzinaRevisiones.nextInt();
						contadorRevisones++;
					}
					while (!lectorFichero.hasNext("ELECTRIC")) {
						frase += lectorFichero.next() + " ";
					}
					frase += "ELECTRIC num revisions: " + contadorRevisones + " last: " + ultimaRevision;
					System.out.println(frase);
					escriptor.println(frase);
					lectorFichero.nextLine();
				}

			}

			lectorBenzinaRevisiones.close();
			lectorFichero.close();
//			escriptorFichero.close();
		} catch (Exception e) {
//			System.out.println("Error: " + e);
			e.printStackTrace();
		}
	}

}
