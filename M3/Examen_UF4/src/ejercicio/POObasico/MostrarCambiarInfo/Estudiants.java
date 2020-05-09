package ejercicio.POObasico.MostrarCambiarInfo;

public class Estudiants {
	String nom;
	String cognoms;
	String nif;
	String nomCicle;
	int curs;

	public Estudiants(String nom, String cognoms, String nif, String nomCicle, int curs) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		this.nif = nif;
		this.nomCicle = nomCicle;
		this.curs = curs;
	}

	public Estudiants() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public String getNif() {
		return nif;
	}

	public String getNomCicle() {
		return nomCicle;
	}

	public void setNomCicle(String nomCicle) {
		this.nomCicle = nomCicle;
	}

	public int getCurs() {
		return curs;
	}

	public void setCurs(int curs) {
		this.curs = curs;
	}

	@Override
	public String toString() {
		return "Estudiants [nom=" + nom + ", cognoms=" + cognoms + ", nif=" + nif + ", nomCicle=" + nomCicle + ", curs="
				+ curs + "]";
	}

}
