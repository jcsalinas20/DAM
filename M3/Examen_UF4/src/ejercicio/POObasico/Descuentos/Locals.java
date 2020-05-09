package ejercicio.POObasico.Descuentos;

public class Locals extends Inmobles {

	int numFinestres;
	float preu;

	public Locals(String adresa, int metresQuadrats, String estat, int numAnys, float preu, int numFinestres) {
		super(adresa, metresQuadrats, estat, numAnys);
		this.numFinestres = numFinestres;
		this.preu = preu;
	}

	public Locals() {
	}

	public int getNumFinestres() {
		return numFinestres;
	}

	public void setNumFinestres(int numFinestres) {
		this.numFinestres = numFinestres;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		if (metresQuadrats > 50) {
			preu = preu * 1.01f;
		}
		if (numFinestres <= 1) {
			preu = preu * 0.98f;
		} else if (numFinestres >= 4) {
			preu = preu * 1.02f;
		}
		if (numAnys < 15) {
			preu = preu * 0.99f;
		} else {
			preu = preu * 0.98f;
		}
		this.preu = preu;
	}

	@Override
	public String toString() {
		return "Locals [numFinestres=" + numFinestres + ", adresa=" + adresa + ", metresQuadrats=" + metresQuadrats
				+ ", estat=" + estat + ", numAnys=" + numAnys + ", preu=" + preu + "]";
	}

}
