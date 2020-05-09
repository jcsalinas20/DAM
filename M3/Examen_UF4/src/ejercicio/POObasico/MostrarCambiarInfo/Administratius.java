package ejercicio.POObasico.MostrarCambiarInfo;

public class Administratius extends Empleat {

	float sou;

	public Administratius(String nom, String cognoms, String nif, float sou) {
		super(nom, cognoms, nif);
		this.sou = sou;
	}
	
	public Administratius() {
		super();
	}

	public float getSou() {
		return sou;
	}

	public void setSou(float sou) {
		this.sou = sou;
	}

	@Override
	public String toString() {
		return "Administratius [nom=" + nom + ", cognoms=" + cognoms + ", nif=" + nif + ", sou=" + sou + "]";
	}

}
