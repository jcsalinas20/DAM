import java.util.ArrayList;
import java.util.HashMap;

public class Curso {
	Modulo modulo = new Modulo();
	Main main = new Main();

	HashMap<String, Modulo> modulos = new HashMap<String, Modulo>();

	String id;
	String tutor;
	ArrayList<String> alumnos = new ArrayList<String>();

	public Curso(String id, String tutor, ArrayList<String> alumnos, HashMap<String, Modulo> modulos) {
		super();
		this.id = id;
		this.tutor = tutor;
		this.alumnos = alumnos;
		this.modulos = modulos;
	}

	public Curso() {
		super();
	}

	public void introducirIdCurso() {
		System.out.print("Introduce el ID del curso: ");
		id = Main.lector.next();
		Main.cursos.put(id, new Curso());
		Main.cursos.get(id).setId(id);

	}

	public void introducirNombreTutor() {
		Main.lector.nextLine();
		System.out.print("Introduce el nombre del tutor del curso: ");
		String tutor = Main.lector.nextLine();
		Main.cursos.get(id).setTutor(tutor);
	}

	public void introducirAlumnos() {
		ArrayList<String> alumnos = new ArrayList<String>();
		while (true) {
			System.out.print("Introduce el nombre del alumno del curso(\"0\" para terminar): ");
			String nombreAlumno = Main.lector.nextLine();
			if (nombreAlumno.equals("0")) {
				break;
			} else {
				alumnos.add(nombreAlumno);
			}
		}
		Main.cursos.get(id).setAlumnos(alumnos);
	}

	public void introducirModulos() {
		System.out.print("Introduce el ID del Modulo: ");
		String idModulo = Main.lector.next();
		Main.cursos.get(id).modulos.put(idModulo, new Modulo());
		Main.cursos.get(id).modulos.get(idModulo).setId(idModulo);

		while (true) {
			String nombreModulo = modulo.introducirNombreModulo();
			Main.cursos.get(id).modulos.get(idModulo).setNomModul(nombreModulo);
			System.out.println();

			ArrayList<String> profesores = modulo.introducirProfesores();
			Main.cursos.get(id).modulos.get(idModulo).setProfesores(profesores);
			System.out.println();

			ArrayList<String> ufs = modulo.introducirUfs();
			Main.cursos.get(id).modulos.get(idModulo).setUfs(ufs);
			System.out.println();

			idModulo = modulo.introducirIdModulo();
			if (idModulo.equals("0")) {
				break;
			}
			Main.cursos.get(id).modulos.put(idModulo, new Modulo());
			Main.cursos.get(id).modulos.get(idModulo).setId(idModulo);
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public ArrayList<String> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(ArrayList<String> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", tutor=" + tutor + ", alumnos=" + alumnos + ", modulos=" + modulos + "]";
	}

}
