
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class Pt2 implements Serializable {
	private static final long serialVersionUID = 1L;

//	Ruta del fichero
	static File archivo = new File("cursos.dat");

//	HashMap para guardar la Clase Curs
	HashMap<String, Curs> cursos = new HashMap<String, Curs>();
//	booelanos para los 3 menus
	static boolean primerBucle = false, segonBucle = false, tercerBucle = false;
//	Variables ID curs y modul.
	static String idCurs;
	String idModul;
//	Declaracion de la misma clase para poder llamar dentro de la clase de forma no statica
	static Pt2 main = new Pt2();
	transient Scanner lector = new Scanner(System.in);

//	Metodo para leer el archivo
	public static void dadesIn(File archivo) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			Object auxiliar = ois.readObject();
			while (auxiliar != null) {
				Curs c = (Curs) auxiliar;
				idCurs = c.key;// Guardar la key en la ID declarada globalmente
				main.cursos.put(idCurs, c);// Agregar Curs(c) al HashMap
				auxiliar = ois.readObject();
			}
			ois.close();
		} catch (Exception e) {
			System.out.println("Fitxer llegit correctament.");
		}
	}

//	Metodo para leer el archivo
	private static void dadesOut(File archivo) {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(archivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Entry<String, Curs> entry : main.cursos.entrySet()) {
				oos.writeObject(entry.getValue());// Escribir el objeto Curs en el archivo
			}
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	 Metodo para mostrar el menu por pantalla
	public void principal() {
		System.out.print("PROPOSTA DE RESOLUCIO PT2 (STREAMS D'OBJECTES)\r\n"
				+ "===============================================\r\n" + "1. AFEGIR UN NOU CURS\r\n"
				+ "2. MODIFICAR UN CURS\r\n" + "3. MOSTRAR DADES CURS \r\n" + "4. ELIMINAR UN CURS\r\n"
				+ "5. SORTIR;\r\n" + "Escull una opcio: ");
		int opcio = opcioMenu("principal");// Metodo para comprobar el numero introducido pot teclado
		menuPrincipal(opcio);// Metodo para hacer las acciones del menu principal
	}

//	 Metodo para hacer las acciones del menu principal
	private void menuPrincipal(int opcio) {
		switch (opcio) {
		case 1:
			idCurs = main.nomDelCurs();// Metodo para introducir el nombre del curso
			main.cursos.put(idCurs, new Curs());// Creacion del curso
			main.cursos.get(idCurs).key = idCurs;// Agregacion del nombre del curso a la variable key del HashMap
//			 Mensaje con los parametros del Curs
			System.out.println("Creacio per defecte del curs " + idCurs + "= " + main.cursos.get(idCurs).toString());
			break;
		case 2:
			idCurs = main.nomDelCurs();// Metodo para introducir el nombre del curso
			System.out.println();// Salto de linea
			secundario(idCurs);// Metodo para mostrar el segundo menu y meterse en el segundo while
			break;
		case 3:
			Iterator<String> iterator = main.cursos.keySet().iterator();
			while (iterator.hasNext()) {// Mostrar todos los cursos
				String key = iterator.next();
				System.out.println(key + "= " + main.cursos.get(idCurs).toString());

			}
			break;
		case 4:
			idCurs = main.nomDelCurs();// Metodo para introducir el nombre del curso
			boolean cursTrobat = false;// Boolean para saber si se ha encontrado el curso
			iterator = main.cursos.keySet().iterator();
			while (iterator.hasNext()) {// Recorer todo el HashMap
				String id = iterator.next();
				if (id.equals(idCurs)) {// Comparar el curso introducido con el del HashMap
					cursTrobat = true;
					main.cursos.remove(idCurs);// Borrar cuso
					System.out.println("El curs " + idCurs + " s'ha esborrat correctament. ");// Mensaje
					break;
				}
			}
			if (!cursTrobat) {
				System.out.println("No s'ha trobat ningun curs.");// Mensaje si no se ha encontrado
			}
			break;
		case 5:
			Pt2.primerBucle = true;// Fin del bucle y del programa
			System.out.println("\nEl programa ha finalitzat.");
			break;
		}
		System.out.println();// Salto de linea
	}

//	 Metodo para mostrar el segundo menu y meterse en el segundo while
	public void secundario(String idCurs) {// Le pasamos el ID para saber el curso en el que estamos
		Pt2.segonBucle = false;
		while (!Pt2.segonBucle) {// Empieza el segundo bucle
			System.out.print("Que vols fer amb el curs?\r\n" + "1. Canviar de tutor\r\n" + "2. Afegir alumnes a id\r\n"
					+ "3. Treure alumnes de id\r\n" + "4. Afegir un nou modul a id\r\n"
					+ "5. Modificar dades d'un modul\r\n" + "6. Eliminar un modul a id\r\n" + "7. TORNAR\r\n"
					+ "Escull una opcio: ");
			int opcio = opcioMenu("secundari");// Metodo para comprobar el numero introducido pot teclado
			menuSecundario(opcio, idCurs);// Metodo para hacer las acciones del menu secundario
		}
	}

//	 Metodo para hacer las acciones del menu secundario
	private void menuSecundario(int opcio, String idCurs) {
		switch (opcio) {
		case 1:
//			Metodo para introducir el un String con el nombre del tutor
			String tutor = main.cursos.get(idCurs).introducirNombreTutor(idCurs);
			main.cursos.get(idCurs).setTutor(tutor);// Agregamos el String devuelto a la clase Curs
			break;
		case 2:
//			Metodo para introducir los nombres de los lumnos
			String[] alumnes = main.cursos.get(idCurs).demanarElsAlumnes(idCurs);
			for (int i = 0; i < alumnes.length; i++) {
				for (int j = 0; j < main.cursos.get(idCurs).alumnes.size(); j++) {
					if (alumnes[i].equals(main.cursos.get(idCurs).alumnes.get(j))) {
						alumnes[i] = null;// Poner null si el nombre del alumno ya esta introducido
					}
				}
			}
			for (int i = 0; i < alumnes.length; i++) {
				if (alumnes[i] != null) {// Las posiciones en null no entran
					main.cursos.get(idCurs).alumnes.add(alumnes[i]);// Agregamos los nombres al array
				}
			}
			break;
		case 3:
//			Metodo para introducir los nombres de los lumnos
			alumnes = main.cursos.get(idCurs).demanarElsAlumnes(idCurs);
			for (int i = 0; i < alumnes.length; i++) {
				for (int j = main.cursos.get(idCurs).alumnes.size() - 1; j >= 0; j--) {
//					Buscar el alumno en el arraylist
					if (alumnes[i].equals(main.cursos.get(idCurs).alumnes.get(j))) {
						main.cursos.get(idCurs).alumnes.remove(alumnes[i]);// Borrar alumno
					}
				}
			}
			break;
		case 4:
//			Metodo para introducir el numero y nombre del modulo
			String modul = main.cursos.get(idCurs).demanarModul(idCurs);
			String[] numYnomModul = modul.split(":");// Separa entre el numero(M6) y el nombre (Acceso a datos)
			numYnomModul[0] = main.convertirUpperCase(numYnomModul[0]);// Metodo para convertir String todo en maysculas
			main.cursos.get(idCurs).moduls.put(numYnomModul[0], new Modul());// Creacion del modulo en el HashMap deCurs
			main.cursos.get(idCurs).moduls.get(numYnomModul[0]).setNom(numYnomModul[1]);// Agregar el nombre del modulo
			break;
		case 5:
			boolean modulTrobat = false;
			System.out.print("Introdueix el numero de Modul(Ej. M6, M7, M8): ");
			idModul = main.lector.next();
			idModul = main.convertirUpperCase(idModul);// Metodo para convertir String todo en maysculas
			Iterator<String> iter = main.cursos.get(idCurs).moduls.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				if (idModul.equals(key)) {// Buscar si el idModulo introducido existe
					modulTrobat = true;
					System.out.println();// Salto de linea
					terciario(idCurs, idModul);// Metodo para mostrar el tercer menu y meterse en el tercer while
				}
			}
			if (!modulTrobat) {
				System.out.println("No s'ha trobat ningun modul.\n");
			}
			break;
		case 6:
//			Metodo para introducir el numero y nombre del modulo
			modul = main.cursos.get(idCurs).demanarModul(idCurs);
			numYnomModul = modul.split(":");// Separa entre el numero(M6) y el nombre (Acceso a datos)
			main.cursos.get(idCurs).moduls.remove(numYnomModul[0]);// Borrar el Modulo del HashMap
			System.out.println("S'ha esborrat correctament.");
			break;
		case 7:
			Pt2.segonBucle = true;// Salir del segundo bucle para volver al primero
			System.out.println("Has tornat al menu anterior.");
			break;
		}
		System.out.println(idCurs + "= " + main.cursos.get(idCurs).toString());
		System.out.println();

	}

	// Metodo para mostrar el tercer menu y meterse en el tercer while
	public void terciario(String idCurs, String idModul) {
		Pt2.tercerBucle = false;
		main.lector.nextLine();
		while (!Pt2.tercerBucle) {
			System.out.print("Que vols fer amb el modul?\r\n" + "1. Canviar el nom de id\r\n"
					+ "2. Canviar de professor\r\n" + "3. Afegir UFs a id\r\n" + "4. Canviar una UF de id\r\n"
					+ "5. Treure una UF\r\n" + "6. TORNAR\r\n" + "Escull una opcio: ");
			int opcio = opcioMenu("terciari");// Metodo para comprobar el numero introducido pot teclado
			menuTerciario(opcio, idCurs, idModul);// Metodo para hacer las acciones del menu terciario
		}
	}

//	 Metodo para hacer las acciones del menu terciario
	private void menuTerciario(int opcio, String idCurs, String idModul) {
		switch (opcio) {
		case 1:
//			Introducir el nombre del modulo
			System.out.print("Introdueix el nom del modul(Acces a dades, Desenvolupament d’interficies): ");
			String nom = main.lector.nextLine();
//			Introducir el nuevo nombre del modulo al HashMap
			main.cursos.get(idCurs).moduls.get(idModul).setNom(nom);
			break;
		case 2:
			main.lector.nextLine();// Salto de linea en el lector
//			Introducir el nombre del profesor
			System.out.print("Introdueix el nom del professor: ");
			String profe = main.lector.nextLine();
//			Introducir el nuevo nombre del profesor al HashMap
			main.cursos.get(idCurs).moduls.get(idModul).setProfe(profe);
			break;
		case 3:
//			Metodo para introducir las UFs
			String UFs = main.cursos.get(idCurs).moduls.get(idModul).afegirUFs(idCurs, idModul);
			if (!UFs.isEmpty()) {// Comprobacion que no este vacio el String UFs
				UFs = main.convertirUpperCase(UFs);
				String[] ufsSeperadas = UFs.split("-");// Separar todas las UFs
//				Comprobacion que no esten repetidas
				for (int i = 0; i < ufsSeperadas.length; i++) {
					for (int j = 0; j < main.cursos.get(idCurs).moduls.get(idModul).getUfs().size(); j++) {
						if (ufsSeperadas[i].equals(main.cursos.get(idCurs).moduls.get(idModul).getUfs().get(j))) {
							ufsSeperadas[i] = null;// Igualar a null las UFs que estan repetidas
							break;
						}
					}
				}
				for (int i = 0; i < ufsSeperadas.length; i++) {
					if (ufsSeperadas[i] != null) {
//						Agregar uf al arrayList si no es null
						main.cursos.get(idCurs).moduls.get(idModul).ufs.add(ufsSeperadas[i]);
					}
				}
			}
			main.cursos.get(idCurs).moduls.get(idModul).ufs.sort(null);// Ordenacion de UFs
			break;
		case 4:
			boolean UFencontrada = false;
//			Metodo para introducir el nombre de una UF
			String uf = main.cursos.get(idCurs).moduls.get(idModul).canviarUF(idCurs, idModul);
			for (int i = 0; i < main.cursos.get(idCurs).moduls.get(idModul).getUfs().size(); i++) {
				if (uf.equals(main.cursos.get(idCurs).moduls.get(idModul).getUfs().get(i))) {
					main.lector.nextLine();// Salto de linea en el lector
					System.out.println("Introdueix el nom de la nova UF(Ej. UF1: Persistencia en BD no SQL):");
					String nuevaUF = main.lector.nextLine();// Introducir el nuevo nombre de UF
					boolean nombreUFnoRepetido = false;
					for (int j = 0; j < main.cursos.get(idCurs).moduls.get(idModul).getUfs().size(); j++) {
						if (nuevaUF.equals(main.cursos.get(idCurs).moduls.get(idModul).getUfs().get(j))) {
							System.out.println("El nom introduit esta repetit.");
							nombreUFnoRepetido = true;// El nombre introducio ya esta repetido
						}
					}
					if (!nombreUFnoRepetido) {// Si no esta repetido se cambia por el nuevo nombre
						main.cursos.get(idCurs).moduls.get(idModul).getUfs().set(i, nuevaUF);
					}
					UFencontrada = true;
					break;
				}
			}
			if (!UFencontrada) {
				System.out.println("No s'ha trobat la UF.");
			}
			main.cursos.get(idCurs).moduls.get(idModul).ufs.sort(null);// Ordenacion de UFs
			break;
		case 5:
//			Metodo para introducir las UFs
			String ufsAEliminar = main.cursos.get(idCurs).moduls.get(idModul).treureUFs(idCurs, idModul);
			String[] ufs = ufsAEliminar.split("-");// Separar las UFs
			for (int i = 0; i < ufs.length; i++) {
				for (int j = main.cursos.get(idCurs).moduls.get(idModul).getUfs().size() - 1; j >= 0; j--) {
					String[] ufArrayList = main.cursos.get(idCurs).moduls.get(idModul).getUfs().get(j).split(":");
					if (ufs[i].equals(ufArrayList[0])) {// Si los nombre coinciden se borra del ArrayList
						main.cursos.get(idCurs).moduls.get(idModul).getUfs().remove(j);
					}
				}
			}
			System.out.println("Se han borrado las ufs correctamente.");
			break;
		case 6:
			System.out.println("Has vuelto al menu anterior.");
			Pt2.tercerBucle = true;// Sales del tercer bucle para volver al segundo
			break;
		}
		System.out.println(idCurs + "= " + main.cursos.get(idCurs).toString());
		System.out.println();
	}

//	 Metodo para comprobar el numero introducido pot teclado
	public int opcioMenu(String menuActual) {// Le paso un String para saber desde que menu se lo paso
		int opcio = 0;
		boolean validacio = false;
		do {
			if (main.lector.hasNextInt()) {
				opcio = main.lector.nextInt();
				int maxOpcio = 5;// 5 numero maximo si es del primer menu
				if (menuActual.equals("secundari")) {
					maxOpcio = 7;// 7 numero maximo si es del segundo menu
				} else if (menuActual.equals("terciari")) {
					maxOpcio = 6;// 6 numero maximo si es del tercer menu
				}
				if (opcio >= 1 && opcio <= maxOpcio) {
					validacio = true;
				} else {
					main.lector.nextLine();
					System.out.print("->");
				}
			} else {
				main.lector.nextLine();
				System.out.print("->");
			}
		} while (!validacio == true);
		return opcio;
	}

//	 Metodo para convertir String todo en maysculas
	public String convertirUpperCase(String valor) {
		return valor.toUpperCase();
	}

//	 Metodo para introducir el nombre del curso
	public String nomDelCurs() {
		System.out.println("\nIntrodueix el nom del curs(Ej. DAM1, DAW1, DAM2, DAW2)");
		String idCurs = lector.next();
		idCurs = convertirUpperCase(idCurs);// Metodo para convertir String todo en maysculas
		return idCurs;
	}

	public static void main(String[] args) throws IOException {
//		Comprobacion si el archivo existe
		if (!archivo.exists()) {
			archivo.createNewFile();
		} else {
			dadesIn(archivo);// Metodo para leer el archivo
		}

		while (!primerBucle) {// Bucle para el primer menu
			main.principal();// Metodo para mostrar el menu por pantalla
		}

		dadesOut(archivo);// Metodo para guardar el archivo

	}

}
