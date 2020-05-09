import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Ejercicio6 programa = new Ejercicio6();
		programa.inici();
	}

	public void inici() {
		try {
			Scanner teclat = new Scanner(System.in);
			System.out.print("Escriu el nom del fitxer a editar: ");
			String origen = teclat.nextLine();
			File fitxer = new File(origen);
			RandomAccessFile raf = new RandomAccessFile(fitxer, "rw");

			boolean executar = true;

			while (executar) {
				mostrarFitxer(raf);
				System.out.println("\n-------------");
				System.out.print("Comanda: ");
				// Llegir comanda
				String comanda = teclat.next();
				if ("x".equals(comanda)) {
					executar = false;
				} else {
					if ("a".equals(comanda) && teclat.hasNextInt()) {
						int valor = teclat.nextInt();
						afegirValor(raf, valor);
					} else if ("d".equals(comanda) && teclat.hasNextInt()) {
						int posicio = teclat.nextInt();
						eliminarValor(raf, posicio);
					} else {
						System.out.println("Comanda desconeguda.");
					}
				}
			}

			raf.close();

		} catch (Exception e) {
			System.out.println("Error accedint al fitxer: " + e);
		}
	}

	/**
	 * Mostra el contingut del fitxer per pantalla, escrivint 10 valors per fila.
	 * Fixeu-vos que un RandomAccessFile es pot passar com a paràmetre.
	 *
	 * @param raf Fitxer d'acces relatiu a mostrar
	 */
	public void mostrarFitxer(RandomAccessFile raf) {
		try {
			long numEnters = raf.length() / 4;
			// Cal garantir que l'apuntador esta al principi
			raf.seek(0);
			for (long i = 0; i < numEnters; i++) {
				if (i % 10 == 0) {
					System.out.println();
				}
				int valor = raf.readInt();
				System.out.print(valor + " ");
			}
		} catch (Exception e) {
			System.out.println("Error llegint fitxer: " + e);
		}
	}

	public void afegirValor(RandomAccessFile raf, int valor) {
		try {
			long fiFitxer = raf.length();
			raf.seek(fiFitxer);
			raf.writeInt(valor);
		} catch (Exception e) {
			System.out.println("Error modificant fitxer: " + e);
		}
	}

	public void eliminarValor(RandomAccessFile raf, int posicio) {
		try {
			if ((posicio >= raf.length() / 4) || (posicio < 0)) {
				System.out.println("Aquesta posició no existeix.");
			} else {
				long midaFinal = raf.length() - 4;
				// Per esborrar un valor, cal desplaçar tots els posteriors a sobre
				// de l'anterior valor.
				long posMoure = (posicio + 1) * 4;
				while (posMoure < raf.length()) {
					raf.seek(posMoure);
					int valor = raf.readInt();
					raf.seek(posMoure - 4);
					raf.writeInt(valor);
					posMoure = posMoure + 4;
				}
				// Queda el darrer valor repetit. Cal ajustar la nova mida del fitxer
				raf.setLength(midaFinal);
			}
		} catch (Exception e) {
			System.out.println("Error modificant fitxer: " + e);
		}
	}

}
