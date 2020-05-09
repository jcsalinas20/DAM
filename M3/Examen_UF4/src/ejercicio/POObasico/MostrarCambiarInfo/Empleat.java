package ejercicio.POObasico.MostrarCambiarInfo;

public class Empleat {

	String nom;
	String cognoms;
	String nif;

	public Empleat(String nom, String cognoms, String nif) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		this.nif = nif;
	}

	public Empleat() {
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

}
