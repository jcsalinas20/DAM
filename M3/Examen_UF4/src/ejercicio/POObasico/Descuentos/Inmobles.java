package ejercicio.POObasico.Descuentos;

public class Inmobles {

	String adresa;
	int metresQuadrats;
	String estat;
	int numAnys;

	public Inmobles(String adresa, int metresQuadrats, String estat, int numAnys) {
		super();
		this.adresa = adresa;
		this.metresQuadrats = metresQuadrats;
		this.estat = estat;
		this.numAnys = numAnys;
	}

	public Inmobles() {
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public int getMetresQuadrats() {
		return metresQuadrats;
	}

	public void setMetresQuadrats(int metresQuadrats) {
		this.metresQuadrats = metresQuadrats;
	}

	public String getEstat() {
		return estat;
	}

	public void setEstat(String estat) {
		if (estat.equalsIgnoreCase("nou")) {
			this.estat = estat;
		} else if (estat.equalsIgnoreCase("segona ma")) {
			this.estat = estat;
		}

	}

	public int getNumAnys() {
		return numAnys;
	}

	public void setNumAnys(int numAnys) {
		this.numAnys = numAnys;
	}

}
