import java.util.ArrayList;

public class Modulo {
	Main main = new Main();

	String id;
	String nomModul;
	ArrayList<String> profesores = new ArrayList<String>();
	ArrayList<String> ufs = new ArrayList<String>();

	public Modulo(String id, String nomModul, ArrayList<String> profesores, ArrayList<String> ufs) {
		super();
		this.id = id;
		this.nomModul = nomModul;
		this.profesores = profesores;
		this.ufs = ufs;
	}

	public Modulo() {
		super();
	}

	public String introducirIdModulo() {
		System.out.print("Introduce el ID del Modulo(\"0\" para terminar): ");
		String id = Main.lector.next();
		if (id.equals("0")) {
			return id;
		} else {
			setId(id);
			return id;
		}
	}

	public String introducirNombreModulo() {
		Main.lector.nextLine();
		System.out.print("Introduce el nombre del modulo: ");
		String nombreModulo = Main.lector.nextLine();
		return nombreModulo;
	}

	public ArrayList<String> introducirProfesores() {
		ArrayList<String> profes = new ArrayList<String>();
		System.out.print("Introduce el nombre del profesor: ");
		profes.add(Main.lector.nextLine());
		while (true) {
			System.out.print("Introduce el nombre del profesor(\"0\" para terminar): ");
			String nombreProfesor = Main.lector.nextLine();
			if (nombreProfesor.equals("0")) {
				break;
			} else {
				profes.add(nombreProfesor);
			}
		}
		return profes;
	}

	public ArrayList<String> introducirUfs() {
		ArrayList<String> ufs = new ArrayList<String>();
		while (true) {
			System.out.print("Introduce la UF del modulo(\"0\" para terminar): ");
			String uf = Main.lector.nextLine();
			if (uf.equals("0")) {
				break;
			} else {
				ufs.add(uf);
			}
		}
		return ufs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNomModul() {
		return nomModul;
	}

	public void setNomModul(String nomModul) {
		this.nomModul = nomModul;
	}

	public ArrayList<String> getProfesores() {
		return profesores;
	}

	public void setProfesores(ArrayList<String> profesores) {
		this.profesores = profesores;
	}

	public ArrayList<String> getUfs() {
		return ufs;
	}

	public void setUfs(ArrayList<String> ufs) {
		this.ufs = ufs;
	}

	@Override
	public String toString() {
		return " nomModul=" + nomModul + ", profesores=" + profesores + ", ufs=" + ufs + "]";
	}

}
