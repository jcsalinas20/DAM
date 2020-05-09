import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
	static Curso curso = new Curso();

	static HashMap<String, Curso> cursos = new HashMap<String, Curso>();

	static boolean finPrograma = false;
	static File archivo = new File("cursos.xml");
	static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) throws Exception {

		while (!finPrograma) {
			mostrarMenu();
			int opcion = validarOpcion();
			opciones(opcion);
		}

		creacionFicheroXML();

	}

	private static void creacionFicheroXML() throws Exception {
		if (archivo.exists()) {
			archivo.delete();
		}
		archivo.createNewFile();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();

		Element raiz = doc.createElement("cursos");
		doc.appendChild(raiz);// Creacion del elemento raiz

		Iterator<String> iterator = cursos.keySet().iterator();
		while (iterator.hasNext()) {// Mostrar todos los cursos
			String key = iterator.next();

			Element curso = doc.createElement("curso");
			Attr idCurso = doc.createAttribute("id");
			idCurso.setValue(cursos.get(key).getId());
			curso.setAttributeNode(idCurso);// Creacion del atributo id dentro de curso
			raiz.appendChild(curso);// Creacion de la etiqueta curso

			Element tutor = doc.createElement("tutor");
			tutor.appendChild(doc.createTextNode(cursos.get(key).getTutor()));
			curso.appendChild(tutor);

			Element alumnos = doc.createElement("alumnos");
			curso.appendChild(alumnos);
			for (int i = 0; i < cursos.get(key).getAlumnos().size(); i++) {
				Element alumno = doc.createElement("alumno");
				alumno.appendChild(doc.createTextNode(cursos.get(key).getAlumnos().get(i)));
				alumnos.appendChild(alumno);
			}

			Element modulos = doc.createElement("modulos");
			curso.appendChild(modulos);
			Iterator<String> iterator2 = cursos.get(key).modulos.keySet().iterator();
			while (iterator2.hasNext()) {// Mostrar todos los cursos
				String keyModulo = iterator2.next();

				Element modulo = doc.createElement("modulo");
				Attr idModulo = doc.createAttribute("id");
				idModulo.setValue(cursos.get(key).modulos.get(keyModulo).getId());
				modulo.setAttributeNode(idModulo);// Creacion del atributo id dentro de curso
				modulos.appendChild(modulo);// Creacion de la etiqueta curso

				Element nombre = doc.createElement("nombre");
				nombre.appendChild(doc.createTextNode(cursos.get(key).modulos.get(keyModulo).getNomModul()));
				modulo.appendChild(nombre);

				Element profesores = doc.createElement("profesores");
				modulo.appendChild(profesores);
				for (int i = 0; i < cursos.get(key).modulos.get(keyModulo).getProfesores().size(); i++) {
					Element profesor = doc.createElement("profesor");
					profesor.appendChild(
							doc.createTextNode(cursos.get(key).modulos.get(keyModulo).getProfesores().get(i)));
					profesores.appendChild(profesor);
				}

				Element ufs = doc.createElement("ufs");
				modulo.appendChild(ufs);
				for (int i = 0; i < cursos.get(key).modulos.get(keyModulo).getUfs().size(); i++) {
					Element uf = doc.createElement("uf");
					uf.appendChild(doc.createTextNode(cursos.get(key).modulos.get(keyModulo).getUfs().get(i)));
					ufs.appendChild(uf);
				}
			}
		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult sResult = new StreamResult(archivo);

		t.transform(source, sResult);
	}

	private static void opciones(int opcion) {
		switch (opcion) {
		case 1:
			agregarCurso();
			break;
		case 2:
			agregarEliminarAlumnos("add");
			break;
		case 3:
			agregarEliminarAlumnos("del");
			break;
		case 4:
			finPrograma = true;
			System.out.println("Has salido del programa.");
			break;
		}
	}

	private static void agregarEliminarAlumnos(String accion) {
		System.out.print("Introduce el ID del curso: ");
		String id = lector.next();
		try {
			lector.nextLine();
			while (true) {
				System.out.print("Introduce el nombre del alumno del curso(\"0\" para terminar): ");
				String nombreAlumno = Main.lector.nextLine();
				if (nombreAlumno.equals("0")) {
					break;
				} else {
					if (accion.equals("del")) {
						cursos.get(id).alumnos.remove(nombreAlumno);
					} else {
						cursos.get(id).alumnos.add(nombreAlumno);
					}
				}
			}
			System.out.println("\n");
		} catch (NullPointerException e) {
			System.err.println("\nNo se ha encontrado el curso.\n\n");
		}
	}

	private static void agregarCurso() {
		curso.introducirIdCurso();

		curso.introducirNombreTutor();
		System.out.println();

		curso.introducirAlumnos();
		System.out.println();

		curso.introducirModulos();
		System.out.println();
	}

	private static int validarOpcion() {
		int opcion = 0;
		boolean validacion = false;
		do {
			if (lector.hasNextInt()) {
				opcion = lector.nextInt();
				if (opcion > 0 && opcion < 5) {
					validacion = true;
				} else {
					lector.nextLine();
					System.out.print("->");
				}
			} else {
				lector.nextLine();
				System.out.print("->");
			}
		} while (validacion != true);
		return opcion;
	}

	private static void mostrarMenu() {
		System.out.print(
				"1. Agregar curso\n2. Agregar alumnos\n3. Eliminar alumnos\n4. Salir del programa\n\nElige un aopcion:\n->");
	}

}
