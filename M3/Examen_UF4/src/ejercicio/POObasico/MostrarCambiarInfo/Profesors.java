package ejercicio.POObasico.MostrarCambiarInfo;

public class Profesors extends Empleat {

	float sou;
	int numHores;

	public Profesors(String nom, String cognoms, String nif, float sou, int numHores) {
		super(nom, cognoms, nif);
		this.sou = sou;
		this.numHores = numHores;
	}

	public Profesors() {
	}

	public float getSou() {
		return sou;
	}

	public void setSou(float sou) {
		this.sou = sou;
	}

	public int getNumHores() {
		return numHores;
	}

	public void setNumHores(int numHores) {
		this.numHores = numHores;
	}

	@Override
	public String toString() {
		return "Profesors [nom=" + nom + ", cognoms=" + cognoms + ", nif=" + nif + ", sou=" + sou + ", numHores="
				+ numHores + "]";
	}

}
