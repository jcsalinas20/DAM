package Ejercicio1;

public class Estudiant {
	private String nomAlumne;
	private String cognomsAlumne;
	private String nifAlumne;
	private String nomCicleAlumne;
	private static int cursAlumne;

	public Estudiant(String nomAlumne, String cognomsAlumne, String nifAlumne, String nomCicleAlumne, int cursAlumne) {
		this.nomAlumne = nomAlumne;
		this.cognomsAlumne = cognomsAlumne;
		this.nifAlumne = nifAlumne;
		this.nomCicleAlumne = nomCicleAlumne;
		this.cursAlumne = cursAlumne;
	}

	static int cambioCurso(int nuevoCurso) {
		System.out.println(nuevoCurso);
		System.out.println(cursAlumne);
		
		if (nuevoCurso != cursAlumne) {
			
		}else {
			
		}

		return nuevoCurso;
	}

	public static void infoAlumno(Estudiant alumneCarlos) {
		System.out.println("Nom: " + alumneCarlos.getNomAlumne() + " " + alumneCarlos.getCognomsAlumne() + "\nNIF: "
				+ alumneCarlos.getNifAlumne() + "\nCicle: " + alumneCarlos.getNomCicleAlumne() + "\nCurs: "
				+ alumneCarlos.getCursAlumne());
		;
	}

	public String getNomAlumne() {
		return nomAlumne;
	}

	public void setNomAlumne(String nomAlumne) {
		this.nomAlumne = nomAlumne;
	}

	public String getCognomsAlumne() {
		return cognomsAlumne;
	}

	public void setCognomsAlumne(String cognomsAlumne) {
		this.cognomsAlumne = cognomsAlumne;
	}

	public String getNifAlumne() {
		return nifAlumne;
	}

	public void setNifAlumne(String nifAlumne) {
		this.nifAlumne = nifAlumne;
	}

	public String getNomCicleAlumne() {
		return nomCicleAlumne;
	}

	public void setNomCicleAlumne(String nomCicleAlumne) {
		this.nomCicleAlumne = nomCicleAlumne;
	}

	public int getCursAlumne() {
		return cursAlumne;
	}

	public void setCursAlumne(int cursAlumne) {
		this.cursAlumne = cursAlumne;
	}

}
