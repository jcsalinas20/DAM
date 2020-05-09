package ejercicio.POObasico.Descuentos;

public class Pisos extends Inmobles {

	int numPis;
	float preu;

	@Override
	public String toString() {
		return "Pisos [numPis=" + numPis + ", adresa=" + adresa + ", metresQuadrats=" + metresQuadrats + ", estat="
				+ estat + ", numAnys=" + numAnys + ", preu=" + preu + "]";
	}

	public int getNumPis() {
		return numPis;
	}

	public void setNumPis(int numPis) {
		this.numPis = numPis;
	}

	public float getPreu() {
		return preu;
	}

	public void setPreu(float preu) {
		if (numPis >= 3) {
			preu = preu * 1.03f;
		}
		if (numAnys < 15) {
			preu = preu * 0.99f;
		} else {
			preu = preu * 0.98f;
		}
		this.preu = preu;
	}

	public Pisos(String adresa, int metresQuadrats, String estat, int numAnys, float preu, int numPis) {
		super(adresa, metresQuadrats, estat, numAnys);
		this.numPis = numPis;
		this.preu = preu;
	}

	public Pisos() {
	}

}
